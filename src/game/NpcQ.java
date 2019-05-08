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
	
	private ActionFactory dialogNoPlans;
	private ActionFactory dialogWithPlans;

	public NpcQ(String name, Actor player) {
		super(name, 'Q', 10, 100);
		dialogNoPlans = new DialogAction(player, speechNoPlans);
		dialogWithPlans = new DialogAction(player, speechWithPlans);
	}

	// TODO: add speech functionality
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		return super.playTurn(actions,  map,  display);
		// Uncomment to make Q talk every turn
//		return dialogNoPlans.getAction(this, map);
	}
}

