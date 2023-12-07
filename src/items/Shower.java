package items;
import game.*;



public class Shower extends Item {
	public Shower() {
		super("shower");
	}
	public void use() {
		if(Game.getCurrentRoom().getName().equals("muckyBath")) {
			if(Game.hasItem("goo")) {
				Game.print2("You turn on the shower and wash away the goo.");
				Game.removeItem("goo");
			} else {
			Game.print2("Why would you shower right now? You'll get nothing out of walking around all wet.");
				
			}
		}
	}
	
	public void look() {
		if(Game.inventory.contains("flint")) {
			Game.print2("You already have the flint...");
			
		} else {
			Game.print2("The rusty old shower has a flint sitting on the floor. Someone seemed to have tried to light a fire in here. Too bad they didn't realize water puts it out.");
		}
			
	}
}
