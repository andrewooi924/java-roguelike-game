package game.positions.Fountain;

import game.items.Consumable.HealingWater;

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
