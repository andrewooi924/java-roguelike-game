package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Craftable;

/**
 * Special Action for crafting items at the Crafting Table.
 */
public class CraftAction extends Action {

    /**
     * Item to be crafted
     */
    private Craftable item;

    /**
     * Constructor
     * @param item the item to be crafted
     */
    public CraftAction(Craftable item){
        this.item = item;
    }

    @Override
    public String execute(Actor actor, GameMap map){
        //check if Player's inventory has sufficient materials
        if (actor.getInventory().contains(item.getRecipe())){
            actor.addItemToInventory(item.getCrafted());
            return actor + " crafted " + item.toString();
        }

        return actor + " does not have enough materials to craft " + item;
    }

    @Override
    public String menuDescription(Actor actor){
        return actor + " crafts " + item + " (" + item.getRecipe() + ") ";
    }
}
