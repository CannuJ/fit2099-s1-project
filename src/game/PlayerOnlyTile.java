package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Player;

public class PlayerOnlyTile extends Ground {

	public PlayerOnlyTile(char displayChar) {
		super(displayChar);
	}
	
	@Override
	public boolean canActorEnter(Actor actor) {
		return actor instanceof Player;
	}
	
	@Override
	public boolean blocksThrownObjects() {
		return false;
	}

}
