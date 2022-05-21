package game.items.Consumable;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;

public class HealingWater extends Item implements Consumable{
    final int HEAL_AMOUNT = 50;

    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public HealingWater() {
        super("Healing Water", 'H', true);
    }

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
