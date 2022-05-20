package game.switchingAction;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;

public abstract class SwitchingAction extends Action {

    private final Menu menu = new Menu();
    private final Display display = new Display();
    private final ActionList actionList = new ActionList();
    private Actor actor;

    @Override
    public String execute(Actor actor, GameMap map) {
        this.actor = actor;
        actor.addCapability(Status.NEW_MENU);
        actionList.add(new SwitchToNormalMenu());
        return "Switching to " + getName() + " Mode";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Switch to " + getName() + " Menu";
    }

    protected abstract String getName();

    protected abstract Action getNextAction(Menu menu, Actor actor, ActionList actionList, Display display);

    @Override
    public Action getNextAction() {
        return getNextAction(menu, actor, actionList, display);
    }
}
