package info.fandroid.spiderdefense.inventory_super_skill;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import info.fandroid.spiderdefense.states_of_the_game.GameStateManager;
import info.fandroid.spiderdefense.states_of_the_game.StateOfTheGame;

/**
 * Created by ZZZ on 28.11.2016.
 */

public class InventorySuperSkills extends StateOfTheGame{
    MassBabySpiders mbs = new MassBabySpiders();
    Preferences ssp = Gdx.app.getPreferences("SuperSkillsPreferences");
    Texture babyspiderimg = new Texture("bs.png");
    Texture massbabyspiderimg = new Texture("mbs.png");
    Texture mbsframeimg = new Texture("mbsframe.png");
    Texture ioimg = new Texture("indefiniteobject.png");
    Texture selectimg = new Texture("select.png");
    Texture notlearnedimg = new Texture("io.png");
    Texture backimg = new Texture("back.png");
    Texture nextimg = new Texture("next.png");
    int max = 0; //max = 3
    int curlist = 1;

    public InventorySuperSkills(GameStateManager gsm) {
        super(gsm);
        localtexsuperskills.insert(0, ioimg);
        localtexsuperskills.insert(1, ioimg);
        localtexsuperskills.insert(2, ioimg);
        texsuperskills.insert(0, ioimg);
        texsuperskills.insert(1, ioimg);
        texsuperskills.insert(2, ioimg);
        ssp.putBoolean("mbs", true);
        ssp.flush();
        max = 0;
    }

    @Override
    protected void handleinput() {
        if(Gdx.input.justTouched()) {
            if (ssp.getBoolean("mbs")) {
                if ((Gdx.input.getX() > Gdx.graphics.getWidth()/2) && (Gdx.input.getY() < Gdx.graphics.getHeight()/3)) {
                    localtexsuperskills.removeIndex(max);
                    localtexsuperskills.insert(max, massbabyspiderimg);
                    texsuperskills.removeIndex(max);
                    texsuperskills.insert(max, babyspiderimg);
                    superskillsd.insert(max, 15);
                    superammunition.insert(max, 20);
                    ss.insert(max, mbs);
                    coun_ammunition_ss++;
                    gsm.state(curlist).localtexsuperskills = localtexsuperskills;
                    gsm.state(curlist).texsuperskills = texsuperskills;
                    gsm.state(curlist).superskillsd = superskillsd;
                    gsm.state(curlist).superammunition = superammunition;
                    gsm.state(curlist).coun_ammunition_ss = coun_ammunition_ss;
                    gsm.state(curlist).ss = ss;
                    ++max;
                    if(max == 3){
                        max = 0;
                    }
                }
            }
            if (ssp.getBoolean("freeze")) {
                if ((Gdx.input.getX() > 200) && (Gdx.input.getY() < 200))if ((Gdx.input.getX() > Gdx.graphics.getWidth()/2) && (Gdx.input.getY() > Gdx.graphics.getHeight()/3) && (Gdx.input.getY() < Gdx.graphics.getHeight()/2 + Gdx.graphics.getHeight()/6)) {
                    localtexsuperskills.removeIndex(max);
                    localtexsuperskills.insert(max, massbabyspiderimg);
                    texsuperskills.removeIndex(max);
                    texsuperskills.insert(max, babyspiderimg);
                    superskillsd.insert(max, 15);
                    superammunition.insert(max, 5);
                    ss.insert(max, mbs);
                    coun_ammunition_ss++;
                    gsm.state(curlist).localtexsuperskills = localtexsuperskills;
                    gsm.state(curlist).texsuperskills = texsuperskills;
                    gsm.state(curlist).superskillsd = superskillsd;
                    gsm.state(curlist).superammunition = superammunition;
                    gsm.state(curlist).coun_ammunition_ss = coun_ammunition_ss;
                    gsm.state(curlist).ss = ss;
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
        if(ssp.getBoolean("mbs")){
            sb.draw(mbsframeimg, 0, 400, 200, 200);
            sb.draw(selectimg, 200, 400, 200, 200);
            sb.draw(massbabyspiderimg, 50, 450, 100, 100);
        }else{
            sb.draw(ioimg, 0, 400, 200, 200);
            sb.draw(notlearnedimg, 200, 400, 200, 200);
        }
        if(ssp.getBoolean("freeze")){
            sb.draw(mbsframeimg, 0, 200, 200, 200);
            sb.draw(selectimg, 200, 200, 200, 200);
            sb.draw(massbabyspiderimg, 50, 250, 100, 100);
        }else{
            sb.draw(ioimg, 0, 200, 200, 200);
            sb.draw(notlearnedimg, 200, 200, 200, 200);
        }
        int i = 0;
        for(Texture tex: localtexsuperskills){
            sb.draw(tex, 0 + i, 100, 133, 100);
            i+=133;
        }
        int a = 0;
        for(Integer am: superammunition){
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
