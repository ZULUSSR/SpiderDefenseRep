package info.fandroid.spiderdefense.game_play;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import info.fandroid.spiderdefense.Enemy;
import info.fandroid.spiderdefense.MainSpider;
import info.fandroid.spiderdefense.ProgressBar;
import info.fandroid.spiderdefense.SpiderDefense;
import info.fandroid.spiderdefense.Skill;
import info.fandroid.spiderdefense.states_of_the_game.GameOverState;
import info.fandroid.spiderdefense.states_of_the_game.GameStateManager;
import info.fandroid.spiderdefense.states_of_the_game.NextLevelState;
import info.fandroid.spiderdefense.states_of_the_game.PauseState;
import info.fandroid.spiderdefense.states_of_the_game.StateOfTheGame;
import info.fandroid.spiderdefense.states_of_the_game.WinLevelState;

/**
 * Created by ZZZ on 21.11.2016.
 */

public class GamePlay extends StateOfTheGame{
    ProgressBar pb;
    Enemy classenemy = new Enemy();
    Skill classskill = new Skill();
    Array<Integer> enemysdamage;
    Array<Texture> texenemys;
    Array<Enemy> enemys;
    Array<Skill> skills;
    Texture webimg;
    Texture backgroundimg;
    Texture lifeimg;
    Texture pauseimg;
    boolean lifesteal = false;
    boolean freeze = false;
    long lastenemytime;
    int counenemys;
    int curindex;

    public GamePlay(GameStateManager gsm){
        super(gsm);
        webimg = new Texture("web.png");
        lifeimg = new Texture("life.png");
        pauseimg = new Texture("pause.png");
        spider = new MainSpider();
        pb = new ProgressBar();
        enemys = new Array<Enemy>();
        skills = new Array<Skill>();
        texenemys = new Array<Texture>();
    }

    public void create(Texture bg, Array<Texture> tenemys, Array<Integer> ed, int counen){
        backgroundimg = bg;
        speed = 1;
        progress = 1;
        texenemys = tenemys;
        enemysdamage = ed;
        counenemys = counen;
    }

    void checkgameover(MainSpider spider){
        if(spider.spiderhealthpoint < 0){
            gsm.push(new GameOverState(gsm));
        }
    }

    void checknextlevel(ProgressBar pb){
        if(pb.delta == 400){
            enemys.clear();
            progress++;
            speed++;
            if(progress == 6){
                gsm.set(new WinLevelState(gsm));
            }else {
                pb.delta = 0;
                NextLevelState nls = new NextLevelState(gsm);
                nls.progress = progress;
                nls.create();
                gsm.push(nls);
            }
        }
    }

    void attackenemys(Array<Enemy> arre, Array<Skill> arrs){
        for(Skill skill: arrs){
            for(Enemy enemy: arre) {
                if(skill.ourskill.getBoundingRectangle().overlaps(enemy.ourenemy.getBoundingRectangle())){
                    if(lifesteal == true){
                        spider.spiderhealthpoint += skill.damage;
                    }
                    enemy.healthpoint -= skill.damage;
                    arrs.removeValue(skill, false);
                    if(enemy.healthpoint <= 0){
                        arre.removeValue(enemy, false);
                    }
                    break;
                }
            }
        }
    }

    public void draw(SpriteBatch sb){
        sb.draw(webimg, 0, 200, 400, 400);
        classskill.draw(sb, skills);
        classenemy.draw(sb, enemys);
        sb.draw(pauseimg, 0, 0, 400, 143);
        spider.draw(sb);
        pb.draw(sb);
        int i = 0;
        for(Texture tex: texskills){
            sb.draw(tex, 0 + i, 143, 57, 57);
            i+=57;
        }
        int a = 0;
        for(Integer am: ammunition){
            font.draw(sb, "" + am, 20 + a, 175);
            a+=57;
        }
        int j = 228;
        for(Texture texss: localtexsuperskills){
            sb.draw(texss, 0 + j, 143, 57, 57);
            j+=57;
        }
        int b = 228;
        for(Integer sam: superammunition){
            font.draw(sb, "" + sam, 20 + b, 175);
            b+=57;
        }
        sb.draw(lifeimg, 171, 143, 57, 57);
        font.draw(sb, "" + spider.spiderhealthpoint, 185, 175);
    }

