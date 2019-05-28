package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Player;

/**
 * A class describing a tile that only the Player can walk through
 * This tile is not solid, so thrown objects may still pass through it
 * Useful for situations where the player is teleporting between worlds where an enemy or an
 * NPC might be in the way.
 */

public class PlayerOnlyTile extends Ground {
	
	/**
	 * Constructor for the PlayerOnlyTile
	 * @param displayChar The character to display on the map
	 */

	public PlayerOnlyTile(char displayChar) {
		super(displayChar);
	}
	
	/**
	 * Will only let an actor through if they are a Player
	 * @param actor The actor tying to enter the tile
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		return actor instanceof Player;
	}
	
	@Override
	public boolean blocksThrownObjects() {
		return false;
	}

}
