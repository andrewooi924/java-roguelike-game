package game.managers;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import game.map.Maps;
import game.positions.*;
import game.positions.Tree.SproutTree;

import java.io.IOException;
import java.util.HashMap;

public class MapManager {

    private HashMap<Maps, GameMap> maps;
    private HashMap<GameMap, String> mapNames;
    private static MapManager instance;

    private MapManager() {
        maps = new HashMap<>();
        mapNames = new HashMap<>();
    }

    public static MapManager getInstance(){
        if(instance == null){
            instance = new MapManager();
        }
        return instance;
    }

    public void addingMaps() throws IOException {
        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new SproutTree(), new WarpPipe(), new HealthFountain(), new PowerFountain());
        FancyGroundFactory lavaFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new SproutTree(), new Lava(), new WarpPipe());
        GameMap lavaMap = new GameMap(lavaFactory, "src/game/map/Lava Zone");
        GameMap gameMap = new GameMap(groundFactory, "src/game/map/Basic Map");
        maps.put(Maps.MAP_LAVA, lavaMap);
        maps.put(Maps.MAP_BASIC, gameMap);
        mapNames.put(gameMap, "Basic Map");
        mapNames.put(lavaMap, "Lava Zone");
    }

    public HashMap<Maps, GameMap> getMaps() {
        return maps;
    }

    public HashMap<GameMap, String> getMapNames() {
        return mapNames;
    }
}