package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * An Action that enables Actor to speak.
 */
public class StunAction extends Action {

	private Actor target;

	/**
	 * Constructor to create an Action that will stun a specific character using a given menu hotkey.
	 *
	 *
	 * @param target who the stun is directed to
	 */
	public StunAction(Actor target) {
		this.target = target;
	}

	/**
	 * Allow the Actor to stun a target.
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
	 * Returns a description of the stun suitable to display in the menu.
	 *
	 * @param actor The actor performing the action.
	 */
	@Override
	public String menuDescription(Actor actor) {
		if (target != null) {
			return actor + " throws a stun bag at " + target;
		}
		return actor + " throws a stun back at you!";
	}

	@Override
	public String hotKey() {
		return null;
	}
}