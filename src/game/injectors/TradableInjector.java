package game.injectors;

import edu.monash.fit2099.engine.actions.ActionList;
import game.PowerStar;
import game.SuperMushroom;
import game.TradingAction;
import game.Wrench;

/**
 * Injector for tradable, instantiates all the required tradable items and actions to be given to toad
 */
public class TradableInjector {

    /**
     * Adds all the TradingActions with items to an ActionList and returns it
     * @return ActionList consist of TradingActions with tradable items
     */
    public ActionList addingTradableItems() {
        ActionList lst = new ActionList();
        lst.add(new TradingAction(new Wrench()));
        lst.add(new TradingAction(new SuperMushroom()));
        lst.add(new TradingAction(new PowerStar()));
        return lst;
    }
}
