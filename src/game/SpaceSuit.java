package game;

import edu.monash.fit2099.engine.Item;

public class SpaceSuit extends Item {
	
	/**
	 * Represents an item which is also wearable, and allows the Actor to move on the moon
	 */
	
	private String name;
	private Integer oxygenLevel;
	
	/**
	 * Constructor for a SpaceSuit
	 * The character representation of a SpaceSuit is always 'S'
	 * @param name the name of the SpaceSuit
	 */
	public SpaceSuit(String name) {
		super(name, 'S');
		this.name = name;
	}
	
	/**
	 * Converts a SpaceSuit to a string for printing
	 * @return the name of the SpaceSuit
	 */
	public String toString() {
		return name;
	}
}
