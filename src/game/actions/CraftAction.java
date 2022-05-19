package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Craftable;
import game.items.Material;

/**
 * Special Action for crafting items at the Crafting Table.
 */
public class CraftAction extends Action {

    /**
     * Item to be crafted
     */
    private Craftable item;

    /**
     * Material used for crafting the item
     */
    private Material material;

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
        for (Item item : actor.getInventory()){
            if (item.toString().equals(this.item.getRecipe().toString())){
                material = (Material)item;
                if (material.getAmount() == this.item.getRecipe().getAmount()) {
                    actor.addItemToInventory(this.item.getCrafted());
                    return actor + " crafted " + this.item;
                }
            }
        }

        return actor + " does not have enough materials to craft " + item;
    }

    @Override
    public String menuDescription(Actor actor){
        return actor + " crafts " + item + " (" + item.getRecipe() + ") ";
    }
}
