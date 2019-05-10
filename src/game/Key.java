package game;

import edu.monash.fit2099.engine.Item;

public class Key extends Item {

	private static int keyCount = 0;
	private Door door;
	
	public Key(Door door) {
		super("Key #" + (++keyCount), '1');
		this.door = door;
	}

	public Door getDoor() {
		return door;
	}

}
