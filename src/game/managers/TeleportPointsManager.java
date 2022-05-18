package game.managers;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.map.Maps;

import java.util.HashMap;

public class TeleportPointsManager {

    private HashMap<String, Location> locations;
    private static TeleportPointsManager instance;

    private TeleportPointsManager() {
        locations = new HashMap<>();
        addFixedLocations();
    }

    public static TeleportPointsManager getInstance(){
        if(instance == null){
            instance = new TeleportPointsManager();
        }
        return instance;
    }

    public HashMap<String, Location> getLocations() {
        return locations;
    }

    public void addLocation(Location location, Location newLocation) {
        locations.put(location.map() + "x:" + location.x() + "y:" + location.y(), newLocation);
    }

    private void addFixedLocations() {
        // getting the maps
        MapManager mapManager = MapManager.getInstance();
        HashMap<Maps, GameMap> maps = mapManager.getMaps();

        // adding the teleport locations to the maps
        GameMap lavaMap = maps.get(Maps.MAP_LAVA);
        GameMap gameMap = maps.get(Maps.MAP_BASIC);
        locations.put(gameMap + "x:12" + "y:3", new Location(lavaMap, 0, 0));
        locations.put(gameMap + "x:73" + "y:1", new Location(lavaMap, 0,0));
        locations.put(gameMap + "x:10" + "y:15", new Location(lavaMap, 0,0));
        locations.put(gameMap + "x:46" + "y:8", new Location(lavaMap, 0,0));
    }
}
