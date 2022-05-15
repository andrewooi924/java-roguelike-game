package game.positions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

/**
 * A crafting table used to craft items.
 */
public class CraftingTable extends Ground {

    /**
     * A constructor for the CraftingTable class
     */
    public CraftingTable(){
        super('Q');
    }

    @Override
    public boolean canActorEnter(Actor actor){
        return false;
    }
}
