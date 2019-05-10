package game;

import edu.monash.fit2099.engine.Item;

public class Key extends Item {
	
	/**
	 * Represents an item which is also a key to a locked door
	 * This class should only be created via a door
	 */
	
	private String name;
	
	/**
	 * Constructor for a key
	 * The character representation of a key is always '1'
	 * @param name the name of the key (e.g. rusty key, back door key etc...)
	 */
	public Key(String name) {
		super(name, '1');
		this.name = name;
	}
	
	/**
	 * Converts a key to a string for printing
	 * @return the name of the key
	 */
	public String toString() {
		return name;
	}
}
