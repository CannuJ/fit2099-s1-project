package game;

import edu.monash.fit2099.engine.*;

public class DialogAction implements ActionFactory {
	
	private String dialogString;

	public DialogAction(Actor subject, String dialogString) {
		this.dialogString = dialogString;
	}
	
	@Override
	public Action getAction(Actor actor, GameMap map) {
		return new SpeechAction(dialogString);
	}

}
