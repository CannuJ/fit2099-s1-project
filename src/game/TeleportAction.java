package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.MoveActorAction;

public class TeleportAction extends MoveActorAction {
	
	private String verb;
	private String destinationName;
	private Location moveToLocation;

	public TeleportAction(Location moveToLocation, String verb, String destinationName, String hotKey) {
		super(moveToLocation, destinationName, hotKey);
		this.verb = verb;
		this.destinationName = destinationName;
		this.moveToLocation = moveToLocation;
	}


	public TeleportAction(Location moveToLocation, String verb, String destinationName) {
		super(moveToLocation, destinationName);
		this.verb = verb;
		this.destinationName = destinationName;
		this.moveToLocation = moveToLocation;
	}
	
	/**
	 * Allow the Actor to be moved.
	 *
	 * Overrides Action.execute()
	 *
	 * @see Action#execute(Actor, GameMap)
	 * @param actor The actor performing the action.
	 * @param map The map the actor is on.
	 * @return a description of the Action suitable for the menu
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		// Kill the actor on the position that is being teleported to (telefragging)
		if (map.isAnActorAt(moveToLocation)) {
			Actor telefragedActor = map.actorAt(moveToLocation);
			telefragedActor.hurt(999999); // No way to kill actor, set hitpoints or read hitpoints in the engine, so I need to do this :(
		}
		// Then safely move the actor to the destination
		map.moveActor(actor, moveToLocation);
		return menuDescription(actor);
	}

	/**
	 * Returns a description of this movement suitable to display in the menu.
	 *
	 * @param actor The actor performing the action.
	 * @return a String, e.g. "Player moves east"
	 */
	@Override
	public String menuDescription(Actor actor) {
		return String.format("%s %s to %s", actor, verb, destinationName);
	}

}
