package game;
import items.*;
public class World {
	public static Room buildWorld() {
		Room startCell = new Room("startCell", "You are in the cell where you woke up.");
		Room hall1 = new Room("hall1","You are in a hallway.");
		Room stairWell = new Room("stairwell", "You are in the old stairwell.");
		Room doorHall = new Room("doorHall","you are in the hallway with a locked door.");
		Room ajarCell = new Room("ajarCell", "You are in the unlocked cell.");
		Room openCor = new Room("openCor", "You are in the open corridor.");
		Room muckyBath = new Room("muckyBath", "You are in a mucky old bathroom, overtaken by mold.");
		
		//startCell has one exit
		startCell.addExit(hall1, 'e');
		Key key = new Key();
		key.setDesc("It is a frail old key. Annoyingly rusty.");
		Chain chain = new Chain();
		startCell.addItem(chain);
		chain.setDesc("Rusty chain hanging from the ceiling. Looks like it opens a trapdoor. An escape?");
		
		
		//hall1 has four exits
		hall1.addExit(stairWell, 'u');
		hall1.addExit(openCor, 's');
		hall1.addExit(doorHall, 'e');
		hall1.addExit(startCell, 'w');
		
		//stairWell has one (currently) exit
		stairWell.addExit(hall1, 'd');
		Wand wand = new Wand();
		stairWell.addItem(wand);
		wand.setDesc("An interestingly uniform stick.");
		
		//doorHall has two (currently) exits
		doorHall.addExit(hall1, 'w');
		doorHall.addExit(ajarCell, 'n');
		
		//ajarCell has one exit
		ajarCell.addExit(doorHall, 's');
		Item torch = new Item("torch");
		ajarCell.addItem(torch);
		torch.setDesc("An unlit torch, obviously left here for quite a while.");
		
		//openCor has two exits
		openCor.addExit(hall1, 'n');
		openCor.addExit(muckyBath, 'w');
		Item chest = new Item("chest");
		chest.setDesc("A chest..?");
		openCor.addItem(chest);
		
		//muckyBath has one exit
		muckyBath.addExit(openCor, 'e');
		Shower shower = new Shower();
		muckyBath.addItem(shower);
		shower.setDesc("A rusty drippy faucet on the ceiling.");
		
		
		
		return startCell;
	}
}
