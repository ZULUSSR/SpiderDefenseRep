package info.fandroid.spiderdefense;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;

/**
 * Created by ZZZ on 02.12.2016.
 */

public abstract class SuperSkill {
    public Sprite ourskill;
    public Skill classkill = new Skill();

    public void create(Texture skillimg){
        ourskill = new Sprite(skillimg);
    }

    public abstract void attack(boolean freeze, boolean lifesteal, Array<Skill> arrs, Texture skillimg, int damage);
}
