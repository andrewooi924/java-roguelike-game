package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import java.util.*;

/**
 * Special action used by Koopas to attack the Player.
 */
public class PunchAction extends Action {

    /**
     * The Actor that is to be attacked
     */
    private Actor target;
    /**
     * The direction of the incoming attack
     */
    private String direction;
    /**
     * Random number generator
     */
    private Random random = new Random();

    /**
     * A constructor for the PunchAction class
     * @param target The actor that is to be attacked
     * @param direction The direction of the incoming attack
     */
    public PunchAction(Actor target, String direction) {
        this.target = target;
        this.direction = direction;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        final double HIT_RATE = 0.50;
        if (random.nextDouble() <= HIT_RATE) {
            if (!target.hasCapability(Status.POWER_STAR)) {
                target.hurt(30);
                if(target.hasCapability(Status.TALL)){
                    target.removeCapability(Status.TALL);
                }
            }
            if (!target.isConscious()){
                map.removeActor(target);
                result +=  target + " died.";
            }
            else {
                result += target + " got punched by Koopa for 30 damage.";
            }
        } else {
            result += actor + " missed its punch.";
        }
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " punches " + target;
    }
}