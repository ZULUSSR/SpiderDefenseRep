package info.fandroid.spiderdefense.states_of_the_game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import info.fandroid.spiderdefense.SpiderDefense;
import info.fandroid.spiderdefense.states_of_the_game.levels.Village;

/**
 * Created by ZZZ on 04.12.2016.
 */

public class WinLevelState extends StateOfTheGame {
    Preferences sp = Gdx.app.getPreferences("SkillsPreferences");
    Texture winimg;
    Texture ptfimg;
    Texture ptimg;
    public WinLevelState(GameStateManager gsm) {
        super(gsm);
        sp.putBoolean("poisonousthorn", true);
        winimg = new Texture("win.png");
        ptfimg = new Texture("poisonousthornframe.png");
        ptimg = new Texture("poisonousthorn.png");
    }

    @Override
    protected void handleinput() {
        if(Gdx.input.justTouched()){
            gsm.pop();
            gsm.pop();
            gsm.pop();
            gsm.push(new Village(gsm));
        }
    }

    @Override
    protected void update(float dt) {
        handleinput();
    }

    @Override
    protected void render(SpriteBatch sb) {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        sb.setProjectionMatrix(camera.combined);
        camera.update();
        sb.begin();
        sb.draw(winimg, 0, 0, SpiderDefense.WIDTH, SpiderDefense.HEIGHT);
        sb.draw(ptfimg, 0, 0, 400, 400);
        sb.draw(ptimg, 100, 100, 200, 200);
        sb.end();
    }

    @Override
    protected void dispose() {

    }
}
