package game.injectors;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.map.Maps;

import java.util.HashMap;

public class LocationInjector {

    private HashMap<String, Location> locations = new HashMap<>();

    public HashMap<String, Location> addLocations(HashMap<Maps, GameMap> maps) {
        GameMap lavaMap = maps.get(Maps.MAP_LAVA);
        GameMap gameMap = maps.get(Maps.MAP_BASIC);
        locations.put(Maps.MAP_BASIC + "x:12" + "y:3", new Location(lavaMap, 0, 0));
        locations.put(Maps.MAP_BASIC + "x:73" + "y:1", new Location(lavaMap, 0,0));
        locations.put(Maps.MAP_BASIC + "x:10" + "y:15", new Location(lavaMap, 0,0));
        locations.put(Maps.MAP_BASIC + "x:46" + "y:8", new Location(lavaMap, 0,0));
        return locations;
    }

}
