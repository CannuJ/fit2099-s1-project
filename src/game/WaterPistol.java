package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Weapon;
import edu.monash.fit2099.engine.WeaponItem;

public class WaterPistol extends WeaponItem implements Weapon {
	
	private boolean filled;
	private FillWaterPistolAction fillAction;
	
	public WaterPistol() {
		super("Water Pistol", '7', 0, "sqirts water at");
		fillAction = new FillWaterPistolAction(this);
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
		allowableActions.remove(fillAction);
		filled = true;
	}
	
	public void empty() {
		allowableActions.add(fillAction);
		filled = false;
	}

}
