package info.fandroid.spiderdefense.states_of_the_game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import info.fandroid.spiderdefense.SpiderDefense;
import info.fandroid.spiderdefense.states_of_the_game.levels.Village;

/**
 * Created by ZZZ on 21.11.2016.
 */

public class MainMenuState extends StateOfTheGame{
    private Texture startimg;
    private Texture exitimg;
    private Texture webimg;

    public MainMenuState(GameStateManager gsm) {
        super(gsm);
        startimg = new Texture("start.png");
        exitimg = new Texture("exit.png");
        webimg = new Texture("web.png");
    }

    @Override
    protected void handleinput() {
        if(Gdx.input.justTouched()) {
            if ((Gdx.input.getY() < Gdx.graphics.getHeight() / 10) && (Gdx.input.getY() > 0) && (Gdx.input.getX() > Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 10) && (Gdx.input.getX() < Gdx.graphics.getWidth() / 2 + Gdx.graphics.getWidth() / 10)) {
                gsm.push(new Village(gsm));
                dispose();
            }
            if ((Gdx.input.getY() > Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 10) && (Gdx.input.getY() < Gdx.graphics.getHeight()) && (Gdx.input.getX() > Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 10) && (Gdx.input.getX() < Gdx.graphics.getWidth() / 2 + Gdx.graphics.getWidth() / 10)) {
                Gdx.app.exit();
                dispose();
            }
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
        sb.draw(webimg, 0, 0, SpiderDefense.WIDTH, SpiderDefense.HEIGHT);
        sb.draw(startimg, 150, 500, 100, 100);
        sb.draw(exitimg, 150, 0, 100, 100);
        sb.end();
    }

    @Override
    protected void dispose() {

    }
}
