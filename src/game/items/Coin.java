package game.items;

        import edu.monash.fit2099.engine.actors.Actor;
        import edu.monash.fit2099.engine.items.Item;
        import edu.monash.fit2099.engine.items.PickUpItemAction;
        import edu.monash.fit2099.engine.positions.Location;
        import game.reset.Resettable;
        import game.Status;
        import game.actions.PickUpCoinAction;

/**
 * The class represents a coin
 */
public class Coin extends Item implements Resettable {
    // Note: amount may be an integer.
    private int amount;

    /**
     * Constructor
     * @param amount - an integer representing the amount of the coin
     */
    public Coin(int amount) {
        super("Coin (" + amount + ")", '$', true);
        this.amount = amount;
        registerInstance();
    }

    /**
     * A getter to get the amount of the coin
     * @return an integer representing the amount of the coin
     */
    public int getAmount(){
        return amount;
    }

    /**
     * Returns a new instance of PickUpCoinAction
     * @param actor - the actor picking up this coin
     * @return a PickUpCoinAction instance to pick up this instance
     */
    @Override
    public PickUpItemAction getPickUpAction(Actor actor) {
        return new PickUpCoinAction(this);
    }

    /**
     * If the status is Resettable, then remove the coin from the ground
     * @param currentLocation The location of the ground on which we lie.
     */
    @Override
    public void tick(Location currentLocation) {
        if (this.hasCapability(Status.RESETTABLE)) {
            currentLocation.removeItem(this);
            this.removeCapability(Status.RESETTABLE);
        }
    }

    /**
     * Adds the capability RESETTABLE to this class
     */
    @Override
    public void resetInstance() {
        this.addCapability(Status.RESETTABLE);
    }
}
