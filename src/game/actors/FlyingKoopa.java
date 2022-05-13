package game.actors;

import game.Status;
import game.behaviours.Behaviour;
import game.reset.Resettable;

import java.util.HashMap;
import java.util.Map;

public class FlyingKoopa extends Koopa implements Resettable {

    private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour

    public FlyingKoopa() {
        this.setDisplayChar('F');
        this.resetMaxHp(150);
        this.addCapability(Status.CAN_FLY);
    }
}
