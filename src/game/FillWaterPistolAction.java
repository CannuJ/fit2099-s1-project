package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class FillWaterPistolAction extends Action {

	WaterPistol pistol;
	
	public FillWaterPistolAction(WaterPistol pistol) {
		this.pistol = pistol;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		pistol.fill();
		return menuDescription(actor);
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " fills up the water pistol";
	}

	@Override
	public String hotKey() {
		return "";
	}

}
