package game;

import edu.monash.fit2099.engine.*;

public class GiveAction extends Action{
	
	public Actor giver;
	public Actor taker;
	public Item exchangeItem;
	
	public GiveAction(Actor giver, Actor taker, Item exchangeItem) {
		this.giver = giver;
		this.taker = taker;
		this.exchangeItem = exchangeItem;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		giver.removeItemFromInventory(exchangeItem);
		taker.addItemToInventory(exchangeItem);
		exchangeItem.getAllowableActions().clear();
		exchangeItem.getAllowableActions().add(new DropItemAction(exchangeItem));
		return menuDescription(giver);
	}

	@Override
	public String menuDescription(Actor actor) {
		return giver.toString() + " gives " + exchangeItem.toString() + " to " + taker.toString();
	}

	@Override
	public String hotKey() {
		return "g";
	}

}
