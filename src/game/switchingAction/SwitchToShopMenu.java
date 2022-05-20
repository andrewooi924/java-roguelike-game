package game.switchingAction;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.displays.Menu;
import game.injectors.TradableInjector;

public class SwitchToShopMenu extends SwitchingAction{
    @Override
    protected String getName() {
        return "Shop";
    }

    @Override
    protected Action getNextAction(Menu menu, Actor actor, ActionList actionList, Display display) {
        TradableInjector injector = new TradableInjector();

        // creating all the tradable items in an injector to reduce dependencies on toad
        ActionList tradableItems = injector.addingTradableItems();
        for (Action action: tradableItems) {
            actionList.add(action);
        }
        return menu.showMenu(actor, actionList, display);
    }
}
