package items;
import game.*;

public class Key extends Item {
	public Key() {
		super("Key");
	}
	
	public void use() {
			if(Game.getCurrentRoom().getName().equals("hall")) {
				if(isUsed())
					System.out.println("Chest is already open.");
				else {
					System.out.println("The key fits in the chest! You open the chest and find a diamond.");
					Item diamond = new Item("diamond");
					diamond.setDesc("Sparkly");
					Game.getCurrentRoom().addItem(diamond);
					setUsed(true);
				}
			} else 
				System.out.println("They key doesn't fit any lock in this room.");
		}
	}
