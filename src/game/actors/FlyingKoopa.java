package game.actors;

import game.Status;
import game.behaviours.Behaviour;
import game.reset.Resettable;

import java.util.HashMap;
import java.util.Map;

/**
 * A Koopa, but flying
 */
public class FlyingKoopa extends Koopa implements Resettable {

    private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour

    /**
     * A constructor for the FlyingKoopa class
     */
    public FlyingKoopa() {
        this.setDisplayChar('F');
        this.resetMaxHp(150);
        this.addCapability(Status.CAN_FLY);
    }
}
