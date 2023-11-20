package items;
import game.*;



public class Shower extends Item {
	public Shower() {
		super("shower");
	}
	public void use() {
		if(Game.getCurrentRoom().getName().equals("muckyBath")) {
			if(Game.hasItem("goo")) {
				Game.print("You turn on the shower and wash away the goo.");
				Game.removeItem("goo");
			} else {
			System.out.println("Why would you shower right now? You'll get nothing out of walking around all wet.");
				
			}
		}
	}
	
	public void look() {
		if(Game.inventory.contains("flint")) {
			Game.print("You already have the flint...");
			
		} else {
			System.out.println("The rusty old shower something...");
		}
			
	}
}
