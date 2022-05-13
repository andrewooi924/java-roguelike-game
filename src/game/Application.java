package game;

import java.io.IOException;
import java.util.HashMap;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.Bowser;
import game.actors.Player;
import game.actors.PrincessPeach;
import game.actors.Toad;
import game.injectors.LocationInjector;
import game.injectors.MapInjector;
import game.items.PowerStar;
import game.items.SuperMushroom;
import game.map.Maps;

/**
 * The main class for the Mario World game.
 *
 */
public class Application {

	public static void main(String[] args) throws IOException {

		World world = new World(new Display());

		// process of adding maps into the world
		MapInjector.addingMaps();
		HashMap<Maps, GameMap> maps = MapInjector.getMaps();

		for (GameMap map: maps.values()) {
			world.addGameMap(map);
		}

		// adding teleport points throughout the map
		LocationInjector.addFixedLocations(maps);

		// We can choose which gamemap to start from
		GameMap gameMap = maps.get(Maps.MAP_BASIC); // basic zone is the application's starting point
		final int MARIO_POS_X = 44;
		final int MARIO_POS_Y = 10;
		Actor mario = new Player("Player", 'm', 100);
		world.addPlayer(mario, gameMap.at(MARIO_POS_X, MARIO_POS_Y));
		gameMap.at(MARIO_POS_X, MARIO_POS_Y).addItem(new PowerStar());
		gameMap.at(MARIO_POS_X, MARIO_POS_Y).addItem(new SuperMushroom());

		gameMap.at(MARIO_POS_X, MARIO_POS_Y+1).addActor(new Toad());

		GameMap lavaMap = maps.get(Maps.MAP_LAVA);
		lavaMap.at(2,8).addActor(new PrincessPeach());
		lavaMap.at(3,8).addActor(new Bowser());
		world.run();

	}
}
