package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.managers.MapManager;

import java.util.HashMap;

public class TeleportAction extends Action {

    private final HashMap<GameMap, String> mapNames;
    private final Location locationToTravel;

    public TeleportAction(Location locationToTravel) {
        MapManager mapManager = MapManager.getInstance();
        mapNames = mapManager.getMapNames(); // getting the names of the maps
        this.locationToTravel = locationToTravel;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if (locationToTravel.containsAnActor())
            map.removeActor(locationToTravel.getActor()); // removes the piranha plant if it is there
        map.moveActor(actor, locationToTravel);
        return "Mario teleports to " + mapNames.get(locationToTravel.map());
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Teleport to " + mapNames.get(locationToTravel.map());
    }
}
