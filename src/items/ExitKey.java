package items;

import game.*;

public class ExitKey extends Item {
	public ExitKey() {
		super("old key");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("stairwell")) {
			Game.print2("You use the key on the door. It unlocks with a click and pushing the door open, you take in your sweet escape.");
			setUsed(true);
			Game.endGame();
			
		} else {
			Game.print2("There is nowhere here to use this.");
		}
	}

}

