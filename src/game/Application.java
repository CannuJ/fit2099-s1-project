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
		
		Item rocketPlans = new Item("Rocket Plans", 'P');
		gameMap.addItem(rocketPlans, 5, 2);
		
		LaunchPad lp = new LaunchPad();
		gameMap.add(lp, gameMap.at(9, 9));
		
		NpcQ npcQ = new NpcQ(player);
		gameMap.addActor(npcQ, 3, 3);
		
		Door plansDoor = new Door();
		Key plansKey = plansDoor.createKey();
		gameMap.add(plansDoor, gameMap.at(8, 3));
		gameMap.addItem(plansKey, 5, 6);
		
		// Testing Implementation of Goon
		Goon goon = new Goon("Gooney", player);
		gameMap.addActor(goon, 5, 5);
		
		// Testing Implementation of Ninja
		Ninja ninja = new Ninja("Greninja", player);
		gameMap.addActor(ninja, 10, 6);
		
		// Testing Implementation of DrMaybe
		DrMaybe drMaybe = new DrMaybe("DrMaybe", player);
		gameMap.addActor(drMaybe, 17, 2);
			
			world.run();
	}
}
