package game;

import edu.monash.fit2099.engine.*;

public class WinAction extends Action {
	/**
	 * Action which represents the player winning the game.
	 * If this action is executed, the player 'wins' and the game *terminates*
	 * This action should only ever be offered by something which is a win condition
	 */
	
	private Display endScreen = new Display();
	
	private static final String winMessage = "\n\n\nCongratulations, you won the game!\n"
											+ "You built the rocket and flew away from this planet\n"
											+ "filled with Goons, Ninjas and other creatures.\n\n";

	/**
	 * When executed, the game is finished (player wins) and the application is terminated
	 * @param actor
	 * @param map
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		winState();
		return null;
	}

	/**
	 * Provides the description given in the menu for flying the rocket
	 * @return String of the description outlined above
	 * @param actor
	 */
	@Override
	public String menuDescription(Actor actor) {
		return actor.toString() + " flies the rocket";
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
	 * Shows the user the win screen
	 * User is shown a win message, then the game terminates after the player presses enter
	 */
	private void winState() {
		endScreen.println(winMessage);
		endScreen.println("Press enter to continue...");
		endScreen.readChar();
		System.exit(0);
		
	}

}
