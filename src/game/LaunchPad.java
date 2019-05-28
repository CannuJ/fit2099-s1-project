package game;

import java.util.ArrayList;
import edu.monash.fit2099.engine.*;

public class LaunchPad extends Ground {
	
	/**
	 * Represents a launch pad, which is a solid object in the game world.
	 * The player must put the Rocket Body and Rocket Engine on this launch pad in order to win the game
	 * 
	 */
	
	private ArrayList<Item> itemsOnPad = new ArrayList<>();
	private static final String[] allowableItemNames = new String[] {"Rocket Body", "Rocket Engine"};
	private Location destination;
	private boolean completedRocket;
	private String destinationName;

	/**
	 * Constructor for the launch pad using Ground's constructor
	 * The launch pad is represented by an 'X' when the rocket is incomplete
	 * @param newMap the destination game map for the player once the rocket has been completed and can be flown
	 * @param newX the destination x coordinate for the player once the rocket has been completed and can be flown
	 * @param newMap the destination y coordinate for the player once the rocket has been completed and can be flown
	 * @param destinationName a String describing the name of the destination. Will be prepended with "Player moves to" 
	 * 			when the player flies the rocket
	 * @param completedRocket a boolean representing whether the launch pad should contain a complete rocket when it is created or not
	 */
	public LaunchPad(GameMap newMap, int newX, int newY, String destinationName, boolean completedRocket) {
		super('X');
		this.destination = newMap.at(newX, newY);
		this.destinationName = destinationName;
		if (completedRocket) {
			completeRocket();
		} else {
			this.completedRocket = false;
		}
	}
	
	/**
	 * Constructor for the launch pad using Ground's constructor
	 * The launch pad is represented by an 'X' when the rocket is incomplete
	 * This constructor creates an incomplete launchpad (without a rocket)
	 * @param newMap the destination game map for the player once the rocket has been completed and can be flown
	 * @param newX the destination x coordinate for the player once the rocket has been completed and can be flown
	 * @param newMap the destination y coordinate for the player once the rocket has been completed and can be flown
	 * @param destinationName a String describing the name of the destination. Will be prepended with "Player moves to" 
	 * 			when the player flies the rocket
	 */
	public LaunchPad(GameMap newMap, int newX, int newY, String destinationName) {
		super('X');
		this.destination = newMap.at(newX, newY);
		this.destinationName = destinationName;
		this.completedRocket = false;
	}
	
	/**
	 * Checks if a given item is one that has been allowed to be placed on the launch pad (i.e. a rocket part)
	 * @param item the item to check if it is permitted
	 * @return true if it is allowed, false otherwise
	 */
	private boolean itemAllowedOnPad(Item item) {
		// Not using streams as I assume we're not allowed to
		for (String allowableName : allowableItemNames) {
			if (item.toString().equals(allowableName)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Sets the launch pad to its 'complete' status, meaning now holds a fully functioning rocket
	 * This also changes the launchpad's display character to a rocket (use your imagination)
	 */
	private void completeRocket() {
		completedRocket = true;
		displayChar = '^';
	}
	
	/**
	 * Adds a given item onto the launch pad
	 * Will only add it if it is an item specified as a permitted item
	 * Sets the rocket to its 'complete' status once every item has been collected
	 * @param item the item to add to the launch pad
	 * @param actor the player who possesses the given item in their inventory
	 */
	public void addToPad(Item item, Actor actor) {
		if (itemAllowedOnPad(item) && actor instanceof Player) {
			actor.removeItemFromInventory(item);
			itemsOnPad.add(item);
			if (itemsOnPad.size() == allowableItemNames.length) {
				completeRocket();
			}
		}
	}
	
	/**
	 * Provides Actions that are able to be executed on contact with the launch pad
	 * Will allow the player to add any items that are specified as an allowed item by this class
	 * to the launch pad's collection of items
	 * 
	 * Checks to see if the player has placed all required items onto the launch pad.
	 * If they have, then an action of moving to the rocket's given destination is given to the player.
	 * 
	 * Only the player will receive any actions from the launch pad.
	 * 
	 * @param actor the actor who interacts with the launch pad
	 * @param location
	 * @param direction
	 * @return a collection of actions (instance of Actions) which are able to be conducted by the actor 
	 */
	@Override
	public Actions allowableActions(Actor actor, Location location, String direction){
		Actions actions = new Actions();
		
		// Only the player can interact with the rocket
		if (actor instanceof Player) { 
			if (!completedRocket) {
				// Add place-on actions for each inventory item which can be added to the pad
				for (Item item : actor.getInventory()) { 
					if (itemAllowedOnPad(item)) {
						actions.add(new PlaceOnAction(this, item, null));
					}
				}
			} else {
			// Allow the player to move to the rocket's destination
				actions.add(new MoveActorAction(destination, destinationName));
			}
		}
		return actions;
	}
	
	/**
	 * Actors can not pass through this object
	 * @param actor
	 * @return false
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}
	
	/**
	 * This object blocks thrown objects
	 * @return true
	 */
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}

}
