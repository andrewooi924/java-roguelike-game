package game.positions;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.FillBottleAction;
import game.items.Consumable;
import game.items.PowerWater;

public class PowerFountain extends Fountain {
    /**
     * Constructor.
     *
     */
    public PowerFountain() {
        super('A', 2, new PowerWater());
    }

    @Override
    public String toString() {
       return "Power " + super.toString();
    }
}
