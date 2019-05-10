package game;

import edu.monash.fit2099.engine.*;

public class NpcQ extends Actor implements Talkable{
	
	/*
	 * The Actor class that implements the in-game NPC named Q.
	 * Q is an integral part of the story as he gives the player the rocketBody item
	 * used to complete the game.
	 * 
	 * The only action Q has is to talk with the player and to drop the rocket body
	 */
	
	private static final String speechNoPlans = "I can give you something that will help, but I’m going to need the plans.";
	private static final String speechWithPlans = "Hand them over, I don’t have all day!";
	private static final int maxTalkingDistance = 1;
	
	private Actor player;
	
	/**
	 * The constructor for Q.
	 * Describes a basic Actor (labeled 'Q') which stores the Actor object of the player.
	 * Also adds the Rocket Plans to Q's inventory, in order to eventually give it to the player
	 * @param player the current player instance of Actor
	 */
	public NpcQ(Actor player) {
		super("Q", 'Q', 10, 100);
		this.player = player;
		Item rocketPlans = new Item("Rocket Body", 'B');
		this.addItemToInventory(rocketPlans);

	}
	
	/**
	 * A method which returns whether or not a given Actor has an item labeled "Rocket Plans" in their inventory.
	 * This functionality is used to determine whether or not the player has the Rocket Plans in order to
	 * given them the Rocket Body to progress the story
	 * @param actor the Actor whose inventory will be searched for the Rocket Plans
	 * @return true if the Actor has the Rocket Plans in their inventory false otherwise
	 */
	private static boolean actorHasPlans(Actor actor) {
		for (Item item : actor.getInventory()) {
			if (item.toString().equals("Rocket Plans")) {
				return true;
			}
		}
		return false;
	}
	

	/**
	 * Executes whenever Q takes their turn.
	 * In normal circumstances, Q simply roams around the map without attacking any other Actors
	 * After the Player has taken the Rocket Body off of Q, Q will 'disappear' from the map.
	 * 
	 * @param actions collection of possible Actions for this Actor
	 * @param map     the map containing the Actor
	 * @param display the I/O object to which messages may be written
	 * @return the Action to be performed
	 * 
	 */
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		if (actorHasPlans(this)) {  // Checks if Q now holds the Rocket Plans (meaning the player has traded them for the body)
			actions.clear();
			actions.add(new SuicideAction(this));
		} else {
			for (Action action : actions) {
				if (!(action instanceof MoveActorAction || action instanceof SkipTurnAction)) {
					actions.remove(action);
				}
			}
		}
		return super.playTurn(actions,  map,  display);
	}
	
    /**
     * Returns a collection of the Actions containing: a TalkToAction (allowing the Player to talk to Q)
     * and a swapItemAction in the case of the Player having the Rocket Plans to swap them with the Rocket Body
     *
     * @param otherActor the Actor that might be performing attack
	 * @param direction  String representing the direction of the other Actor
	 * @param map        current GameMap
	 * @return A collection of Actions.
	 */
	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		Actions actions = new Actions();
		if (!inventory.isEmpty() && actorHasPlans(otherActor)) {
			actions.add(new SwapItemAction(this, otherActor, inventory.get(0), otherActor.getInventory().get(0)));
		}
		actions.add(new TalkToAction(this));
		return actions;
	}

	/**
	 * Returns a string containing the line of dialogue said to the player when the player talks to Q.
	 * Q hints to the player to retrieve the Rocket Plans if the player doesn't hold them in their inventory
	 * or hints to the player that they should give the plans to Q if the player does hold the plans in their inventory
	 * @return a String containing the appropriate line of dialogue to be said to the player outlined above
	 */
	@Override
	public String talk() {
		return (actorHasPlans(player)) ? speechWithPlans : speechNoPlans;
	}
}

