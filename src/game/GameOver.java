package game;

import edu.monash.fit2099.engine.Display;


/**
 * A class that simply shows a game over screen (win or lose) then quits the game
 */
public class GameOver {

	private boolean win;
	private Display endScreen;
	
	private static final String winMessage = "Congratulations, you won the game!\n"
			+ "You defeated the evil millionare industrialist Yugo Maxx\n"
			+ "and his band of grunts, goons and other horrors!\nYOU WIN.";
	
	private static final String loseMessage = "Game over!\n"
			+ "Looks like the evil millionare industrialist Yugo Maxx\n"
			+ "and his minions proved to much for you to handle!\n"
			+ "All well, the Moon was overrated anyway.\n";

	/**
	 * Constructor
	 * @param win boolean true if the player has won, false if they have lost
	 */
	public GameOver(boolean win) {
		this.win = win;
		this.endScreen = new Display();
	}
	
	/**
	 * Version of the constructor where losing is default
	 */
	public GameOver() {
		this(false);
	}
	
	/**
	 * Displays/executes the game over screen, depending on the win or lose state specified in the constructor
	 * The game will terminate when this method is called
	 */
	public void show() {
		String message = (win) ? winMessage : loseMessage;
		endScreen.println("\n\n" + message + "\n");
		endScreen.println("Press enter to continue...");
		endScreen.readChar();
		System.exit(0);
	}

}
