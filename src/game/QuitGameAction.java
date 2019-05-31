package game;

import edu.monash.fit2099.engine.*;

public class QuitGameAction extends Action {
	/**
	 * Action which represents the player quitting the game.
	 * If this action is executed the game terminates
	 */
	@Override
	public String menuDescription(Actor actor) {
		return "Quit the game";
	}

	/**
	 * Returns the hotkey used for a give action
	 * @return the hotkey for the give action
	 */
	@Override
	public String hotKey() {
		return "x";
	}
	

	/**
	 * Exits the game when the player uses the action
	 * @param actor
	 * @param map
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		System.exit(0);
		return null;
	}

}
