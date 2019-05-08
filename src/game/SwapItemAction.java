package game;

import edu.monash.fit2099.engine.*;

public class SwapItemAction extends GiveAction {
	
	private Item secondItem;

	public SwapItemAction(Actor giver, Actor taker, Item exchangeItem, Item secondItem) {
		super(giver, taker, exchangeItem);
		this.secondItem = secondItem;
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		String output = "";
		output += super.execute(actor, map) + "\n";
		Action secondGive = new GiveAction(taker, giver, secondItem);
		output += secondGive.execute(actor, map);
		return output;
	}
}
