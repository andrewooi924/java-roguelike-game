package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

import java.util.Random;

public class GameUtilities {
    // Set the seed if you want to replicate a specific situations.
    // Note that you will hav eto do the exact same actions (attacking, etc) to ensure it plays out the same way
    // This is useful for debugging (e.g: Goombas only do X sometimes that it's not supposed to, but very rarely.
    // Now you can find a seed where they do this early on, then it's easier to debug)
    private long seed = 0;
    private Random rand = null;

    public double getRandomChance() {
        if (rand == null) {
            if (seed == 0) {
                rand = new Random();
            }
            else {
                rand = new Random(seed);
            }
        }

        return rand.nextDouble();
    }

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
