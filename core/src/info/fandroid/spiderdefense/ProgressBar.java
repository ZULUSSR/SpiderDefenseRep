package info.fandroid.spiderdefense;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.TimeUtils;

import java.sql.Time;

/**
 * Created by ZZZ on 03.12.2016.
 */

public class ProgressBar {
    Texture pb;
    TextureRegion tr;
    public int delta;
    long lasttime;

    public ProgressBar(){
        pb = new Texture("progressbar.png");
        tr = new TextureRegion(pb, 0, 0, 0, 200);
        delta = 0;
        lasttime = 0;
    }

    public void update(float dt){
        if(TimeUtils.nanoTime() - lasttime > 100000000) {
            ++delta;
            tr.setRegion(0, 0, delta, 200);
            lasttime = TimeUtils.nanoTime();
        }
    }


    public void draw(SpriteBatch sb){
        sb.draw(tr, 0, 0, delta, 143);
    }
}
