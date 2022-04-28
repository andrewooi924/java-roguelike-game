package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

import static game.Status.CAN_MANAGE_MONEY;

public class TradingAction extends Action {
    private String hotkey;
    private Tradable item;

    public TradingAction(Tradable item) {
        this.item = item;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if (actor.hasCapability(CAN_MANAGE_MONEY))  {
            double balance = ((WalletKeeper) actor).getWalletBalance();
            if (balance - item.getPrice() >= 0) {
                ((WalletKeeper) actor).deductFromWallet(item.getPrice());
                actor.addItemToInventory(item.getItem());
                return actor + " obtained " + this.item.toString();
            }
            else {
                return "You don't have enough coins!";
            }
        }
        else {
            return null;
        }
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " buys " + this.item.toString() + " ($" + this.item.getPrice() + ")";
    }
}
