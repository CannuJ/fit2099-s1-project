package game;

import edu.monash.fit2099.engine.Ground;

public class OxygenDispenser extends Ground {

	/**
	 * Represents an item that allows the Actor to produce Oxygen, needed for venturing to the moon
	 */
	
	private String name;
	
	public OxygenDispenser(char displayChar) {
		super(displayChar);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Converts a OxygenTank to a string for printing
	 * @return the name of the OxygenTank
	 */
	public String toString() {
		return name;
	}
}
