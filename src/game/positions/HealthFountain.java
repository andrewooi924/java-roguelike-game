package game.positions;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.items.HealingWater;
import game.actions.FillBottleAction;

public class HealthFountain extends Ground {
    /**
     * Constructor.
     *
     */
    public HealthFountain() {
        super('H');
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList ret = new ActionList();
        if (location.getActor() == actor) {
            ret.add(new FillBottleAction(new HealingWater()));
        }
        return ret;
    }
}
