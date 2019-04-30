package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.*;



public class Goon extends Grunt{
	// Goon have 50 hitpoints and are always represented with a g
	public Goon(String name, Actor player) {
		super(name, player);
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
		
		return super.playTurn(actions,  map,  display);
	}
}

