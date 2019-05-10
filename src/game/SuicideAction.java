package game;

import edu.monash.fit2099.engine.*;

public class SuicideAction extends Action {
	
	/**
	 * An action that represents an Actor deleting itself from the GameMap
	 */
	
	Actor actor;
	
	/**
	 * Constructor for the SuicideAction object
	 * @param actor the actor deleting itself
	 */
	public SuicideAction(Actor actor) {
		this.actor = actor;
	}

	/**
	 * The actor deletes itself from the given game map on execution of this Action
	 * @param actor the actor deleting itself
	 * @param map the map in which the actor is contained in
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		map.removeActor(actor);
		return menuDescription(actor);
	}

	/**
	 * Returns a description of the 'suicide' action suitable for the game menu (and for younger audiences)
	 * @param actor the Actor performing the action
	 */
	@Override
	public String menuDescription(Actor actor) {
		return actor + " diappears...";
	}

	/**
	 * The hotkey used to invoke the suicide action
	 * @return null, as the suicide action is not able to be executed by the player
	 */
	@Override
	public String hotKey() {
		return null;
	}

}
