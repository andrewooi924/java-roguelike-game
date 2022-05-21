package game.positions.Fountain;

import game.items.Consumable.PowerWater;

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
