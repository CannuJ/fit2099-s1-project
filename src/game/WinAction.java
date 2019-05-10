package game;

import edu.monash.fit2099.engine.*;

public class WinAction extends Action {
	
	private Display endScreen = new Display();
	
	private static final String winMessage = "\n\n\nCongratulations, you won the game!\n"
											+ "You built the rocket and flew away from this planet\n"
											+ "filled with Goons, Ninjas and other creatures.\n\n";

	@Override
	public String execute(Actor actor, GameMap map) {
		winState();
		return null;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor.toString() + " flies the rocket";
	}

	@Override
	public String hotKey() {
		return "x";
	}
	
	private void winState() {
		endScreen.println(winMessage);
		endScreen.println("Press enter to continue...");
		endScreen.readChar();
		System.exit(0);
		
	}

}
