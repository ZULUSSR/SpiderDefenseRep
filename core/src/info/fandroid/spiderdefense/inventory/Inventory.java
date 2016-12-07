package info.fandroid.spiderdefense.inventory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import info.fandroid.spiderdefense.Skill;
import info.fandroid.spiderdefense.states_of_the_game.GameStateManager;
import info.fandroid.spiderdefense.states_of_the_game.StateOfTheGame;

/**
 * Created by ZZZ on 28.11.2016.
 */

public class Inventory extends StateOfTheGame{
    Preferences sp = Gdx.app.getPreferences("SkillsPreferences");
    Texture poisonimg = new Texture("poison1.png");
    Texture poisonousthornimg = new Texture("poisonousthorn.png");
    Texture ioimg = new Texture("indefiniteobject.png");
    Texture poisonframeimg = new Texture("poisonframe.png");
    Texture selectimg = new Texture("select.png");
    Texture notlearnedimg = new Texture("io.png");
    Texture backimg = new Texture("back.png");
    Texture nextimg = new Texture("next.png");
    int max = 0; //max = 2
    int curlist = 1;

    public Inventory(GameStateManager gsm) {
        super(gsm);
        sp.putBoolean("poison", true);
        sp.flush();
        texskills.insert(0, ioimg);
        texskills.insert(1, ioimg);
        texskills.insert(2, ioimg);
    }

    @Override
    protected void handleinput() {
        if(Gdx.input.justTouched()) {
            if (sp.getBoolean("poison")) {
                if ((Gdx.input.getX() > Gdx.graphics.getWidth()/2) && (Gdx.input.getY() < Gdx.graphics.getHeight()/3)) {
                    texskills.removeIndex(max);
                    texskills.insert(max, poisonimg);
                    skillsd.insert(max, 5);
                    ammunition.insert(max, 100);
                    coun_ammunition++;
                    gsm.state(curlist).texskills = texskills;
                    gsm.state(curlist).skillsd = skillsd;
                    gsm.state(curlist).ammunition = ammunition;
                    gsm.state(curlist).coun_ammunition = coun_ammunition;
                    ++max;
                    if(max == 3){
                        max = 0;
                    }
                }
            }
            if(sp.getBoolean("poisonousthorn")){
                if ((Gdx.input.getX() > Gdx.graphics.getWidth()/2) && (Gdx.input.getY() > Gdx.graphics.getHeight()/3) && (Gdx.input.getY() < Gdx.graphics.getHeight()/2 + Gdx.graphics.getHeight()/6)){
                    texskills.insert(max, poisonousthornimg);
                    skillsd.insert(max, 10);
                    ammunition.insert(max, 25);
                    coun_ammunition++;
                    gsm.state(curlist).texskills = texskills;
                    gsm.state(curlist).skillsd = skillsd;
                    gsm.state(curlist).ammunition = ammunition;
                    gsm.state(curlist).coun_ammunition = coun_ammunition;
                    ++max;
                    if(max == 3){
                        max = 0;
                    }
                }
            }
            if ((Gdx.input.getX() < 200) && (Gdx.input.getY() > 500)){
                gsm.pop();
            }
            if ((Gdx.input.getX() > 200) && (Gdx.input.getY() > 500)){
                System.out.print("next");
            }
        }
    }

    public void draw(SpriteBatch sb){
        if(sp.getBoolean("poison")){
            sb.draw(poisonframeimg, 0, 400, 200, 200);
            sb.draw(selectimg, 200, 400, 200, 200);
            sb.draw(poisonimg, 50, 450, 100, 100);
        }else{
            sb.draw(ioimg, 0, 400, 200, 200);
            sb.draw(notlearnedimg, 200, 400, 200, 200);
        }
        if(sp.getBoolean("poisonousthorn")){
            sb.draw(poisonframeimg, 0, 200, 200, 200);
            sb.draw(selectimg, 200, 200, 200, 200);
            sb.draw(poisonousthornimg, 50, 250, 100, 100);
        }else{
            sb.draw(ioimg, 0, 200, 200, 200);
            sb.draw(notlearnedimg, 200, 200, 200, 200);
        }
        int i = 0;
        for(Texture tex: texskills){
            sb.draw(tex, 0 + i, 100, 133, 100);
            i+=133;
        }
        int a = 0;
        for(Integer am: ammunition){
            font.draw(sb, "" + am, 60 + a, 150);
            a+=133;
        }
        sb.draw(nextimg, 200, 0, 200, 100);
        sb.draw(backimg, 0, 0, 200, 100);
    }

    @Override
    protected void update(float dt) {

    }

    @Override
    protected void render(SpriteBatch sb) {
        handleinput();
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
