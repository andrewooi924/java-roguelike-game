package game.positions.Fountain;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.actions.FillBottleAction;
import game.items.Consumable.Consumable;
import game.positions.Dirt;

/**
 * A fountain that contains drinkable liquid
 */
public abstract class Fountain extends Ground {

    /**
     * The maximum capacity of the fountain
     */
    private int maxCapacity;

    /**
     * The current capacity of the fountain
     */
    private int capacity;

    /**
     * The contents of the fountain
     */
    private Consumable contents;

    /**
     * Constructor.
     */
    public Fountain(char displayChar, int maxCapacity, Consumable contents) {
        super(displayChar);
        this.maxCapacity = maxCapacity;
        this.capacity = this.maxCapacity;
        this.contents = contents;
        this.addCapability(Status.CAN_BE_DRUNK);
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList ret = new ActionList();
        if (this.capacity == 0) {
            location.setGround(new Dirt());
            return ret;
        }
        if (location.getActor() == actor) {
            ret.add(new FillBottleAction(this));
        }
        return ret;
    }

    @Override
    public String toString() {
        return "Fountain [%d/%d]".formatted(capacity, maxCapacity);
    }

    /**
     * Getter for the contents of the fountain
     * @return the contents of the fountain
     */
    public Consumable getContents() {
        return this.contents;
    }

    /**
     * Reduces the current capacity of the fountain
     */
    public void reduceCapacity() {
        this.capacity--;
    }
}
