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

	public QuittablePlayer(String name, char displayChar, int priority, int hitPoints) {
		super(name, displayChar, priority, hitPoints);
	}
	
	public Action playTurn(Actions actions, GameMap map, Display display) {
		actions.add(new QuitGameAction());
		return super.playTurn(actions, map, display);
	}

}
