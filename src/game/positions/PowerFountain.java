package game.positions;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.FillBottleAction;
import game.items.PowerWater;

public class PowerFountain extends Ground {
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
        if (location.getActor() == actor) {
            ret.add(new FillBottleAction(new PowerWater()));
        }
        return ret;
    }
}
