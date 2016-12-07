package info.fandroid.spiderdefense.states_of_the_game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by ZZZ on 21.11.2016.
 */

public class GameStateManager {
    private Stack<StateOfTheGame> sotg;

    public GameStateManager(){
        sotg = new Stack<StateOfTheGame>();
    }

    public void push(StateOfTheGame state){
        sotg.push(state);
    }

    public void pop(){
        sotg.pop().dispose();
    }

    public void set(StateOfTheGame state){
        sotg.pop().dispose();
        sotg.push(state);
    }

    public StateOfTheGame our_state(){
        return sotg.peek();
    }

    public StateOfTheGame state(int index){
        return sotg.get(sotg.size() - 1 - index);
    }

    public void update(float dt){
        sotg.peek().update(dt);
    }

    public void render(SpriteBatch sb){
        sotg.peek().render(sb);
    }
}
