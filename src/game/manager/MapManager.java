package game.manager;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import game.map.Maps;
import game.positions.*;
import game.positions.Tree.SproutTree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapManager {

    private static final HashMap<Maps, GameMap> maps = new HashMap<>();
    private static final HashMap<GameMap, String> mapNames = new HashMap<>();

    private MapManager() {
    }

    public static void addingMaps() throws IOException {
        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new SproutTree(), new WarpPipe(), new HealthFountain(), new PowerFountain());
        FancyGroundFactory lavaFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new SproutTree(), new Lava(), new WarpPipe());
        GameMap lavaMap = new GameMap(lavaFactory, "src/game/map/Lava Zone");
        GameMap gameMap = new GameMap(groundFactory, "src/game/map/Basic Map");
        maps.put(Maps.MAP_LAVA, lavaMap);
        maps.put(Maps.MAP_BASIC, gameMap);
        mapNames.put(gameMap, "Basic Map");
        mapNames.put(lavaMap, "Lava Zone");
    }

    public static HashMap<Maps, GameMap> getMaps() {
        return maps;
    }

    public static HashMap<GameMap, String> getMapNames() {
        return mapNames;
    }
}