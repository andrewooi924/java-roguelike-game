package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;

public class TeleportAction extends Action {

    private GameMap lavaZone;

    @Override
    public String execute(Actor actor, GameMap map) {


        actor.removeCapability(Status.CAN_TELEPORT);
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
