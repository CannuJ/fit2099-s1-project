package game;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

public class Water extends Ground {

	public Water() {
		super('~');
	}
	
	@Override
	public Actions allowableActions(Actor actor, Location location, String direction){
		Actions actions = new Actions();
		WaterPistol pistol = WaterPistol.getWaterPistolFrom(actor);
		if (pistol != null && !pistol.hasWater()) {
			actions.add(new FillWaterPistolAction(pistol));
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
