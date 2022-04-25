package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import java.util.*;

/**
 * Special action used by Goombas to attack the Player.
 */
public class KickAction extends Action {

    /**
     * The Actor that is to be attacked
     */
    private Actor target;

    /**
     * Random number generator
     */
    private Random random = new Random();

    /**
     * The direction that the kick should be aiming towards
     */
    private String direction;

    /**
     * Constructor
     * @param target The actor that is to be attacked
     * @param direction The direction that the kick should be aiming towards
     */
    public KickAction(Actor target, String direction) {
        this.target = target;
        this.direction = direction;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        final double HIT_RATE = 0.50;
        if (random.nextDouble() <= HIT_RATE) {
            if (!target.hasCapability(Status.POWER_STAR)) {
                target.hurt(10);
                if(target.hasCapability(Status.TALL)){
                    target.removeCapability(Status.TALL);
                }
            }
            if (!target.isConscious()){
                map.removeActor(target);
                return target + " died.";
            }
            else {
                return target + " got kicked by Goomba for 10 damage.";
            }
        } else {
            return actor + " missed its kick.";
        }
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " kicks " + target;
    }
}