    @Override
    protected void handleinput() {
        if(Gdx.input.justTouched()){
            if(Gdx.input.getY() < Gdx.graphics.getHeight()/2 + Gdx.graphics.getHeight()/6) {
                if(ammunition.get(curindex) != 0) {
                    classskill = new Skill();
                    classskill.create(texskills.first(), skillsd.first());
                    classskill.spawnskill(Gdx.input.getX(), Gdx.input.getY());
                    ammunition.insert(curindex, ammunition.removeIndex(curindex) - 1);
                    skills.add(classskill);
                }
            }else {
                if (Gdx.input.getY() < Gdx.graphics.getHeight() / 2 + Gdx.graphics.getHeight() / 4) {
                    if ((Gdx.input.getX() < Gdx.graphics.getWidth() / 7)) {
                        curindex = 0;
                    }
                    if ((Gdx.input.getX() > Gdx.graphics.getWidth() / 7) && (Gdx.input.getX() < 2 * Gdx.graphics.getWidth() / 7)) {
                        curindex = 1;
                    }
                    if ((Gdx.input.getX() > 2 * Gdx.graphics.getWidth() / 7) && (Gdx.input.getX() < 3 * Gdx.graphics.getWidth() / 7)) {
                        curindex = 2;
                    }
                    if ((Gdx.input.getX() > 4 * Gdx.graphics.getWidth() / 7) && (Gdx.input.getX() < 5 * Gdx.graphics.getWidth() / 7)) {
                        if (superammunition.get(0) != 0) {
                            ss.get(0).attack(freeze, lifesteal, skills, texsuperskills.get(0), superskillsd.get(0));
                            superammunition.insert(0, superammunition.removeIndex(0) - 1);
                        }
                    }
                    if ((Gdx.input.getX() > 5 * Gdx.graphics.getWidth() / 7) && (Gdx.input.getX() < 6 * Gdx.graphics.getWidth() / 7)) {
                        if (superammunition.get(1) != 0) {
                            ss.get(1).attack(freeze, lifesteal, skills, texsuperskills.get(1), superskillsd.get(1));
                            superammunition.insert(1, superammunition.removeIndex(1) - 1);
                        }
                    }
                    if ((Gdx.input.getX() > 6 * Gdx.graphics.getWidth() / 7) && (Gdx.input.getX() < 7 * Gdx.graphics.getWidth() / 7)) {
                        if (superammunition.get(2) != 0) {
                            ss.get(2).attack(freeze, lifesteal, skills, texsuperskills.get(2), superskillsd.get(2));
                            superammunition.insert(2, superammunition.removeIndex(2) - 1);
                        }
                    }
                }
            }
            if ((Gdx.input.getY() > Gdx.graphics.getHeight() - Gdx.graphics.getHeight()/8) && (Gdx.input.getX() > Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth()/4) && (Gdx.input.getX() < Gdx.graphics.getWidth() / 2 + Gdx.graphics.getWidth()/4)){
                gsm.push(new PauseState(gsm));
            }
        }
        spider.rotate(Gdx.input.getX(),Gdx.input.getY());
    }

    @Override
    protected void update(float dt) {
        handleinput();
        checkgameover(spider);
        checknextlevel(pb);
        pb.update(dt);
        if(pb.delta < 370) {
            if (TimeUtils.millis() - lastenemytime > 1800 / speed) {
                int rand;
                rand = MathUtils.random(0, counenemys - 1);
                classenemy = new Enemy();
                classenemy.create(texenemys.get(rand), enemysdamage.get(rand));
                classenemy.spawn();
                enemys.add(classenemy);
                lastenemytime = TimeUtils.millis();
            }
        }
        classskill.attack(skills);
        if(freeze == false) {
            classenemy.attack(enemys, spider, speed);
        }
        attackenemys(enemys, skills);
    }

    @Override
    protected void render(SpriteBatch sb) {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        draw(sb);
        sb.end();
    }

    @Override
    protected void dispose() {

    }
}
