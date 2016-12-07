package info.fandroid.spiderdefense.states_of_the_game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by ZZZ on 22.11.2016.
 */

public class PauseState extends StateOfTheGame {
    Texture continueimg;

    public PauseState(GameStateManager gsm) {
        super(gsm);
        continueimg = new Texture("continue.png");
    }

    @Override
    protected void handleinput() {
        if(Gdx.input.justTouched()){
            if ((Gdx.input.getY() > 500) && (Gdx.input.getX() > Gdx.graphics.getWidth() / 2 - 100) && (Gdx.input.getX() < Gdx.graphics.getWidth() / 2 + 100)){
                gsm.pop();
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
        sb.draw(continueimg, 0, 0, 400, 143);
        sb.end();
    }

    @Override
    protected void dispose() {

    }
}
