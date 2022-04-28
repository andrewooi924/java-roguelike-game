package game.injectors;

import edu.monash.fit2099.engine.actions.ActionList;
import game.PowerStar;
import game.SuperMushroom;
import game.TradingAction;
import game.Wrench;

public class TradableInjector {

    public ActionList addingTradableItems() {
        ActionList lst = new ActionList();
        lst.add(new TradingAction(new Wrench()));
        lst.add(new TradingAction(new SuperMushroom()));
        lst.add(new TradingAction(new PowerStar()));
        return lst;
    }
}
