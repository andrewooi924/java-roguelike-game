package game.managers;

import edu.monash.fit2099.engine.positions.GameMap;
import game.injectors.MapInjector;
import game.map.Maps;
import java.util.HashMap;

/**
 * A global singleton manager which manages all the map in this file
 */
public class MapManager {

    private HashMap<Maps, GameMap> maps;
    private HashMap<GameMap, String> mapNames;
    private static MapManager instance;

    private MapManager() {
        // adding maps and map names into the hash maps, it also utilizes a dependency injector to help reduce dependency on it
        MapInjector mapInjector = new MapInjector();
        maps = mapInjector.addingMaps();
        mapNames = mapInjector.addingMapNames();
    }

    /**
     * A static factory method of the class
     * @return an instance of this class
     */
    public static MapManager getInstance() {
        if(instance == null){
            instance = new MapManager();
        }
        return instance;
    }

    /**
     * Getter of maps
     * @return a hash map of <Maps, GameMap>
     */
    public HashMap<Maps, GameMap> getMaps() {
        return maps;
    }

    /**
     * Getter of mapNames
     * @return a hash map of <GameMap, String>
     */
    public HashMap<GameMap, String> getMapNames() {
        return mapNames;
    }
}