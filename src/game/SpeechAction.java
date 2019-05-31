package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * An Action that enables Actor to speak.
 */
public class SpeechAction extends Action {

	private String text;
	private String target;

	/**
	 * Constructor to create an Action that will display Speech directed to a specific character 
	 * using a given menu hotkey.
	 *
	 *
	 * @param text what the Actor is saying
	 * @param Target who the speech is directed to
	 */
	public SpeechAction(String text, String target) {
		this.text = text;
		this.target = target;
	}

	/**
	 * Constructor to create an Action that will display Speech.
	 *
	 *
	 * @param text what the Actor is saying
	 */
	public SpeechAction(String text) {
		this.text = text;
	}

	/**
	 * Allow the Actor to speak.
	 *
	 * Overrides Action.execute()
	 *
	 * @see Action#execute(Actor, GameMap)
	 * @param actor The actor performing the action.
	 * @param map The map the actor is on.
	 * @return a description of the Action suitable for the menu
	 */
	@Override
	public String execute(Actor actor, GameMap mapactor) {
		return menuDescription(actor);
	}

	/**
	 * Returns a description of this movement suitable to display in the menu.
	 *
	 * @param actor The actor performing the action.
	 * @return a String, e.g. "Player says 'text'."
	 */
	@Override
	public String menuDescription(Actor actor) {
		if (target != null) {
			return actor + " says: \"" + text + "\" to you";
		}
		return actor + " says: \"" + text + "\"";
	}

	@Override
	public String hotKey() {
		return null;
	}
}