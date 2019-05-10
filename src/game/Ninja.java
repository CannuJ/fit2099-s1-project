package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;


public class Ninja extends Actor{
	
	// Ninja have 50 hitpoints and are always represented with a N
	// Priority higher for testing purposes (5->5)
	public Ninja(String name, Actor player) {
		super(name, 'N', 5, 50);
		addBehaviour(new MoveAway(player));
		addBehaviour(new StunPlayer(player));
	}

	private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();

	private void addBehaviour(ActionFactory behaviour) {
		actionFactories.add(behaviour);
	}

	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		actions.clear(); // Clearing default actions, will tidy in next iteration
		actions.add(new SkipTurnAction()); // Must include SkipTurnAction for now
		for (ActionFactory factory : actionFactories) {
			Action action = factory.getAction(this, map);
			if(action != null)
				return action;
		}
		
		return super.playTurn(actions,  map,  display);
	}
}

