package info.fandroid.spiderdefense.inventory_super_skill;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;

import info.fandroid.spiderdefense.Enemy;
import info.fandroid.spiderdefense.Skill;
import info.fandroid.spiderdefense.SuperSkill;

/**
 * Created by ZZZ on 02.12.2016.
 */

public class MassBabySpiders extends SuperSkill {

    @Override
    public void attack(boolean freeze, boolean lifesteal, Array<Skill> arrs, Texture skillimg, int damage) {
        classkill = new Skill();
        classkill.create(skillimg, damage);
        classkill.ourskill.setRotation(67.5f);
        classkill.ourskill.setPosition(170, 405);
        arrs.add(classkill);
        classkill = new Skill();
        classkill.create(skillimg, damage);
        classkill.ourskill.setRotation(22.5f);
        classkill.ourskill.setPosition(185, 420);
        arrs.add(classkill);
        classkill = new Skill();
        classkill.create(skillimg, damage);
        classkill.ourskill.setRotation(-22.5f);
        classkill.ourskill.setPosition(205, 420);
        arrs.add(classkill);
        classkill = new Skill();
        classkill.create(skillimg, damage);
        classkill.ourskill.setRotation(-67.5f);
        classkill.ourskill.setPosition(220, 405);
        arrs.add(classkill);
        classkill = new Skill();
        classkill.create(skillimg, damage);
        classkill.ourskill.setRotation(112.5f);
        classkill.ourskill.setPosition(170, 385);
        arrs.add(classkill);
        classkill = new Skill();
        classkill.create(skillimg, damage);
        classkill.ourskill.setRotation(157.5f);
        classkill.ourskill.setPosition(185, 370);
        arrs.add(classkill);
        classkill = new Skill();
        classkill.create(skillimg, damage);
        classkill.ourskill.setRotation(-157.5f);
        classkill.ourskill.setPosition(205, 370);
        arrs.add(classkill);
        classkill = new Skill();
        classkill.create(skillimg, damage);
        classkill.ourskill.setRotation(-112.5f);
        classkill.ourskill.setPosition(220, 385);
        arrs.add(classkill);
    }
}
