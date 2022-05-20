package game.switchingAction;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.displays.Menu;
import game.injectors.CraftableInjector;

public class SwitchToCraftingMenu extends SwitchingAction {

    @Override
    protected Action getNextAction(Menu menu, Actor actor, ActionList actionList, Display display) {
        CraftableInjector craftableInjector = new CraftableInjector();
        ActionList craftableItems = craftableInjector.addingCraftableItems();
        for (Action action: craftableItems) {
            actionList.add(action);
        }
        return menu.showMenu(actor, actionList,display);
    }

    @Override
    protected String getName() {
        return "Crafting";
    }
}
