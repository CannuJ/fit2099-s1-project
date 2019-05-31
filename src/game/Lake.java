package game;

import edu.monash.fit2099.engine.GameMap;

/**
 * A class that places a body of water (Water objects) on a given map, within given bounds.
 * This can be used to create a lake, river, beach or something similar.
 */

public class Lake {
	
	private GameMap map;
	private int startX, endX, startY, endY;

	/**
	 * Constructor for the Lake class
	 * Provides the class with information about the body of water that is to be created
	 * @param map The map to place the lake into
	 * @param startX The starting x coordinate of the lake
	 * @param endX The ending x coordinate of the lake
	 * @param startY The starting y coordinate of the lake
	 * @param endY The ending y coordinate of the lake
	 */
	Lake(GameMap map, int startX, int endX, int startY, int endY){
		this.map = map;
		this.startX = startX;
		this.endX = endX;
		this.startY = startY;
		this.endY = endY;
	}
	
	/**
	 * Places the Water objects (the body of water itself) onto the map
	 * provided by the constructor
	 */
	public void buildLake() {	
		for (int x = startX; x < endX; x++) {
			for (int y = startY; y < endY; y++) {
					map.add(new Water(), map.at(x, y));		
			}
		}
	}

}
