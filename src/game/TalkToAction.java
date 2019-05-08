package game;

import edu.monash.fit2099.engine.*;

public class TalkToAction extends Action {
	
	public Actor target;
	
	public TalkToAction(Actor target) {
		this.target = target;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		if (target instanceof Talkable) {
			return ((Talkable) target).talk();
		}
		return target.toString() + " does not want to speak with " + actor.toString() + ".";
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor.toString() + " talks to " + target.toString();
	}

	@Override
	public String hotKey() {
		return "t";
	}

}
