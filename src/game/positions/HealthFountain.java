package game.positions;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.items.Consumable;
import game.items.HealingWater;
import game.actions.FillBottleAction;

public class HealthFountain extends Fountain {

    /**
     * Constructor.
     *
     */
    public HealthFountain() {
        super('H', 2, new HealingWater());
    }
    @Override
    public String toString() {
        return "Health " + super.toString();
    }
}
