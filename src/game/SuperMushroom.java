package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public class SuperMushroom extends Item implements Consumable, Tradable {
    private Action consumeAction;
    private int price = 600;
    /***
     * Constructor.
     */
    public SuperMushroom() {
        super("Super Mushroom", '^', true);
        this.consumeAction = new ConsumeAction(this);
        this.addAction(consumeAction);
    }

    @Override
    public DropItemAction getDropAction(Actor actor) {
        return null;
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
    }

    @Override
    public Status effect() {
        return Status.TALL;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        this.removeAction(this.consumeAction);

        // Remove it from your inventory if it is there.
        if (actor.getInventory().contains(this)) {
            actor.removeItemFromInventory(this);
        }
        // If you ate it off the floor, make sure to remove the item on the floor
        else {
            map.locationOf(actor).removeItem(this);
        }
        actor.increaseMaxHp(50);
        return "";
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public Item getItem() {
        return this;
    }

}
