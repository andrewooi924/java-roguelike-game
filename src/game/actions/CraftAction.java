package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.GameUtilities;
import game.Status;
import game.items.Craftable;
import game.items.MagicPouch;
import game.items.Storable;

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
        MagicPouch magicPouch = (MagicPouch) GameUtilities.getItemWithCapability(actor, Status.CAN_CARRY_STORABLES);

        boolean sufficientMaterials = true;
        for (Storable storable: this.item.getRecipe().keySet()) {
            if (magicPouch.getAmount(storable) < this.item.getRecipe().getOrDefault(storable, 0)) {
                sufficientMaterials = false;
                break;
            }
        }

        if (sufficientMaterials) {
            // Reduce the materials.
            for (Storable storable: this.item.getRecipe().keySet()) {
                magicPouch.decreaseAmount(storable, this.item.getRecipe().get(storable));
            }

            // Give it to the actor
            actor.addItemToInventory(this.item.getCrafted());
            return actor + " crafted " + this.item;
        }
        return actor + " does not have enough materials to craft " + item;
    }

    @Override
    public String menuDescription(Actor actor){
        return actor + " crafts " + item + " (" + item.getRecipe() + ") ";
    }
}
