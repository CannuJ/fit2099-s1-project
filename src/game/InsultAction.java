package game;

import edu.monash.fit2099.engine.*;
import edu.monash.fit2099.engine.SpeechAction;

import java.util.*;

public class InsultAction implements ActionFactory {

	private Actor target;
	private int insVal;
	private String[] insultArray = new String[]{"You suck!", "Haha!", "Lol!", "Try again!", "You're too slow!"};

	public InsultAction(Actor subject) {
		this.target = subject;
	}
	
	@Override
	public Action getAction(Actor actor, GameMap map) {
		
		this.insVal = new Random().nextInt(5); // Random Integer between 0-4
		String insult = insultArray[insVal];
		int chance = new Random().nextInt(9); // Random Integer between 0-9
		
		if (chance > 4) { // Currently not set to 10% for testing (About 50%)
			return new SpeechAction(insultArray[insVal]);
		}
		 
		return null;
	}

}

