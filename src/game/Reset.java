package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class Reset extends Action {

    ResetManager resetManager;

    public Reset() {
        resetManager = ResetManager.getInstance();
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        resetManager.run();
        Player.resetTimes--;
        return "";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Reset the game";
    }

    @Override
    public String hotkey() {
        return "r";
    }
}
