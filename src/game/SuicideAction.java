package game;

import edu.monash.fit2099.engine.*;

public class SuicideAction extends Action {
	
	Actor actor;
	GameMap gameMap;
	
	public SuicideAction(Actor actor, GameMap gameMap) {
		this.actor = actor;
		this.gameMap = gameMap;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		gameMap.removeActor(actor);
		return menuDescription(actor);
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " diappears...";
	}

	@Override
	public String hotKey() {
		return null;
	}

}
