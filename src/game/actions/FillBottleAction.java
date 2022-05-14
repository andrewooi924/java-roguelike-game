package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Bottle;
import game.items.Consumable;

public class FillBottleAction extends Action {
    Consumable fillee;
    public FillBottleAction(Consumable fillee) {
        this.fillee = fillee;
    }

    /**
     * Executes the filling bottle action.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a String indicating that the player has filled the bottle the item
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Bottle bottle = null;
        for (Item i: actor.getInventory()) {
            // if (i.getDisplayChar() == 'B')
            if (i instanceof Bottle) {
                bottle = (Bottle)i;
            }
        }
        if (bottle == null) {
            return actor.toString() + " doesn't have a water bottle!";
        }
        bottle.addConsumable(this.fillee);
        return actor.toString() + " has filled their bottle with " + fillee.toString();
    }

    /**
     * A description once the player has filled the item
     * @param actor The actor performing the action.
     * @return a string that indicates the player has filled the item
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor.toString() + " fills their bottle with " + this.fillee.toString();
    }
}
