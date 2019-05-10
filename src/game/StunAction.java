package game;

import edu.monash.fit2099.engine.*;
import java.util.*;

public class StunAction implements ActionFactory {

	private Actor target;
	private int stunSuccess;

	public StunAction(Actor subject) {
		this.target = subject;
	}
	
	@Override
	public Action getAction(Actor actor, GameMap map) {
		
		this.stunSuccess = new Random().nextInt(1); // Random Integer between 0-1
		
		if (stunSuccess == 1) { // 50% Chance
			return null;
		}
		 
		return null;
	}

}

