package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;

public class HealingWater implements Consumable{
    final int HEAL_AMOUNT = 50;
    @Override
    public Status effect() {
        return null;
    }

    @Override
    public String consume(Actor actor, GameMap map) {
        actor.heal(HEAL_AMOUNT);
        return null;
    }
}
