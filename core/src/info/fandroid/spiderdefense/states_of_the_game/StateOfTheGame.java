package info.fandroid.spiderdefense.states_of_the_game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import info.fandroid.spiderdefense.MainSpider;
import info.fandroid.spiderdefense.Skill;
import info.fandroid.spiderdefense.SuperSkill;
import info.fandroid.spiderdefense.game_play.GamePlay;

/**
 * Created by ZZZ on 21.11.2016.
 */

public abstract class StateOfTheGame {
    protected OrthographicCamera camera;
    protected Vector3 mouse;
    protected GameStateManager gsm;
    public Array<Texture> localtexsuperskills = new Array<Texture>();
    public Array<Texture> texskills = new Array<Texture>();
    public Array<Texture> texsuperskills = new Array<Texture>();
    public Array<Integer> skillsd = new Array<Integer>();
    public Array<Integer> superskillsd = new Array<Integer>();
    public Array<Integer> ammunition = new Array<Integer>();
    public Array<Integer> superammunition = new Array<Integer>();
    public Array<SuperSkill> ss = new Array<SuperSkill>();
    public MainSpider spider;
    public BitmapFont font = new BitmapFont();
    public int speed;
    public int progress;
    public int coun_ammunition_ss;
    public int coun_ammunition;

    public StateOfTheGame(GameStateManager gsm){
        this.gsm = gsm;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 400, 600);
        mouse = new Vector3();
    }

    protected abstract void handleinput();
    protected abstract void update(float dt);
    protected abstract void render(SpriteBatch sb);
    protected abstract void dispose();

}
