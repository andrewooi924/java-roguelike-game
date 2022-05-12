package game.items;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.Location;

public class Fire extends Item{

    private int age = 0;
    private final int EXPIRY_TURNS = 3;

    public Fire() {
        super("Fire", '^', true);
    }

    @Override
    public void tick(Location currentLocation) {
        Actor player;
        age++;
        if (currentLocation.containsAnActor()){
            player = currentLocation.getActor();
            player.hurt(20);
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
