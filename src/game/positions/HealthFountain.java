package game.positions;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.items.Consumable;
import game.items.HealingWater;
import game.actions.FillBottleAction;

public class HealthFountain extends Ground implements Fountain {
    private final int MAX_CAPACITY = 2;
    private int capacity = MAX_CAPACITY;
    private HealingWater contents = new HealingWater();

    /**
     * Constructor.
     *
     */
    public HealthFountain() {
        super('H');
    }

    public Consumable getContents() {return this.contents;}

    private int getCapacity() {return this.capacity;}
    public void reduceCapacity() {
        this.capacity--;
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
        return "Health Fountan [%d/%d]".formatted(capacity, MAX_CAPACITY);
    }
}
