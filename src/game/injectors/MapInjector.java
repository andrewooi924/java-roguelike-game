package game.injectors;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import game.map.Maps;
import game.positions.*;
import game.positions.Tree.SproutTree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapInjector {

    private HashMap<Maps, GameMap> maps = new HashMap<>();

    public HashMap<Maps, GameMap> addingMaps() throws IOException {
        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new SproutTree(), new WarpPipe());
        FancyGroundFactory lavaFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new SproutTree(), new Lava(), new WarpPipe());
        GameMap lavaMap = new GameMap(lavaFactory, "src/game/map/Lava Zone");
        GameMap gameMap = new GameMap(groundFactory, "src/game/map/Basic Map");
        maps.put(Maps.MAP_LAVA, lavaMap);
        maps.put(Maps.MAP_BASIC, gameMap);
        return maps;
    }
}