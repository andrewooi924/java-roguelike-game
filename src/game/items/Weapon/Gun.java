package game.items.Weapon;

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

    /**
     * Returns what a Gun does (verb)
     * @return what a gun does (verb)
     */
    @Override
    public String verb(){
        return "deletes";
    }
}
