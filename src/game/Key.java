package game;

import edu.monash.fit2099.engine.Item;

public class Key extends Item {
	
	private String name;
	
	public Key(String name) {
		super(name, '1');
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
