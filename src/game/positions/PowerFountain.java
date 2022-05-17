package game.positions;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.FillBottleAction;
import game.items.Consumable;
import game.items.PowerWater;

public class PowerFountain extends Ground  implements Fountain {
    private final int MAX_CAPACITY = 2;
    private int capacity = MAX_CAPACITY;

    PowerWater contents = new PowerWater();
    /**
     * Constructor.
     *
     */
    public PowerFountain() {
        super('A');
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
       return "Power Fountain [%d/%d]".formatted(capacity, MAX_CAPACITY);
    }

    @Override
    public Consumable getContents() {
        return this.contents;
    }

    @Override
    public void reduceCapacity() {
        this.capacity--;
    }
}
