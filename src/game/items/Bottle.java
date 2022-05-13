package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.items.Item;

import java.util.List;
import java.util.Stack;

public class Bottle extends Item {

    // TO-DO: Merge Item and Consumable somehow.
    Stack<Item> liquids = new Stack<Item>();
    /***
     * Constructor.
     */
    public Bottle() {
        super("Bottle", 'B', false);
    }

    public void addConsumable(Item consumable) {
        liquids.push(consumable);
    }
    public List<Action> getAllowableActions() {
        return liquids.peek().getAllowableActions();
    }

    @Override
    public String toString() {
        return (super.toString() + liquids);
    }
}
