package game.positions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.SwitchToCraftingAction;
import game.injectors.CraftableInjector;

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

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList ret = new ActionList();
        ret.add(new SwitchToCraftingAction());
        return ret;
    }
}
