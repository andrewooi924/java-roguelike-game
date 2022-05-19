package game.items;

import edu.monash.fit2099.engine.items.Item;

/**
 * A Glock, why is this in the game?
 */
public class Gun extends Bow{

    public Gun(){
        this.setDisplayChar('G');
    }

    /**
     * Returns death
     * @return death
     */
    @Override
    public int damage(){
        return 9999;
    }

    @Override
    public String toString(){
        return "Gun";
    }

    @Override
    public Material getRecipe(){
        return null;
    }

    @Override
    public Item getCrafted(){
        return null;
    }
}
