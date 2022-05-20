package game.items;

import edu.monash.fit2099.engine.items.Item;

import java.util.HashMap;

/**
 * A Glock, why is this in the game?
 */
public class Gun extends RangedWeapon{

    public Gun(){
        super("Gun", 'G',true);
    }

    @Override
    public int getRange() {
        return Integer.MAX_VALUE;
    }

    /**
     * Returns death
     * @return death
     */
    @Override
    public int damage(){
        return 9999;
    }
}
