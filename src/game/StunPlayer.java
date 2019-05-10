package game;

import java.util.Random;

import edu.monash.fit2099.engine.*;


public class StunPlayer implements ActionFactory {

	private Actor target;
	private int stunSuccess;

	public StunPlayer(Actor subject) {
		this.target = subject;
	}

	@Override
	public Action getAction(Actor actor, GameMap map) {
		Location here = map.locationOf(actor);
		Location there = map.locationOf(target);
		
		int currentDistance = distance(here, there);
		
		if (currentDistance <= 5) {
			
		}
			this.stunSuccess = new Random().nextInt(1); // Random Integer between 0-1
			if (stunSuccess == 1) { // 50% Chance
				return new StunAction(target);
		}
		return null;
	}

	// Manhattan distance. - Taken from FollowBehaviour.
	private int distance(Location a, Location b) {
		return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
	}
}