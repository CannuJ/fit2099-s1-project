package game;

import edu.monash.fit2099.engine.*;

import java.awt.Dialog;
import java.util.ArrayList;
import java.util.List;


public class NpcQ extends Actor{
	
	/*
	 * The Actor class that implements the in-game NPC named Q.
	 * Q is an integral part of the story as he gives the player the rocketBody item
	 * used to complete the game.
	 * 
	 * The only action Q has is to talk with the player and to drop the rocket body
	 */
	
	private static final String speechNoPlans = "I can give you something that will help,"
			+ " but I’m going to need the plans.";
	private static final String speechWithPlans = "Hand them over, I don’t have all day!";
	private static final int maxTalkingDistance = 1;
	
	private ActionFactory dialogNoPlans;
	private ActionFactory dialogWithPlans;
	private Actor player;

	public NpcQ(String name, Actor player) {
		super(name, 'Q', 10, 100);
		dialogNoPlans = new DialogAction(player, speechNoPlans);
		dialogWithPlans = new DialogAction(player, speechWithPlans);
		this.player = player;
	}

	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
//		
		// Uncomment to make Q talk every turn
		Location here = map.locationOf(player);
		Location there = map.locationOf(this);
		int talkingDistance = distance(here, there);
		if (talkingDistance <= maxTalkingDistance) {
			return chooseDialogOption(player, map);
		} else {
			return super.playTurn(actions,  map,  display);
		}
	}
	
	// Manhattan distance. - Taken from FollowBehaviour.
	private int distance(Location a, Location b) {
		return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
	}
	
	private Action chooseDialogOption(Actor player, GameMap map) {
		inventory = player.getInventory();
		for (Item item : inventory) {
			if (item.toString().equals("Rocket Plans")) {
				return dialogWithPlans.getAction(this, map);
			}
		}
		return dialogNoPlans.getAction(this, map);
	}
}

