package game;

import java.util.ArrayList;
import edu.monash.fit2099.engine.*;

public class LaunchPad extends Ground {
	
	private ArrayList<Item> itemsOnPad = new ArrayList<>();
	/* Avoided using a Map<String, String> here as there's no good way to declare it as a static final literal
	 * without using Java 9. So two arrays are used instead. */
	private static final String[] allowableItemNames = new String[] {"Rocket Body", "Rocket Engine"};
	private static final String[] allowableItemHotkeys = new String[] {"y", "z"};

	public LaunchPad() {
		super('X');
	}
	
	private boolean itemAllowedOnPad(Item item) {
		// Not using streams as I assume we're not allowed to
		for (String allowableName : allowableItemNames) {
			if (item.toString().equals(allowableName)) {
				return true;
			}
		}
		return false;
	}
	
	public void addToPad(Item item, Actor actor) {
		if (itemAllowedOnPad(item) && actor instanceof Player) {
			actor.removeItemFromInventory(item);
			itemsOnPad.add(item);
		}
	}
	
	public String hotkeyFromItemName(String itemName) {
		for (int i = 0; i<allowableItemNames.length; i++) {
			if (allowableItemNames[i].equals(itemName)) {
				return allowableItemHotkeys[i];
			}
		}
		return null;
	}
	
	@Override
	public Actions allowableActions(Actor actor, Location location, String direction){
		Actions actions = new Actions();
		for (Item item : actor.getInventory()) {
			if (itemAllowedOnPad(item)) {
				String hotkey = hotkeyFromItemName(item.toString());
				actions.add(new PlaceOnAction(this, item, hotkey));
			}
		}
		return actions;
	}
	
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}
	
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}

}
