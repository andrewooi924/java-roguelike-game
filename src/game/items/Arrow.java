package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.Location;
import game.GameUtilities;
import game.Status;
import game.actions.PickUpStackableAction;

/**
 * A stick with a sharp metal tip used for killing
 */
public class Arrow extends Item implements Tradable, Stackable {

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
        super("Arrow", 'A', false);
        this.arrowCount = arrowCount;
    }

    /**
     * Returns a new instance of PickUpStorableAction
     * @param actor - the actor picking up this coin
     * @return a PickUpStorable instance to pick up this instance
     */
    @Override
    public PickUpItemAction getPickUpAction(Actor actor) {
        return new PickUpStackableAction(this, this);
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

    /**
     * Returns the number of arrows
     * @return the number of arrows
     */
    @Override
    public int getAmount() {
        return this.arrowCount;
    }

    @Override
    public Storable getStorableType() {
        return Storable.ARROW;
    }
    public void tick(Location currentLocation, Actor actor) {
        MagicPouch magicPouch = (MagicPouch) GameUtilities.getItemWithCapability(actor, Status.CAN_CARRY_STORABLES);
        magicPouch.increaseAmount(Storable.ARROW, this.getAmount());
        actor.removeItemFromInventory(this);
    }
}
