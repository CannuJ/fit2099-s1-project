package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Player;

/**
 * A small wrapper for the Player class which allows the player to quit the game at any time
 * by adding a QuitGameAction to their list of actions every turn
 */
public class QuittablePlayer extends Player {

	/**
	 * Constructor.
	 *
	 * @param name Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param priority How early in the turn the player can act
	 * @param hitPoints Player's starting number of hitpoints
	 */
	public QuittablePlayer(String name, char displayChar, int priority, int hitPoints) {
		super(name, displayChar, priority, hitPoints);
	}
	
	/**
	 * Play a turn. Doing this means displaying a menu to the user and getting their selected option.
	 *
	 * Adds the ability to quit the game then executes the parent's version of this method
	 * 
	 * @param actions the actions to display
	 * @param map the map to display
	 * @param display the object that performs the console I/O
	 * @return the Action that the user selects
	 */
	public Action playTurn(Actions actions, GameMap map, Display display) {
		actions.add(new QuitGameAction());
		return super.playTurn(actions, map, display);
	}
	
	
	/**
	 * Do some damage to the current Actor.
	 * If the Actor's hitpoints go down to zero, a game over screen will be shown
	 *
	 * @param points number of hitpoints to deduct.
	 */
	public void hurt(int points) {
		hitPoints -= points;
		if (hitPoints <= 0) {
			new GameOver().show();
		}
	}

}
