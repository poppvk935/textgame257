package items;
import game.*;
public class Chain extends Item {
	public Chain() {
		super("chain");
	}
	public void use() {
		if(Game.getCurrentRoom().getName().equals("startCell")) {
			if(isUsed()) {
				Game.print("The chain's already been pulled. There's nothing in the trapdoor aside from smelly purple residue.");
			} else {
				Game.print("You pull the chain and are instantly doused in a weird purple goo. There's nothing else in the trapdoor.");
				Item goo = new Item("goo");
				goo.setDesc("You are covered in goo");
				Game.addItem(goo);
				setUsed(true);
				World.rooms.get("startCell").setRoomID("startCell_B");
				
			}
		}
	}
}
