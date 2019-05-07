package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;


public class NpcQ extends Actor{
	
	/*
	 * The Actor class that implements the in-game NPC named Q.
	 * Q is an integral part of the story as he gives the player the rocketBody item
	 * used to complete the game.
	 * 
	 * The only action Q has is to talk with the player
	 */

	public NpcQ(String name, Actor player) {
		super(name, 'Q', 10, 100);
//		addBehaviour(new SpeechBehaviour(player));
	}

	private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();

	private void addBehaviour(ActionFactory behaviour) {
		actionFactories.add(behaviour);
	}

	// TODO: add speech functionality
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		for (ActionFactory factory : actionFactories) {
			Action action = factory.getAction(this, map);
			if(action != null)
				return action;
		}
		
		return super.playTurn(actions,  map,  display);
	}
}

