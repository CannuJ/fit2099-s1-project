package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;



public class Grunt extends Actor {

	// Grunts have 50 hitpoints and are always represented with a g
	public Grunt(String name, Actor player) {
		super(name, 'g', 5, 50);
		addBehaviour(new FollowBehaviour(player));
	}

	private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();

	private void addBehaviour(ActionFactory behaviour) {
		actionFactories.add(behaviour);
	}

	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		for (ActionFactory factory : actionFactories) {
			Action action = factory.getAction(this, map);
			if(action != null)
				return action;
		}
		
		// Do not allow Grunts to drop items while they are still alive
		for (Action action : actions) {
			if (action instanceof DropItemAction) {
				actions.remove(action);
			}
		}
		
		return super.playTurn(actions,  map,  display);
	}
}
