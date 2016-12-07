package info.fandroid.spiderdefense;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import java.util.Iterator;

/**
 * Created by ZZZ on 23.11.2016.
 */

public class Skill {
    public int damage;
    public Sprite ourskill;


    public void create(Texture skillimg, int dam){
        ourskill = new Sprite(skillimg);
        ourskill.setSize(10,10);
        ourskill.setOrigin(5,5);
        damage = dam;
    }


    public void spawnskill(int x, int y){
        int h;
        if(y < Gdx.graphics.getHeight()/3){
            h = (Gdx.graphics.getHeight()/3 - y);
            if(x < Gdx.graphics.getWidth()/2 - h){
                ourskill.setRotation(67.5f);
                ourskill.setPosition(170, 405);
            }
            if((x > Gdx.graphics.getWidth()/2 - h)&&(x < Gdx.graphics.getWidth()/2)){
                ourskill.setRotation(22.5f);
                ourskill.setPosition(185, 420);
            }
            if((x > Gdx.graphics.getWidth()/2)&&(x < Gdx.graphics.getWidth()/2 + h)){
                ourskill.setRotation(-22.5f);
                ourskill.setPosition(205, 420);
            }
            if(x > Gdx.graphics.getWidth()/2 + h){
                ourskill.setRotation(-67.5f);
                ourskill.setPosition(220, 405);
            }
        }
        if((y > Gdx.graphics.getHeight()/3)&&(y < Gdx.graphics.getHeight() - Gdx.graphics.getHeight()/3)){
            h = (y - Gdx.graphics.getHeight()/3);
            if(x < Gdx.graphics.getWidth()/2 - h){
                ourskill.setRotation(112.5f);
                ourskill.setPosition(170, 385);
            }
            if((x > Gdx.graphics.getWidth()/2 - h)&&(x < Gdx.graphics.getWidth()/2)){
                ourskill.setRotation(157.5f);
                ourskill.setPosition(185, 370);
            }
            if((x > Gdx.graphics.getWidth()/2)&&(x < Gdx.graphics.getWidth()/2 + h)){
                ourskill.setRotation(-157.5f);
                ourskill.setPosition(205, 370);
            }
            if(x > Gdx.graphics.getWidth()/2 + h){
                ourskill.setRotation(-112.5f);
                ourskill.setPosition(220, 385);
            }
        }
    }


    public void attack(Array<Skill> arrskill){
        Iterator<Skill> iter;
        iter = arrskill.iterator();
        while(iter.hasNext()) {
            Skill skill = iter.next();
            if(skill.ourskill.getRotation() == 67.5f) {
                skill.ourskill.setY(skill.ourskill.getY() + 90 * Gdx.graphics.getDeltaTime());
                skill.ourskill.setX(skill.ourskill.getX() - 200 * Gdx.graphics.getDeltaTime());
            }
            if(skill.ourskill.getRotation() == 22.5f) {
                skill.ourskill.setY(skill.ourskill.getY() + 200 * Gdx.graphics.getDeltaTime());
                skill.ourskill.setX(skill.ourskill.getX() - 90 * Gdx.graphics.getDeltaTime());
            }
            if(skill.ourskill.getRotation() == -22.5f) {
                skill.ourskill.setY(skill.ourskill.getY() + 200 * Gdx.graphics.getDeltaTime());
                skill.ourskill.setX(skill.ourskill.getX() + 90 * Gdx.graphics.getDeltaTime());
            }
            if(skill.ourskill.getRotation() == -67.5f) {
                skill.ourskill.setY(skill.ourskill.getY() + 90 * Gdx.graphics.getDeltaTime());
                skill.ourskill.setX(skill.ourskill.getX() + 200 * Gdx.graphics.getDeltaTime());
            }
            if(skill.ourskill.getRotation() == 112.5f) {
                skill.ourskill.setY(skill.ourskill.getY() - 90 * Gdx.graphics.getDeltaTime());
                skill.ourskill.setX(skill.ourskill.getX() - 200 * Gdx.graphics.getDeltaTime());
            }
            if(skill.ourskill.getRotation() == 157.5f) {
                skill.ourskill.setY(skill.ourskill.getY() - 200 * Gdx.graphics.getDeltaTime());
                skill.ourskill.setX(skill.ourskill.getX() - 90 * Gdx.graphics.getDeltaTime());
            }
            if(skill.ourskill.getRotation() == -157.5f) {
                skill.ourskill.setY(skill.ourskill.getY() - 200 * Gdx.graphics.getDeltaTime());
                skill.ourskill.setX(skill.ourskill.getX() + 90 * Gdx.graphics.getDeltaTime());
            }
            if(skill.ourskill.getRotation() == -112.5f) {
                skill.ourskill.setY(skill.ourskill.getY() - 90 * Gdx.graphics.getDeltaTime());
                skill.ourskill.setX(skill.ourskill.getX() + 200 * Gdx.graphics.getDeltaTime());
            }
        }
    }


    public void draw(SpriteBatch sb, Array<Skill> skills){
        for (Skill skill : skills) {
            skill.ourskill.draw(sb);
        }
    }
}
