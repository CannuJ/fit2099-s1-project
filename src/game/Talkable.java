package game;

/**
 * An interface which describes an object which can be "talked to" via the TalkToAction
 * Objects which implement this interface have a talk() method
 */

public interface Talkable {

	/**
	 * A method which returns a String containing their response to the player when talked to
	 * @return a String being the Actor's dialogue to the player when talked to
	 */
	
	String talk();
	
}
