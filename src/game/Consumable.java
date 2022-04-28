package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public interface Consumable {

    // Design rationale: Having this as a interface method to enforce
    // that all Consumables must give you a new status.
    Status effect();
    String execute(Actor actor, GameMap map);
}
