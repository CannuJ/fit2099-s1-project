package game;

import edu.monash.fit2099.engine.*;

public class PlaceOnAction extends Action {
	
	private Item itemToPlace;
	private LaunchPad launchPad;
	private String hotkey;

	public PlaceOnAction(LaunchPad launchPad, Item itemToPlace, String hotkey) {
		this.itemToPlace = itemToPlace;
		this.launchPad = launchPad;
		this.hotkey = hotkey;
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		if (actor instanceof Player) {
			launchPad.addToPad(itemToPlace, actor);
			return actor.toString() + " placed the " + itemToPlace.toString() + " on the launch pad!";
		}
		return null;
	}

	@Override
	public String menuDescription(Actor actor) {
		return "Place " + itemToPlace.toString() + " on the launch pad";
	}

	@Override
	public String hotKey() {
		return hotkey;
	}

}
