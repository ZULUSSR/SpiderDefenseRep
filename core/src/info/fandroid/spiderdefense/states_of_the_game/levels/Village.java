package info.fandroid.spiderdefense.states_of_the_game.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import info.fandroid.spiderdefense.MainSpider;
import info.fandroid.spiderdefense.ProgressBar;
import info.fandroid.spiderdefense.game_play.GamePlay;
import info.fandroid.spiderdefense.inventory.Inventory;
import info.fandroid.spiderdefense.inventory_super_skill.InventorySuperSkills;
import info.fandroid.spiderdefense.states_of_the_game.GameStateManager;
import info.fandroid.spiderdefense.states_of_the_game.StateOfTheGame;

/**
 * Created by ZZZ on 21.11.2016.
 */

public class Village extends StateOfTheGame {
    ProgressBar pb;
    protected GamePlay gm;
    protected Array<Texture> enemys = new Array<Texture>();
    protected Array<Integer> enemysdamage = new Array<Integer>();
    protected int counenemys = 2;
    protected Texture background = new Texture("poison1.png");
    Texture skillsimg;
    Texture superskillsimg;
    Texture lifeimg;
    Texture webimg;
    Texture day1img;
    public Village(GameStateManager gsm) {
        super(gsm);
        Texture enemy1img = new Texture("enemy1.png");
        Texture enemy2img = new Texture("enemy2.png");
        enemys.add(enemy1img);
        enemys.add(enemy2img);
        enemysdamage.add(2);
        enemysdamage.add(5);
        webimg = new Texture("web.png");
        lifeimg = new Texture("life.png");
        day1img = new Texture("day1.png");
        skillsimg = new Texture("skills.png");
        superskillsimg = new Texture("superskills.png");
        spider = new MainSpider();
        pb = new ProgressBar();
    }


    @Override
    protected void handleinput() {
        if (Gdx.input.justTouched()) {
            if ((Gdx.input.getY() > 500) && (Gdx.input.getX() > Gdx.graphics.getWidth() / 2 - 100) && (Gdx.input.getX() < Gdx.graphics.getWidth() / 2 + 100)) {
                if ((coun_ammunition_ss >= 3) && (coun_ammunition >= 3)){
                    gm = new GamePlay(gsm);
                    gm.create(background, enemys, enemysdamage, counenemys);
                    gm.texskills = texskills;
                    gm.skillsd = skillsd;
                    gm.ammunition = ammunition;
                    gm.texsuperskills = texsuperskills;
                    gm.superskillsd = superskillsd;
                    gm.superammunition = superammunition;
                    gm.localtexsuperskills = localtexsuperskills;
                    gm.ss = ss;
                    gsm.push(gm);
                }
            }
            if((Gdx.input.getY() < 100)&&(Gdx.input.getX() < Gdx.graphics.getWidth()/2)){
                gsm.push(new Inventory(gsm));
            }
            if((Gdx.input.getY() < 100)&&(Gdx.input.getX() > Gdx.graphics.getWidth()/2)){
                gsm.push(new InventorySuperSkills(gsm));
            }
        }
    }

    public void draw(SpriteBatch sb){
        sb.draw(webimg, 0, 200, 400, 400);
        sb.draw(day1img, 0, 0, 400, 143);
        sb.draw(skillsimg, 0, 500, 100, 100);
        sb.draw(superskillsimg, 300, 500, 100, 100);
        spider.draw(sb);
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
    protected void update(float dt) {
        handleinput();
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
