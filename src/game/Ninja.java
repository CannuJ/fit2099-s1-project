package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;


public class Ninja extends Actor{
	
	// Ninja have 50 hitpoints and are always represented with a N
	// Priority higher for testing purposes (5->5)
	public Ninja(String name, Actor player) {
		super(name, 'N', 5, 50);
		// No FollowBehaviour
		// TODO: Implement MoveAway if within 5 spaces from Player
		// TODO: StunBag
	}

	private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();

	private void addBehaviour(ActionFactory behaviour) {
	}

	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		for (ActionFactory factory : actionFactories) {
			Action action = factory.getAction(this, map);
			if(action != null)
				return action;
		}
		
		return super.playTurn(actions,  map,  display);
	}
	
	// TODO: StunBag Override?
}

