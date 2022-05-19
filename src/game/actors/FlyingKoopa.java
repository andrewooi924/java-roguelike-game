package game.actors;

import game.Status;
import game.reset.Resettable;

/**
 * A Koopa, but flying
 */
public class FlyingKoopa extends Koopa implements Resettable {

    /**
     * A constructor for the FlyingKoopa class
     */
    public FlyingKoopa() {
        this.setDisplayChar('F');
        this.resetMaxHp(150);
        this.addCapability(Status.CAN_FLY);
    }

    @Override
    public String toString() {
        return "Flying " + super.toString();
    }
}
