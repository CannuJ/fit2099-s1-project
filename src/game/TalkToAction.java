package game;

import edu.monash.fit2099.engine.*;

public class TalkToAction extends Action {
	
	/**
	 * An action describing the ability of talking to another actor
	 * Actors can respond to the player by implementing the Talkable interface
	 * 
	 */
	
	public Actor target;
	
	/**
	 * Constructor for the TalkToAction action
	 * @param target the actor which is to be talked to
	 */
	public TalkToAction(Actor target) {
		this.target = target;
	}

	/**
	 * The execution of this action
	 * Checks to see if the target is 'talkable' by implementing the Talkable interface
	 * Otherwise, just returns a generic response to the player
	 * @param the actor starting the conversation (generally the player)
	 * @param the map in which the action takes place
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		if (target instanceof Talkable) {
			return ((Talkable) target).talk();
		}
		return target.toString() + " does not want to speak with " + actor.toString() + ".";
	}

	/**
	 * Returns a description of the talk to action suitable for the game menu
	 * @param actor the Actor performing the action
	 */
	@Override
	public String menuDescription(Actor actor) {
		return actor.toString() + " talks to " + target.toString();
	}

	/**
	 * Returns the hotkey used for a talk to action
	 * @return the hotkey for the talk to action
	 */
	@Override
	public String hotKey() {
		return "t";
	}

}
