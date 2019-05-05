package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import java.util.*;

public class InsultAction implements ActionFactory {

	private Actor target;
	private int insVal;

	public InsultAction(Actor subject) {
		this.target = subject;
		this.insVal = new Random().nextInt(5); // Random Integer between 0-4
	}
	
	@Override
	public Action getAction(Actor actor, GameMap map) {
		
		String[] insultArray = new String[]{"You suck!", "Haha!", "Lol!", "Try again!", "You're too slow!"}; 
		
		return null;
	}

}

