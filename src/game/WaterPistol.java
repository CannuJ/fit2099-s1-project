package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Item;

public class WaterPistol extends Item {
	
	private boolean filled;
	
	public WaterPistol() {
		super("Water Pistol", '7');
		empty();
	}
	
	public static WaterPistol getWaterPistolFrom(Actor actor) {
		for (Item item : actor.getInventory()) {
			if (item instanceof WaterPistol) {
				return (WaterPistol) item;
			}
		}
		return null;
	}
	
	public void fill() {
		filled = true;
	}
	
	public void empty() {
		filled = false;
	}
	
	public boolean hasWater() {
		return filled;
	}

}
