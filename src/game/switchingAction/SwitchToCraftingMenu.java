package game.switchingAction;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import game.injectors.CraftableInjector;

public class SwitchToCraftingMenu extends SwitchingAction {

    @Override
    public Action getNextAction() {
        ActionList actionList = getActionList();
        CraftableInjector craftableInjector = new CraftableInjector();
        ActionList craftableItems = craftableInjector.addingCraftableItems();
        for (Action action: craftableItems) {
            actionList.add(action);
        }
        actionList.add(new SwitchToNormalMenu());
        return getMenu().showMenu(getActor(), actionList, getDisplay());
    }

    @Override
    protected String getName() {
        return "Crafting";
    }
}
