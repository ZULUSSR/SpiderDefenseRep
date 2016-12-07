package info.fandroid.spiderdefense;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import info.fandroid.spiderdefense.states_of_the_game.GameStateManager;
import info.fandroid.spiderdefense.states_of_the_game.MainMenuState;

/**
 * Created by ZZZ on 05.11.2016.
 */

public class SpiderDefense extends ApplicationAdapter{
    public static final int WIDTH = 400;
    public static final int HEIGHT = 600;

    private GameStateManager gsm;
    private SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        gsm = new GameStateManager();
        gsm.push(new MainMenuState(gsm));
    }

    @Override
    public void render(){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
