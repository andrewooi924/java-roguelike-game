package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;

public class PowerStar extends Item implements Consumable, Tradable {
    private int age = 0;
    private final int EXPIRY_TURNS = 10;
    private Action consumeAction;
    private int price = 400;
    /***
     * Constructor.
     */
    public PowerStar() {
        super("Power Star", '*', true);
        this.consumeAction = new ConsumeAction(this);
        this.addAction(this.consumeAction);
    }
    @Override
    public DropItemAction getDropAction(Actor actor) {
        return null;
    }

    @Override
    public Status effect() {
        return Status.POWER_STAR;
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        age++;
        if (age >= EXPIRY_TURNS) {
            actor.removeCapability(this.effect());
            actor.removeItemFromInventory(this);
        }
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        actor.heal(200);
        // Don't allow to consume again- even if it's still in your inventory.

        this.removeAction(this.consumeAction);
        // It is possible
        // to consume directly without putting it in your inventory.
        // Add to inventory and remove from floor.
        if (!actor.getInventory().contains(this)) {
            actor.addItemToInventory(this);
            map.locationOf(actor).removeItem(this);
        }

        return String.format("%d turns remaining", EXPIRY_TURNS) ;
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
