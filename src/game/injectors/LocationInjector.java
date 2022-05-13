package game.injectors;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.map.Maps;

import java.util.HashMap;

public class LocationInjector {

    private static final HashMap<String, Location> locations = new HashMap<>();

    private LocationInjector() {}

    public static void addLocations(HashMap<Maps, GameMap> maps) {
        GameMap lavaMap = maps.get(Maps.MAP_LAVA);
        GameMap gameMap = maps.get(Maps.MAP_BASIC);
        locations.put(gameMap + "x:12" + "y:3", new Location(lavaMap, 0, 0));
        locations.put(gameMap + "x:73" + "y:1", new Location(lavaMap, 0,0));
        locations.put(gameMap + "x:10" + "y:15", new Location(lavaMap, 0,0));
        locations.put(gameMap + "x:46" + "y:8", new Location(lavaMap, 0,0));
    }

    public static HashMap<String, Location> getLocations() {
        return locations;
    }
}
