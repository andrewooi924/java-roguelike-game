package game;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.Goomba;
import game.actors.Player;
import game.actors.Toad;
import game.items.PowerStar;
import game.items.SuperMushroom;
import game.positions.Dirt;
import game.positions.Floor;
import game.positions.Lava;
import game.positions.Tree.SproutTree;
import game.positions.Wall;

/**
 * The main class for the Mario World game.
 *
 */
public class Application {

	public static void main(String[] args) throws IOException {

			World world = new World(new Display());

			FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new SproutTree());
			FancyGroundFactory lavaFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new SproutTree(), new Lava());

			List<String> map = Arrays.asList(
				"..........................................##..........+.........................",
				"............+............+..................#............................C......",
				"............................................#...................................",
				"............C................................##......................+..........",
				"...............................................#................................",
				"................................................#...............................",
				".................+................................#.............................",
				".................................................##.............................",
				"..............................................c.##..............................",
				".........+..............................+#____####.................+............",
				".......................................+#_____###++.............................",
				".......................................+#______###..............................",
				"........................................+#_____###..............................",
				"........................+........................##.............+...............",
				"...................................................#............................",
				"..........C.........................................#...........................",
				"...................+.................................#..........................",
				"......................................................#.........................",
				".......................................................##.......................");

			GameMap gameMap = new GameMap(groundFactory, map);
			GameMap lavaMap = new GameMap(lavaFactory, "LavaZone");
			world.addGameMap(gameMap);
			world.addGameMap(lavaMap);

			final int MARIO_POS_X = 44;
			final int MARIO_POS_Y = 10;
			Actor mario = new Player("Player", 'm', 100);
			world.addPlayer(mario, gameMap.at(MARIO_POS_X, MARIO_POS_Y));
			gameMap.at(MARIO_POS_X, MARIO_POS_Y).addItem(new PowerStar());
			gameMap.at(MARIO_POS_X, MARIO_POS_Y).addItem(new SuperMushroom());

			// FIXME: the Goomba should be generated from the Tree
			gameMap.at(35, 10).addActor(new Goomba());

			gameMap.at(MARIO_POS_X, MARIO_POS_Y+1).addActor(new Toad());

			world.run();

	}
}
