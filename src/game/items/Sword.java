package game.items;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.Weapon;

/**
 * A sword that slashes enemies
 */
//TODO, should implement a Craftable interface
public class Sword extends Item implements Weapon {

    /**
     * A constructor for the Sword class
     */
    public Sword(){
        super("Sword", 's', true);
    }

    /**
     * The damage dealt with a Sword
     * @return 80
     */
    @Override
    public int damage() {
        return 80;
    }

    /**
     * The chance to hit with a Sword
     * @return 80
     */
    @Override
    public int chanceToHit(){
        return 80;
    }

    /**
     * The sound effect the Sword creates
     * @return slashes
     */
    @Override
    public String verb(){
        return "slashes";
    }
}
