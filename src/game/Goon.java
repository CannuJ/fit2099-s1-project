package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;


// Would rather extend from Grunt... (Is this possible?)
public class Goon extends Actor{
	
	// Goon have 50 hitpoints and are always represented with a n
	// TODO Change display letter (Currently set to 'n')
	// Priority higher for testing purposes (5->8)
	public Goon(String name, Actor player) {
		super(name, 'n', 8, 50);
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
				//TODO Check if action is an AttackAction and change damage
				return action;
		}
		
		return super.playTurn(actions,  map,  display);
	}
}

