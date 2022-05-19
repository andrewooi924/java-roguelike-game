package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.CraftingMenu;
import game.Status;
import game.injectors.CraftableInjector;

public class SwitchToCraftingAction extends Action {

    CraftingMenu menu = new CraftingMenu();
    Actor actor;

    @Override
    public String execute(Actor actor, GameMap map) {
        this.actor = actor;
        actor.addCapability(Status.NEW_MENU);
        return "Switching to Crafting Mode";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Switch to Crafting Menu";
    }

    @Override
    public Action getNextAction() {
        ActionList ret = new ActionList();
        CraftableInjector craftableInjector = new CraftableInjector();
        ActionList craftableItems = craftableInjector.addingCraftableItems();
        for (Action action: craftableItems) {
            ret.add(action);
        }
        ret.add(new SwitchingBackToMenu());
        return menu.showMenu(actor, ret, new Display());
    }
}
