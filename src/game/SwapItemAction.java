package game;

import edu.monash.fit2099.engine.*;

public class SwapItemAction extends GiveAction {
	
	/**
	 * This Action represents the action of swapping two items between two Actors
	 * It is essentially a subclass of GiveAction which calls GiveAction twice but with an extra item
	 */
	
	private Item secondItem;

	/**
	 * The constructor for the SwapItemAction
	 * It adds an extra item to be swapped back after the initial GiveAction
	 * @param giver the actor which is giving the first item to the taker
	 * @param taker the actor which is giving the second item to the giver
	 * @param firstItem the item to be exchanged from the giver to the taker
	 * @param secondItem the item to be exchanged from the taker to the giver
	 */
	public SwapItemAction(Actor giver, Actor taker, Item firstItem, Item secondItem) {
		super(giver, taker, firstItem);
		this.secondItem = secondItem;
	}
	
	/**
	 * The execution of the SwapItemAction
	 * Exchanges the two items provided in the constructor between the two actors also specified in the constructor
	 * Functions by executing two separate GiveActions (this action's parent), returning output of both concatenated together between a new line
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		String output = "";
		output += super.execute(actor, map) + "\n";
		Action secondGive = new GiveAction(taker, giver, secondItem);
		output += secondGive.execute(actor, map);
		return output;
	}
}
