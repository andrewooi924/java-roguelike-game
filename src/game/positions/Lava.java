package game.positions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;

public class Lava extends Ground {
    /**
     * Constructor.
     */
    public Lava() {
        super('L');
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        if (actor.hasCapability(Status.WALKABLE_FOR_PLAYER)) {
            return true;
        }
        return false;
    }

    @Override
    public void tick(Location location) {
        Actor player;
        if (location.containsAnActor()) {
            player = location.getActor();
            player.hurt(15);
        }
    }
}
