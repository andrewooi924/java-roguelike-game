package game.positions;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

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

    /**
     * Returns an empty Action list.
     *
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return a new, empty collection of Actions
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        //actions.add(new CraftAction());
        return actions;
    }
}
