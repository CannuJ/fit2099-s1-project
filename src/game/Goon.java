package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;


public class Goon extends Actor{
	
	// Goons have 50 hitpoints and are always represented with a G
	// Priority higher for testing purposes (5->5)
	public Goon(String name, Actor player) {
		super(name, 'G', 5, 50);
		addBehaviour(new FollowBehaviour(player));
		addBehaviour(new InsultAction(player));
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
		
		// Do not allow Goons to drop items while they are still alive
		for (Action action : actions) {
			if (action instanceof DropItemAction) {
				actions.remove(action);
			}
		}
		
		return super.playTurn(actions,  map,  display);
	}
	
	// Goon deals double damage so override IntrinsicWeapon from 5->10
	@Override
	protected IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(10, "punches");
	}
}

