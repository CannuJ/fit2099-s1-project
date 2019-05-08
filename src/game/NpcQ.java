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

	public NpcQ(String name, Actor player) {
		super(name, 'Q', 10, 100);
		this.player = player;
		
		Item rocketPlans = new Item("Rocket Body", 'B');
		this.addItemToInventory(rocketPlans);

	}
	
	private static boolean actorHasPlans(Actor actor) {
		for (Item item : actor.getInventory()) {
			if (item.toString().equals("Rocket Plans")) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		for (Action action : actions) {
			if (!(action instanceof MoveActorAction || action instanceof SkipTurnAction)) {
				actions.remove(action);
			}
		}
		return super.playTurn(actions,  map,  display);
	}
	
	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		Actions actions = new Actions();
		if (!inventory.isEmpty() && actorHasPlans(otherActor)) {
			actions.add(new GiveAction(this, otherActor, inventory.get(0)));
		}
		actions.add(new TalkToAction(this));
		return actions;
	}

	@Override
	public String talk() {
		return (actorHasPlans(player)) ? speechWithPlans : speechNoPlans;
	}
}

