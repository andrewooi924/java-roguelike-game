package game.positions;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.FillBottleAction;
import game.items.Consumable;
import game.items.PowerWater;

public abstract class Fountain extends Ground {
    private int maxCapacity;
    private int capacity;

    Consumable contents;
    /**
     * Constructor.
     *
     */
    public Fountain(char displayChar, int maxCapacity, Consumable contents) {
        super(displayChar);
        this.maxCapacity = maxCapacity;
        this.capacity = this.maxCapacity;
        this.contents = contents;
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

    public Consumable getContents() {
        return this.contents;
    }

    public void reduceCapacity() {
        this.capacity--;
    }
}
