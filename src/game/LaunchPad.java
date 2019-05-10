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
	
	/* Avoided using a Map<String, String> here as there's no good way to declare it as a static final literal
	 * without using Java 9. (Not sure if Java 9 can be used) So two arrays are used instead. */
	private static final String[] allowableItemNames = new String[] {"Rocket Body", "Rocket Engine"};
	private static final String[] allowableItemHotkeys = new String[] {"y", "z"};

	/**
	 * Constructor for the launch pad using Ground's constructor
	 * The launch pad is always represented by an "X"
	 */
	public LaunchPad() {
		super('X');
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
	 * Adds a given item onto the launch pad
	 * Will only add it if it is an item specified as a permitted item
	 * @param item the item to add to the launch pad
	 * @param actor the player who possesses the given item in their inventory
	 */
	public void addToPad(Item item, Actor actor) {
		if (itemAllowedOnPad(item) && actor instanceof Player) {
			actor.removeItemFromInventory(item);
			itemsOnPad.add(item);
		}
	}
	
	/**
	 * Translates between the allowed item's name to a hotkey 
	 * which is assigned to the action of adding it to the pad
	 * @param itemName a String of the item's name which is to be translated to a hotkey
	 * @return the hotkey as a String, null if it is not found in the predetermined array of permitted names
	 */
	private String hotkeyFromItemName(String itemName) {
		for (int i = 0; i<allowableItemNames.length; i++) {
			if (allowableItemNames[i].equals(itemName)) {
				return allowableItemHotkeys[i];
			}
		}
		return null;
	}
	
	/**
	 * Provides Actions that are able to be executed on contact with the launch pad
	 * Will allow the player to add any items that are specified as an allowed item by this class
	 * to the launch pad's collection of items
	 * 
	 * Checks to see if the player has placed all required items onto the launch pad.
	 * If they have, then an action winning the game is offered to the player (flying the rocket)
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
		for (Item item : actor.getInventory()) {
			if (itemAllowedOnPad(item)) {
				String hotkey = hotkeyFromItemName(item.toString());
				actions.add(new PlaceOnAction(this, item, hotkey));
			}
		}
		if (itemsOnPad.size() == allowableItemNames.length) {
			actions.add(new WinAction());
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
