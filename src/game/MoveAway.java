package game;

import edu.monash.fit2099.engine.*;


public class MoveAway implements ActionFactory {

	private Actor target;

	public MoveAway(Actor subject) {
		this.target = subject;
	}

	@Override
	public Action getAction(Actor actor, GameMap map) {
		Location here = map.locationOf(actor);
		Location there = map.locationOf(target);
		
		if (there != null) { // Fixed bug where game crashes when there's no-one to follow
			int currentDistance = distance(here, there);
			if (currentDistance <= 5) {
				for (Exit exit : here.getExits()) {
					Location destination = exit.getDestination();
					if (destination.canActorEnter(actor)) {
						int newDistance = distance(destination, there);
						if (newDistance > 5) {
							return new MoveActorAction(destination, exit.getName());
						}
					}
				}
			}
		}

		return null;
	}

	// Manhattan distance. - Taken from FollowBehaviour.
	private int distance(Location a, Location b) {
		return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
	}
}