package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.FancyGroundFactory;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Player;
import edu.monash.fit2099.engine.World;

public class Application {

	public static void main(String[] args) {
		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall());
		GameMap gameMap;

		List<String> map = Arrays.asList(
				".......................",
				"....#####....######....",
				"....#...#....#....#....",
				"....#........#....#....",
				"....#####....##.###....",
				".......................",
				".......................",
				".......................",
				".......................",
				".......................",
				".......................");
		gameMap = new GameMap(groundFactory, map);
		world.addMap(gameMap);
		
		Actor player = new Player("Player", '@', 1, 100);
		world.addPlayer(player, gameMap, 2, 2);
		
		Grunt grunt = new Grunt("Mongo", player);
		gameMap.addActor(grunt, 0, 0);
		Grunt grunt2 = new Grunt("Norbert", player);
		gameMap.addActor(grunt2,  10, 10);
		
		// Testing Rocket Plans, Engine and Body
		// Will move to appropriate locations later
		Item rocketPlans = new Item("Rocket Plans", 'P');
		gameMap.addItem(rocketPlans, 8, 8);
//		Item rocketEngine = new Item("Rocket Engine", 'E');
//		gameMap.addItem(rocketEngine, 8, 9);
//		Item rocketBody = new Item("Rocket Body", 'B');
//		gameMap.addItem(rocketBody, 10, 8);
		NpcQ npcQ = new NpcQ("Q", player);
		gameMap.addActor(npcQ, 9, 10);
		
		// Testing Implementation of Goon
		Goon goon = new Goon("Gooney", player);
		gameMap.addActor(goon, 5, 5);
		
		//Testing Implementation of Ninja
		Ninja ninja = new Ninja("Greninja", player);
		gameMap.addActor(ninja, 10, 6);
			
		world.run();
	}
}
