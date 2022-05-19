package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.items.Item;

/**
 * A stick with a sharp metal tip used for killing
 */
public class Arrow extends Item implements Tradable {

    /**
     * The price of an arrow
     */
    private int price = 40;

    /**
     * The number of arrows
     */
    private int arrowCount;

    /**
     * Constructor
     */
    public Arrow(int arrowCount){
        super("Arrow", 'A', true);
        this.arrowCount = arrowCount;
    }

    /**
     * Returns the number of arrows
     * @return the number of arrows
     */
    public int getArrowCount(){
        return arrowCount;
    }

    @Override
    public DropItemAction getDropAction(Actor actor){
        return null;
    }

    /**
     * Getter for the price of an Arrow
     * @return the price of an Arrow
     */
    @Override
    public int getPrice() {
        return this.price;
    }

    /**
     * Getter for Arrow
     * @return Arrow
     */
    @Override
    public Item getItem() {
        return this;
    }
}
