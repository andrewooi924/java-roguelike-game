package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.GameMap;

public class PickUpCoinAction extends PickUpItemAction {
    Coin coin;
    /**
     * Constructor
     * @param coin
     */
    public PickUpCoinAction(Coin coin) {
        super(coin);
        this.coin = coin;
    }

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
