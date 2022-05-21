package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;
import game.actions.ConsumeAction;
import game.items.Consumable.Consumable;

import java.util.Stack;

public class Bottle extends Consumable {

    // TO-DO: Merge Item and Consumable somehow.
    Stack<Consumable> liquids = new Stack<Consumable>();
    ConsumeAction consumeAction;
    /***
     * Constructor.
     */
    public Bottle() {
        super("Bottle", 'B', false);
        this.addCapability(Status.CAN_CARRY_LIQUIDS);
        this.consumeAction = new ConsumeAction(this);
        this.addAction(consumeAction);
    }

    public void addConsumable(Consumable consumable) {
        liquids.push(consumable);
    }

    @Override
    public String toString() {
        return (super.toString() + liquids);
    }

    @Override
    public String consume(Actor actor, GameMap map) {
        if (liquids.size() > 0) {
            liquids.pop().consume(actor, map);
            return "";
        }
        return "But Alas! It is empty!";
    }
}
