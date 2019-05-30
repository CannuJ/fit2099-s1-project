package game;

import java.util.ArrayList;
import edu.monash.fit2099.engine.*;

public class Door extends Ground {

	/**
	 * Represents a door which can be locked and unlocked with its correct key
	 * When created, a door is in one state (locked or unlocked)
	 * It is permanently in this state until it is locked or unlocked using an appropriate action,
	 * that provides a key that is tied to this door.
	 * 
	 * This door can generate key items that can modify it using `createKey(String keyName)`
	 * Doors store their generated keys in a list meaning that one door may have many keys but not vice versa
	 */
	
	private boolean locked;
	private ArrayList<Key> keys = new ArrayList<>();
	private static final char lockedChar = '=';
	private static final char unlockedChar = '[';
	
	
	public Door(boolean locked) {
		super(lockedChar);
		this.locked = locked;
		updateChar();
	}
	
	public Door() {
		this(true);
	}
	
	/** Generates a key item for the door
	 * This key can only lock/unlock this door
	 * 
	 * @param keyName
	 * @return the key
	 */
	public Key createKey(String keyName) {
		Key newKey = new Key(keyName);
		keys.add(newKey);
		return newKey;
	}
	
	/** Generates a key item, with the appropriate allowable actions to 
	 * be placed into an Actor's inventory on creation for the door
	 * This key can only lock/unlock this door
	 * 
	 * @param keyName
	 * @return the key
	 */
	public Key createInventoryKey(String keyName) {
		Key newKey = createKey(keyName);
		newKey.forInventory();
		return newKey;
	}
	
	/**
	 * checks if key is correct
	 * @param givenKey
	 * @return key is correct
	 */
	private boolean isCorrectKey(Key givenKey) {
		return keys.contains(givenKey);
	}
	
	private void updateChar() {
		displayChar = (locked) ? lockedChar : unlockedChar;
	}
	
	private boolean changeLockState(Key key, boolean newState) {
		if (isCorrectKey(key)) {
			locked = newState;
			updateChar();
			return true;
		}
		return false;
	}
	
	public Actions allowableActions(Actor actor, Location location, String direction){
		Actions actions = new Actions();
		
		// Only add actions if the actor is the player and is locked
		if (actor instanceof Player && locked) { 
			for (Item item : actor.getInventory()) { 
				if (item instanceof Key) {
					actions.add(new UnlockAction((Key)item, this));
				}
			}
		}
		return actions;
	}
	
	public boolean lock(Key key) {
		return changeLockState(key, true);
	}
	
	public boolean unlock(Key key) {
		return changeLockState(key, false);
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
