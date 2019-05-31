package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.AttackAction;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.IntrinsicWeapon;
import edu.monash.fit2099.engine.SkipTurnAction;

public class FinalBoss extends Actor{
	
	private boolean exoskeleton;
	private static final char exoskeletonChar = 'Y';
	private static final char noExoskeletonChar = 'y';
	
	// Priority higher for testing purposes (5->5)
	public FinalBoss(String name, Actor player) {
		super(name, exoskeletonChar, 5, 50);
		this.exoskeleton = true;
	}
	
	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		Actions actions = new Actions();
		
		WaterPistol pistol = WaterPistol.getWaterPistolFrom(otherActor);
		if (!hasExoskeleton()) {
			return new Actions(new AttackAction(otherActor, this));
		} else if (pistol != null && pistol.hasWater()) {
			return new Actions(new SquirtWaterAction(this)); // Player is able to break the boss' exoskeleton
		}
			
		return actions;
	}

	/**
	 * Executes whenever finalBoss takes their turn.
	 * In normal circumstances, Yugo Maxx will roam around the map without attacking any other Actors
	 * If the Player is within attacking distance, finalBoss will attack instead.
	 * 
	 * @param actions collection of possible Actions for this Actor
	 * @param map     the map containing the Actor
	 * @param display the I/O object to which messages may be written
	 * @return the Action to be performed
	 * 
	 */
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		for (Action action : actions) {
			if (!(action instanceof AttackAction || action instanceof SkipTurnAction)) {
				actions.remove(action);
			}
		}
		return super.playTurn(actions,  map,  display);
	}
	
	/**
	 * If Yugo Maxx has the ExoSkeleton on, ignore damage.
	 *
	 * @param points number of hitpoints to deduct.
	 */
	@Override
	public void hurt(int points) {
		if (!hasExoskeleton()) {
			hitPoints -= points; // Engine prints the wrong thing
		}
	}
	
	public boolean hasExoskeleton() {
		return exoskeleton;
	}
	
	// finalBoss deals double damage so override IntrinsicWeapon from 5->10
	@Override
	protected IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(10, "punches");
	}
	
	public void shed() {
		exoskeleton = false;
		displayChar = noExoskeletonChar;
		
	}
}


