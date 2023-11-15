package items;
import game.*;



public class Shower extends Item {
	public Shower() {
		super("Shower");
	}
	public void use() {
		if(Game.getCurrentRoom().getName().equals("muckyBath")) {
			System.out.println("");
				
			}
		}
	
	public void look() {
		if(Game.inventory.contains("flint")) {
			
		} else {
			System.out.println("The rusty old shower something...");
		}
			
	}
}
