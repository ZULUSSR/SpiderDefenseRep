package info.fandroid.spiderdefense;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Map;

/**
 * Created by ZZZ on 07.11.2016.
 */

public class MainSpider {
    public int spiderhealthpoint;
    public int spiderstrength;
    public int spideragi;
    public int level;
    public int exp;
    Sprite spider;
    public MainSpider(){
        Texture spiderimg = new Texture("spider.png");
        spider = new Sprite(spiderimg);
        spider.setPosition(170,370);
        spider.setSize(60,60);
        spider.setOrigin(30,30);
        Preferences sp = Gdx.app.getPreferences("SpiderPreferences");
        spiderhealthpoint = sp.getInteger("health");
        spiderstrength = sp.getInteger("strength");
        spideragi = sp.getInteger("agi");
        level = sp.getInteger("level");
        exp = sp.getInteger("exp");
        sp.putInteger("health", 50);
        sp.flush();
    }

    public void rotate(int x, int y){
        int h;
        if(y < Gdx.graphics.getHeight()/3){
            h = (Gdx.graphics.getHeight()/3 - y);
            if(x < Gdx.graphics.getWidth()/2 - h){
                spider.setRotation(67.5f);
            }
            if((x > Gdx.graphics.getWidth()/2 - h)&&(x < Gdx.graphics.getWidth()/2)){
                spider.setRotation(22.5f);
            }
            if((x > Gdx.graphics.getWidth()/2)&&(x < Gdx.graphics.getWidth()/2 + h)){
                spider.setRotation(-22.5f);
            }
            if(x > Gdx.graphics.getWidth()/2 + h){
                spider.setRotation(-67.5f);
            }
        }
        if((y > Gdx.graphics.getHeight()/3)&&(y < Gdx.graphics.getHeight() - Gdx.graphics.getHeight()/3)){
            h = (y - Gdx.graphics.getHeight()/3);
            if(x < Gdx.graphics.getWidth()/2 - h){
                spider.setRotation(112.5f);
            }
            if((x > Gdx.graphics.getWidth()/2 - h)&&(x < Gdx.graphics.getWidth()/2)){
                spider.setRotation(157.5f);
            }
            if((x > Gdx.graphics.getWidth()/2)&&(x < Gdx.graphics.getWidth()/2 + h)){
                spider.setRotation(-157.5f);
            }
            if(x > Gdx.graphics.getWidth()/2 + h){
                spider.setRotation(-112.5f);
            }
        }
    }

    public void draw(SpriteBatch sb) {
        spider.draw(sb);
    }
}
