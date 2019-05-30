package game;

import edu.monash.fit2099.engine.DropItemAction;
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
	 * Should only ever be created via Door class, otherwise the key will unlock nothing
	 * @param name the name of the key (e.g. rusty key, back door key etc...)
	 */
	public Key(String name) {
		super(name, '1');
		this.name = name;
	}
	
	/*
	 * Changes this key's allowable actions so that it can be placed into an Actor's inventory
	 * Should only be called by the Door associated with the key
	 */
	public void forInventory()
	{
		this.allowableActions.clear();
		this.allowableActions.add(new DropItemAction(this));
	}
	
	/**
	 * Converts a key to a string for printing
	 * @return the name of the key
	 */
	public String toString() {
		return name;
	}
}
