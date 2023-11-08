package game;
import items.*;
import java.util.HashMap;

public class World {
	public static HashMap<String, Room> rooms = new HashMap<String, Room>();
	public static Room buildWorld() {
		Room startCell = new Room("startCell");
		Room hall1 = new Room("hall1");
		Room stairWell = new Room("stairwell");
		Room doorHall = new Room("doorHall");
		Room ajarCell = new Room("ajarCell");
		Room openCor = new Room("openCor");
		Room muckyBath = new Room("muckyBath");
		
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
