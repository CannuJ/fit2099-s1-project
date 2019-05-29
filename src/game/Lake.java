package game;

import edu.monash.fit2099.engine.GameMap;

public class Lake {
	
	private GameMap map;
	private int startX, endX, startY, endY;

	Lake(GameMap map, int startX, int endX, int startY, int endY){
		this.map = map;
		this.startX = startX;
		this.endX = endX;
		this.startY = startY;
		this.endY = endY;
	}
	
	public void buildLake() {	
		for (int x = startX; x < endX; x++) {
			for (int y = startY; y < endY; y++) {
					map.add(new Water(), map.at(x, y));		
			}
		}
	}

}
