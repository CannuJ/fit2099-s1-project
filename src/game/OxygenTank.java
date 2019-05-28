package game;

import edu.monash.fit2099.engine.Item;

public class OxygenTank extends Item {
	
	/**
	 * Represents an item that allows the Actor to produce Oxygen, needed for venturing to the moon
	 */
	
	private String name;
	
	/**
	 * Constructor for a OxygenTank
	 * The character representation of a OxygenTank is always 'o'
	 * @param name the name of the OxygenTank
	 */
	public OxygenTank(String name) {
		super(name, 'o');
		this.name = name;
	}
	
	/**
	 * Converts a OxygenTank to a string for printing
	 * @return the name of the OxygenTank
	 */
	public String toString() {
		return name;
	}
}
