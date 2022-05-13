package game.positions;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;

import java.util.HashMap;
import java.util.List;

public class WarpPipe extends HigherGround {

    /**
     * Constructor.
     *
     */
    public WarpPipe() {
        super('C');
    }

    @Override
    public int getFallDamageRate() {
        return 0;
    }

    @Override
    public double getFallProb() {
        return 0;
    }

    @Override
    public void tick(Location location) {

        if (location.containsAnActor()) {
            location.getActor().addCapability(Status.CAN_TELEPORT);
        }
    }
}
