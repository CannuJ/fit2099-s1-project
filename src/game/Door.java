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
		updateChar();
		this.locked = locked;
	}
	
	public Key createKey() {
		Key newKey = new Key(this);
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
			return true;
		}
		return false;
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
