package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Coin;
import game.Status;
import game.items.WalletKeeper;

/**
 * The action of picking up a coin
 */
public class PickUpCoinAction extends PickUpItemAction {
    private Coin coin;
    /**
     * Constructor
     * @param coin - a coin object
     */
    public PickUpCoinAction(Coin coin) {
        super(coin);
        this.coin = coin;
    }

    /**
     * Executes the action
     * @param actor The actor performing the action. -
     * @param map The map the actor is on.
     * @return a String
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        this.coin.togglePortability();
        String ret = super.execute(actor, map);
        if (actor.hasCapability(Status.CAN_MANAGE_MONEY)) {
            WalletKeeper wk = (WalletKeeper) actor;
            wk.addToWallet(this.coin.getAmount());
            actor.removeItemFromInventory(this.coin);
        }
        return ret;
    }
}
