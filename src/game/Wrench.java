package game;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.Weapon;

/**
 * A class that contains the attributes of a Wrench item.
 */
public class Wrench extends Item implements Weapon, Tradable {
    private int price = 200;
    /***
     * Constructor.
     */
    public Wrench() {
        super("Wrench", 'w', true);
    }

    @Override
    public int damage() {
        return 50;
    }

    @Override
    public int chanceToHit() {
        return 80;
    }

    @Override
    public String verb(){
        return "wrenches";
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public Item getItem() {
        return this;
    }
}