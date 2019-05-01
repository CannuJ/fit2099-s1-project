package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import java.util.*;

public class InsultAction extends Action {

	private Actor actor;
	private Actor subject;
	private int insVal;

	public InsultAction(Actor actor, Actor subject) {
		this.actor = actor;
		this.subject = subject;
		this.insVal = new Random().nextInt(5); // Random Integer between 0-4
	}
	
	String[] insultArray = new String[]{"You suck!", "Haha!", "Lol!", "Try again!", "You're lame!"}; 

	@Override
	public String execute(Actor actor, GameMap map) {
		return actor + " shouts at " + subject + insultArray[insVal];
	}

	@Override
	public String menuDescription(Actor actor) {
		return "Shout at " + subject;
	}

	@Override
	public String hotKey() {
		return "";
	}
}
