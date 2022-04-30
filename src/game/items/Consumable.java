package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;

/**
 * The item that can be consumed will be implementing this interface
 */
public interface Consumable {

    // Design rationale: Having this as a interface method to enforce
    // that all Consumables must give you a new status.

    /**
     * returns a status of the item
     * @return a Status enum
     */
    Status effect();

    /**
     * The player consuming the item
     * @param actor the player consuming the item
     * @param map - the location the player is at
     * @return a String specifying that the actor has consumed it
     */
    String consume(Actor actor, GameMap map);
}
