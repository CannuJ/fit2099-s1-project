package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;


// Would rather extend from Grunt... (Is this possible?)
public class DrMaybe extends Actor{
	
	// DrMaybe has 50 hitpoints and is always represented with a M
	// Priority higher for testing purposes (5->5)
	public DrMaybe(String name, Actor player) {
		super(name, 'M', 5, 50);
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
	
	// DrMaybe deals half damage so override IntrinsicWeapon from 5->2
	//TODO: Needs to be 2.5
	@Override
	protected IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(2, "punches");
	}
}

