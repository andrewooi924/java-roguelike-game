package game.items;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;

/**
 * A fireball that Bowser spits out when attacking, sort of like a furball, don't you think?
 */
public class Fire extends Item{

    /**
     * The age of the fireball
     */
    private int age = 0;

    /**
     * The number of turns it takes for the fire to disappear
     */
    private final int EXPIRY_TURNS = 3;

    public Fire() {
        super("Fire", '@', true);
    }

    @Override
    public void tick(Location currentLocation) {
        Actor player;
        age++;
        if (currentLocation.containsAnActor()){
            player = currentLocation.getActor();
            player.hurt(20);

            if (!player.isConscious()) {
                if (player.hasCapability(Status.FIRE_BREATHER)){
                    currentLocation.addItem(new Key());
                }
                currentLocation.map().removeActor(player);
            }
        }
        if (age >= EXPIRY_TURNS) {
            currentLocation.removeItem(this);
        }
    }

    @Override
    public PickUpItemAction getPickUpAction(Actor actor) {
        return null;
    }
}
