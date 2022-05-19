package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class SwitchingBackToMenu extends Action {
    /**
     * Constructor
     */
    public SwitchingBackToMenu() {
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return "Switching to Normal Mode";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Switch back to Normal Mode";
    }
}
