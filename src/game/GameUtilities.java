package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

public class GameUtilities {
    public static Item getItemWithCapability(Actor actor, Enum<?> capability) {
        // functional ftw
        return actor.getInventory().stream().filter(item -> item.hasCapability(capability)).findFirst().orElse(null);
        /*
        for (Item i: actor.getInventory()) {
            if (i.hasCapability(capability)) {
                return i;
            }
        }
         */

    }
}
