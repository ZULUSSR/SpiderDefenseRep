package info.fandroid.spiderdefense;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import java.util.Iterator;

/**
 * Created by ZZZ on 06.11.2016.
 */

public class Enemy {
    public int healthpoint;
    public int enemydamage;
    public Sprite ourenemy;

    public void create(Texture enemyimg, int damage){
        ourenemy = new Sprite(enemyimg);
        healthpoint = 5;
        enemydamage = damage;
    }

    public void spawn() {
        int rand;
        ourenemy.setSize(40, 40);
        ourenemy.setOrigin(20, 20);
        rand = MathUtils.random(0, 7);
        switch (rand) {
            case 0:
                ourenemy.setRotation(243.435f);//alpha = 26.565
                ourenemy.setPosition(-40, 480);
                break;
            case 1:
                ourenemy.setRotation(206.565f);
                ourenemy.setPosition(80, 600);
                break;
            case 2:
                ourenemy.setRotation(153.435f);
                ourenemy.setPosition(278, 600);
                break;
            case 3:
                ourenemy.setRotation(116.565f);
                ourenemy.setPosition(400, 480);
                break;
            case 4:
                ourenemy.setRotation(296.565f);
                ourenemy.setPosition(-40, 280);
                break;
            case 5:
                ourenemy.setRotation(333.435f);
                ourenemy.setPosition(80, 160);
                break;
            case 6:
                ourenemy.setRotation(26.565f);
                ourenemy.setPosition(278, 160);
                break;
            case 7:
                ourenemy.setRotation(63.435f);
                ourenemy.setPosition(400, 280);
                break;
        }
    }

    public void attack(Array<Enemy> enemys, MainSpider spider, int speed) {
        Iterator<Enemy> enemyIterator;
        enemyIterator = enemys.iterator();
        while (enemyIterator.hasNext()) {
            Enemy enemy = enemyIterator.next();

            if(enemy.ourenemy.getRotation() == 243.435f) {
                enemy.ourenemy.setY(enemy.ourenemy.getY() - speed * 9 * Gdx.graphics.getDeltaTime());
                enemy.ourenemy.setX(enemy.ourenemy.getX() + speed * 20 * Gdx.graphics.getDeltaTime());
            }
            if(enemy.ourenemy.getRotation() == 206.565f) {
                enemy.ourenemy.setY(enemy.ourenemy.getY() - speed * 20 * Gdx.graphics.getDeltaTime());
                enemy.ourenemy.setX(enemy.ourenemy.getX() + speed * 9 * Gdx.graphics.getDeltaTime());
            }
            if(enemy.ourenemy.getRotation() == 153.435f) {
                enemy.ourenemy.setY(enemy.ourenemy.getY() - speed * 20 * Gdx.graphics.getDeltaTime());
                enemy.ourenemy.setX(enemy.ourenemy.getX() - speed * 9 * Gdx.graphics.getDeltaTime());
            }
            if(enemy.ourenemy.getRotation() == 116.565f) {
                enemy.ourenemy.setY(enemy.ourenemy.getY() - speed * 9 * Gdx.graphics.getDeltaTime());
                enemy.ourenemy.setX(enemy.ourenemy.getX() - speed * 20 * Gdx.graphics.getDeltaTime());
            }
            if(enemy.ourenemy.getRotation() == 296.565f) {
                enemy.ourenemy.setY(enemy.ourenemy.getY() + speed * 9 * Gdx.graphics.getDeltaTime());
                enemy.ourenemy.setX(enemy.ourenemy.getX() + speed * 20 * Gdx.graphics.getDeltaTime());
            }
            if(enemy.ourenemy.getRotation() == 333.435f) {
                enemy.ourenemy.setY(enemy.ourenemy.getY() + speed * 20 * Gdx.graphics.getDeltaTime());
                enemy.ourenemy.setX(enemy.ourenemy.getX() + speed * 9 * Gdx.graphics.getDeltaTime());
            }
            if(enemy.ourenemy.getRotation() == 26.565f) {
                enemy.ourenemy.setY(enemy.ourenemy.getY() + speed * 20 * Gdx.graphics.getDeltaTime());
                enemy.ourenemy.setX(enemy.ourenemy.getX() - speed * 9 * Gdx.graphics.getDeltaTime());
            }
            if(enemy.ourenemy.getRotation() == 63.435f) {
                enemy.ourenemy.setY(enemy.ourenemy.getY() + speed * 9 * Gdx.graphics.getDeltaTime());
                enemy.ourenemy.setX(enemy.ourenemy.getX() - speed * 20 * Gdx.graphics.getDeltaTime());
            }

            if ((enemy.ourenemy.getRotation() == 243.435f) && (enemy.ourenemy.getX() > 130)){
                spider.spiderhealthpoint -= enemydamage;
                enemyIterator.remove();
            }
            if ((enemy.ourenemy.getRotation() == 206.565f) && ((enemy.ourenemy.getY()) < 430)){
                spider.spiderhealthpoint -= enemydamage;
                enemyIterator.remove();
            }
            if ((enemy.ourenemy.getRotation() == 153.435f) && (enemy.ourenemy.getY() < 430)){
                spider.spiderhealthpoint -= enemydamage;
                enemyIterator.remove();
            }
            if ((enemy.ourenemy.getRotation() == 116.565f) && (enemy.ourenemy.getX() < 230)){
                spider.spiderhealthpoint -= enemydamage;
                enemyIterator.remove();
            }
            if ((enemy.ourenemy.getRotation() == 296.565f) && (enemy.ourenemy.getX() > 130)) {
                spider.spiderhealthpoint -= enemydamage;
                enemyIterator.remove();
            }
            if ((enemy.ourenemy.getRotation() == 333.435f) && (enemy.ourenemy.getY() > 330)) {
                spider.spiderhealthpoint -= enemydamage;
                enemyIterator.remove();
            }
            if ((enemy.ourenemy.getRotation() == 26.565f) && (enemy.ourenemy.getY() > 330)) {
                spider.spiderhealthpoint -= enemydamage;
                enemyIterator.remove();
            }
            if ((enemy.ourenemy.getRotation() == 63.435f) && (enemy.ourenemy.getX() < 230)) {
                spider.spiderhealthpoint -= enemydamage;
                enemyIterator.remove();
            }
        }
    }

    public void draw(SpriteBatch sb, Array<Enemy> enemys){
        for (Enemy enemy : enemys) {
            enemy.ourenemy.draw(sb);
        }
    }

}
