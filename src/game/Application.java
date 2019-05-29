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
		world.addPlayer(player, earthMap, 2, 2);
		
		// Add enemies to earthMap
		
		// Testing Implementation of Grunt
		earthMap.addActor(new Grunt("Mongo", player), 0, 0);
		earthMap.addActor(new Grunt("Norbert", player),  10, 10);
		// Testing Implementation of Goon
		earthMap.addActor(new Goon("Gooney", player), 5, 5);
		// Testing Implementation of Ninja
		earthMap.addActor(new Ninja("Greninja", player), 10, 6);
		// Testing Implementation of DrMaybe
		earthMap.addActor(new DrMaybe("DrMaybe", player), 17, 2);
		
		// Add NPCQ to earthMap
		earthMap.addActor(new NpcQ(player), 3, 3);
		
		// Add items to earthMap
		
		// Testing Implementation of Rocket Plans
		earthMap.addItem(new Item("Rocket Plans", 'P'), 5, 2);
		// Add launch pad to earthMap
		earthMap.add(new LaunchPad(moonMap, 9, 10, "to the Moon"), earthMap.at(9, 9));
		// Add an invisible player only tile where the player will spawn at the destination
		earthMap.add(new PlayerOnlyTile('.'), earthMap.at(9, 10));
		
		// Testing Implementation of SpaceSuit/OxygenTank
		earthMap.addItem(new SpaceSuit("Space Suit"), 15, 8);
		earthMap.add(new OxygenDispenser('o'), earthMap.at(16, 8));
		
		// Testing Implementation of Door/Key
		Door plansDoor = new Door();
		earthMap.add(plansDoor, earthMap.at(8, 3));
		earthMap.addItem(plansDoor.createKey("Antique key"), 5, 6);
		// Testing Implementation of DrMaybe Door/Key
		Door drMaybeDoor = new Door();
		earthMap.add(drMaybeDoor, earthMap.at(15, 4));
		earthMap.addItem(drMaybeDoor.createKey("Shiny key"), 5, 7);
		
		Lake earthLake = new Lake(earthMap, 18, 20, 6, 9);
		earthLake.buildLake();
		
		// Add enemies to moonMap
		
		// Testing Implementation of Grunt
		moonMap.addActor(new Grunt("Moondo", player), 20, 0);
		moonMap.addActor(new Grunt("Spacheep", player),  15, 7);
		// Testing Implementation of Goon
		moonMap.addActor(new Goon("Goonity", player), 3, 8);
		// Testing Implementation of Ninja
		moonMap.addActor(new Ninja("Rockinja", player), 10, 3);
		
		// Testing Implementation of finalBoss
		moonMap.addActor(new FinalBoss("Yugo Maxx", player), 5, 5);
		
		// Add launch pad to moonMap
		moonMap.add(new LaunchPad(earthMap, 9, 10, "back to Earth", true), moonMap.at(9, 9));
		// Add an invisible player only tile where the player will spawn at the destination
		moonMap.add(new PlayerOnlyTile('.'), moonMap.at(9, 10));
			
		world.run();
	}
}
