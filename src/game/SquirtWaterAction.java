package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class SquirtWaterAction extends Action {
	
	private FinalBoss target;

	public SquirtWaterAction(FinalBoss target) {
		this.target = target;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		
		WaterPistol pistol = WaterPistol.getWaterPistolFrom(actor);
		String description = menuDescription(actor);
		
		if (target.hasExoskeleton() && pistol.hasWater()) {
			description += "\n" + target + "'s exoskeleton breaks!";
			target.shed();
		}
		pistol.empty();
		
		return description;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " squirts " + target + "'s exoskeleton with a water pistol";
	}

	@Override
	public String hotKey() {
		return "";
	}

}
