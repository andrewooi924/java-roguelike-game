package game.switchingAction;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;

public class SwitchToNormalMenu extends SwitchingAction {

    @Override
    protected String getName() {
        return "Normal";
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String result = super.execute(actor, map);
        actor.removeCapability(Status.NEW_MENU); // no new menu, return to old
        return result;
    }
}
