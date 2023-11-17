package items;

import game.*;

public class ExitKey extends Item {
	public ExitKey() {
		super("ExitKey");
	}
	
	public void use() {
		if(Game.getCurrentRoom().equals("stairwell")) {
			Game.print("You use the key on the door. It unlocks with a click and pushing the door open, you take in your sweet escape.");
			setUsed(true);
			Game.endGame();
			
		} else {
			Game.print("There is nowhere here to use this.");
		}
	}

}

