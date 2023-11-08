package items;
import game.*;
public class Chain extends Item {
	public Chain() {
		super("Chain");
	}
	public void use() {
		if(Game.getCurrentRoom().getName().equals("startCell")) {
			if(isUsed()) {
				System.out.println("The chain's already been pulled. There's nothing in the trapdoor aside from smelly purple residue.");
			} else {
				System.out.println("You pull the chain and are instantly doused in a weird purple goo. There's nothing else in the trapdoor.");
				Item goo = new Item("Goo");
				goo.setDesc("You are covered in goo");
				Game.getCurrentRoom().addItem(goo);
			}
		}
	}
}
