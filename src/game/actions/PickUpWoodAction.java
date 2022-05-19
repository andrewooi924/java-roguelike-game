package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.GameUtilities;
import game.Status;
import game.items.*;

public class PickUpWoodAction extends PickUpItemAction {
    private Wood wood;
    /**
     * Constructor
     * @param wood- a Wood object
     */
    public PickUpWoodAction(Wood wood) {
        super(wood);
        this.wood = wood;
    }

    /**
     * Executes the action
     * @param actor The actor performing the action. -
     * @param map The map the actor is on.
     * @return a String
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String ret = super.execute(actor, map);
        Pouch woodPouch = (Pouch) GameUtilities.getItemWithCapability(actor, Status.CAN_CARRY_WOOD);
        if (woodPouch != null) {
            woodPouch.addAmount(this.wood.getAmount());
            actor.removeItemFromInventory(this.wood);
        }
        return ret;
    }
}
