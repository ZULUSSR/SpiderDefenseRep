package info.fandroid.spiderdefense.states_of_the_game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import info.fandroid.spiderdefense.states_of_the_game.levels.Village;

/**
 * Created by ZZZ on 04.12.2016.
 */

public class GameOverState extends StateOfTheGame {
    Texture gameoverimg;

    public GameOverState(GameStateManager gsm) {
        super(gsm);
        gameoverimg = new Texture("gameover.png");
    }

    @Override
    protected void handleinput() {
        if(Gdx.input.justTouched()){
            if((Gdx.input.getY() > Gdx.graphics.getHeight()/2 + Gdx.graphics.getHeight()/12)&&(Gdx.input.getY() < Gdx.graphics.getHeight()/2 + Gdx.graphics.getHeight()/6)) {
                gsm.pop();
                gsm.pop();
                gsm.pop();
            }
            if((Gdx.input.getY() > Gdx.graphics.getHeight()/6 + Gdx.graphics.getHeight()/12)&&(Gdx.input.getY() < Gdx.graphics.getHeight()/3 + Gdx.graphics.getHeight()/12)) {
                gsm.pop();
                gsm.pop();
                gsm.pop();
                gsm.push(new Village(gsm));
            }
        }
    }

    @Override
    protected void update(float dt) {
        handleinput();

    }

    @Override
    protected void render(SpriteBatch sb) {
        gsm.state(1).render(sb);
        sb.begin();
        sb.draw(gameoverimg, 0, 200, 400, 400);
        sb.end();
    }

    @Override
    protected void dispose() {

    }
}
