package game;

import edu.monash.fit2099.engine.*;

/**
 * An action that represents one actor giving another actor an item.
 * This action is designed to work between any two actors, one of them does not
 * need to be the player.
 * 
 * NOTE: This is a one-way transaction. For an item swap see the subclass of SwapItemAction
 */

public class GiveAction extends Action{
	
	public Actor giver;
	public Actor taker;
	public Item exchangeItem;
	
	
	/**
	 * A constructor which takes the giver and taker Actors in the transaction and the item which is to be given
	 * @param giver the Actor which gives the item specified in exchangeItem to the taker
	 * @param taker the Actor which takes the item specified in exchangeItem from the giver
	 * @param exchangeItem the Item to be exchanged
	 */
	public GiveAction(Actor giver, Actor taker, Item exchangeItem) {
		this.giver = giver;
		this.taker = taker;
		this.exchangeItem = exchangeItem;
	}

	/**
	 * When executed, this action makes the giver, 'give' the specified item in the constructor
	 * to the 'taker'. The item's actions are reset and replaced with a single DropItemAction
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		giver.removeItemFromInventory(exchangeItem);
		taker.addItemToInventory(exchangeItem);
		exchangeItem.getAllowableActions().clear();
		exchangeItem.getAllowableActions().add(new DropItemAction(exchangeItem));
		return menuDescription(giver);
	}

	/**
	 * Returns a description of the give/take action suitable for the game menu
	 * @param actor the Actor performing the action
	 */
	@Override
	public String menuDescription(Actor actor) {
		return giver.toString() + " gives " + exchangeItem.toString() + " to " + taker.toString();
	}

	/**
	 * Returns the hotkey used for a give action
	 * @return the hotkey for the give action
	 */
	@Override
	public String hotKey() {
		return "g";
	}

}
