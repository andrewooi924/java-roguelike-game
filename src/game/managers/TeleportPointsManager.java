package game.managers;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.map.Maps;

import java.util.HashMap;

public class TeleportPointsManager {

    private final HashMap<Location, Location> locations;
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

    public void addLocation(Location location, Location newLocation) {
        locations.put(location, newLocation);
    }

    public Location findLocationToTravel(Location location) {
        return locations.get(location);
    }

    private void addFixedLocations() {
        // getting the maps
        MapManager mapManager = MapManager.getInstance();
        HashMap<Maps, GameMap> maps = mapManager.getMaps();

        // adding the teleport locations to the maps
        GameMap lavaMap = maps.get(Maps.MAP_LAVA);
        GameMap gameMap = maps.get(Maps.MAP_BASIC);
        locations.put(gameMap.at(12, 3), lavaMap.at(0,0));
        locations.put(gameMap.at(73, 1), lavaMap.at(0,0));
        locations.put(gameMap.at(10, 15), lavaMap.at(0, 0));
        locations.put(gameMap.at(46, 8),lavaMap.at(0, 0));
    }
}
