package game.items;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.Weapon;

/**
 * An chopping axe
 */
//TODO: modify so that Goomba can drop this with 20% chance
public class Axe extends Item implements Weapon, Tradable{

    /**
     * The price of the Axe
     */
    private int price = 50;

    /**
     * A constructor for the Axe class
     */
    public Axe(){
        super("Axe", 'a', true);
    }

    /**
     * The damage dealt with an Axe
     * @return 20
     */
    @Override
    public int damage() {
        return 20;
    }

    /**
     * The chance to hit with an Axe
     * @return 90
     */
    @Override
    public int chanceToHit(){
        return 90;
    }

    /**
     * The sound effect the Axe creates
     * @return chops
     */
    @Override
    public String verb(){
        return "chops";
    }

    /**
     * Getter for the price of the Axe
     * @return the price of the Axe
     */
    @Override
    public int getPrice() {
        return this.price;
    }

    /**
     * Getter for the Axe
     * @return the Axe
     */
    @Override
    public Item getItem() {
        return this;
    }
}
