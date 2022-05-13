package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.actions.PickUpCoinAction;

public class Key extends Item {

    public Key(){
        super("Key", 'k', true);
    }

    @Override
    public DropItemAction getDropAction(Actor actor) {
        actor.addCapability(Status.HAS_KEY);
        return new DropItemAction(this);
    }
}
