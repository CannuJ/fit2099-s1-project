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
		GameMap earthMap;
		
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
		earthMap = new GameMap(groundFactory, map);
		world.addMap(earthMap);
		
		GameMap moonMap; // Initial moonMap
		
		List<String> moon = Arrays.asList(
				".......................",
				".......................",
				".......................",
				".......................",
				".......................",
				".......................",
				".......................",
				".......................",
				".......................",
				".......................",
				".......................");
		moonMap = new GameMap(groundFactory, moon);
		world.addMap(moonMap);
		
		// Add player to earthMap
		Actor player = new Player("Player", '@', 1, 100);
		world.addPlayer(player, moonMap, 2, 2);
		
		// Add enemies to earthMap
		
		// Testing Implementation of Grunt
		Grunt grunt = new Grunt("Mongo", player);
		earthMap.addActor(grunt, 0, 0);
		Grunt grunt2 = new Grunt("Norbert", player);
		earthMap.addActor(grunt2,  10, 10);
		// Testing Implementation of Goon
		Goon goon = new Goon("Gooney", player);
		earthMap.addActor(goon, 5, 5);
		// Testing Implementation of Ninja
		Ninja ninja = new Ninja("Greninja", player);
		earthMap.addActor(ninja, 10, 6);
		// Testing Implementation of DrMaybe
		DrMaybe drMaybe = new DrMaybe("DrMaybe", player);
		earthMap.addActor(drMaybe, 17, 2);
		
		// Add NPCQ to earthMap
		NpcQ npcQ = new NpcQ(player);
		earthMap.addActor(npcQ, 3, 3);
		
		// Add items to earthMap
		
		// Testing Implementation of Rocket Plans
		Item rocketPlans = new Item("Rocket Plans", 'P');
		earthMap.addItem(rocketPlans, 5, 2);
		// Testing Implementation of LaunchPad
		LaunchPad lp = new LaunchPad();
		earthMap.add(lp, earthMap.at(9, 9));
		// Testing Implementation of Door/Key
		Door plansDoor = new Door();
		Key plansKey = plansDoor.createKey("Antique key");
		earthMap.add(plansDoor, earthMap.at(8, 3));
		earthMap.addItem(plansKey, 5, 6);
		// Testing Implementation of DrMaybe Door/Key
		Door drMaybeDoor = new Door();
		Key drMaybeKey = drMaybeDoor.createKey("Shiny key");
		earthMap.add(drMaybeDoor, earthMap.at(15, 4));
		earthMap.addItem(drMaybeKey, 5, 7);
		
		// Add enemies to moonMap
		
		// Testing Implementation of Grunt
		Grunt grunt3 = new Grunt("Moondo", player);
		moonMap.addActor(grunt3, 20, 0);
		Grunt grunt4 = new Grunt("Spacheep", player);
		moonMap.addActor(grunt4,  15, 7);
		// Testing Implementation of Goon
		Goon goon2 = new Goon("Goonity", player);
		moonMap.addActor(goon2, 3, 8);
		// Testing Implementation of Ninja
		Ninja ninja2 = new Ninja("Rockinja", player);
		moonMap.addActor(ninja2, 10, 3);
		
		// Testing Implementation of finalBoss
		finalBoss boss = new finalBoss("Yugo Maxx", player);
		moonMap.addActor(boss, 5, 5);
		
		// Add launchpad to moonMap
		
		// Testing Implementation of LaunchPad
		LaunchPad lp2 = new LaunchPad();
		moonMap.add(lp2, moonMap.at(9, 9));
			
			world.run();
	}
}
