package game.items;

import edu.monash.fit2099.engine.items.Item;

/**
 * Literally just wood, can be used to craft items at a crafting bench
 * or sold to Toad for money
 */
//TODO, should implement a Crafting interface
//TODO, should also be sellable by modifying the Tradable interface
public class Wood extends Item implements Tradable{

    /**
     * The price of the wood if sold to Toad
     */
    private int price = 20;//sell price, not the buy price

    /**
     * A constructor for the Wood class
     */
    public Wood(){
        super("Wood", 'w', true);
    }

    /**
     * Getter for the price of the Wood
     * @return the price of the Wood
     */
    @Override
    public int getPrice() {
        return this.price;
    }

    /**
     * Getter for the Wood
     * @return the Wood
     */
    @Override
    public Item getItem() {
        return this;
    }
}
