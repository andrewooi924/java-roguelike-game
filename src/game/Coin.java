package game;

        import edu.monash.fit2099.engine.actors.Actor;
        import edu.monash.fit2099.engine.items.Item;
        import edu.monash.fit2099.engine.items.PickUpItemAction;
        import edu.monash.fit2099.engine.positions.Location;

public class Coin extends Item {
    // Note: amount may be an integer.
    private int amount;
    public Coin(int amount) {
        super("Coin (" + amount + ")", '$', true);
        this.amount = amount;
    }

    public int getAmount(){
        return amount;
    }

    @Override
    public PickUpItemAction getPickUpAction(Actor actor) {
        return new PickUpCoinAction(this);
    }

    @Override
    public void tick(Location currentLocation) {
        if (this.hasCapability(Status.RESETTABLE)) {
            currentLocation.removeItem(this);
            this.removeCapability(Status.RESETTABLE);
        }
    }
}
