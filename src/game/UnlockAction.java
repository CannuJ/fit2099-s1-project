package game;

import edu.monash.fit2099.engine.*;

public class UnlockAction extends Action {
	
	private Key targetKey;
	private Door targetDoor;

	public UnlockAction(Key targetKey, Door targetDoor) {
		this.targetKey = targetKey;
		this.targetDoor = targetDoor;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		boolean success = targetDoor.unlock(targetKey);
		return (success) ? menuDescription(actor) : actor.toString() + " used the wrong key on the wrong door";
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor.toString() + " unlocks a door with the " + targetKey.toString();
	}

	@Override
	public String hotKey() {
		return "";
	}
}
