package game;

import edu.monash.fit2099.engine.*;

public class Door extends Ground {

	private boolean locked;

	public Door(boolean locked) {
		super('=');
		this.locked = locked;
	}
	
	@Override
	public boolean canActorEnter(Actor actor) {
		return !locked;
	}
	
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}

}
