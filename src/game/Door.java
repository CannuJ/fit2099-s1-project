package game;

import java.util.ArrayList;
import edu.monash.fit2099.engine.*;

public class Door extends Ground {

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
	
	public Key createKey(String keyName) {
		Key newKey = new Key(keyName);
		keys.add(newKey);
		return newKey;
	}
	
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
		
		// Only add actions if the actor is the player
		if (actor instanceof Player) { 
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
