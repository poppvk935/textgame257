package game;
import items.*;
import npcs.*;
import java.util.HashMap;
import java.util.HashSet;

public class World {
	public static HashMap<String, Room> rooms = new HashMap<String, Room>();
	public static HashSet<Door> doors = new HashSet<Door>();
	public static Room buildWorld() {
		//Q1
		Room startCell = new Room("startCell"); //1
		Room hall1 = new Room("hall1"); //2
		Room stairWell = new Room("stairwell"); //3
		Room tempExit = new Room("tempExit");
		
		Room openCor = new Room("openCor"); //12
		Room muckyBath = new Room("muckyBath"); //13
		Room lockedRoom = new Room("lockedRoom"); //14 
		
		//Q2
		Room doorHall = new Room("doorHall"); //4
		Room ajarCell = new Room("ajarCell"); //5
		
		Room hall3 = new Room("hall3"); //6
		Room stairC = new Room("stairC"); //7
		
		//Q3
		Room hall4 = new Room("hall4"); //8
		Room stairB = new Room("stairB"); //9
		
		Room hall5 = new Room("hall5"); //10
		Room cell3 = new Room("cell3"); //11
		
		//Q4 pending

/**********Q1**********/
		
		//startCell has one exit
		startCell.addExit(hall1, 'e');
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
		Door exitDoor = new Door();
		stairWell.addItem(exitDoor);
		doors.add(exitDoor);
		exitDoor.setDesc("The large door stands ");
		
		//openCor has two exits
		openCor.addExit(hall1, 'n');
		openCor.addExit(muckyBath, 'w');
		Item chest = new Item("chest");
		chest.setDesc("A chest..?");
		openCor.addItem(chest);
		openCor.addExit(lockedRoom, 'u');
		Puppy puppy = new Puppy();
		openCor.addNPC(puppy);
		
		//muckyBath has one exit
		muckyBath.addExit(openCor, 'e');
		Shower shower = new Shower();
		muckyBath.addItem(shower);
		shower.setHeavy(true);
		shower.setDesc("A rusty drippy faucet on the ceiling.");
		Flint flint = new Flint();
		muckyBath.addItem(flint);
		flint.setDesc("A firestarter. Now you just need something to light...");
		
		//lockedRoom has one exit
		lockedRoom.addExit(openCor, 'd');
		lockedRoom.isLocked();
		ExitKey exitKey = new ExitKey();
		lockedRoom.addItem(exitKey);
		exitKey.setDesc("The heavy key seems to hold an air of importance. Maybe this can get you out of here?");
		
		
		

		
/**********Q2**********/
		//doorHall has three (currently) exits
		doorHall.addExit(hall1, 'w');
		doorHall.addExit(ajarCell, 'n');
		doorHall.addExit(hall3, 's');
		doorHall.addExit(hall4, 'e');
		
		//ajarCell has one exit
		ajarCell.addExit(doorHall, 's');
		Torch torch = new Torch();
		ajarCell.addItem(torch);
		torch.setDesc("An unlit torch, obviously left here for quite a while.");
		
		//hall3 has two exits
		//hall3 is obstructed
		hall3.addExit(doorHall, 'n');
		hall3.addExit(stairC, 's');
		hall3.isLocked();
		
		
		

/**********Q3**********/		
		//hall4 has three (for now) exits
		hall4.addExit(doorHall, 'n');
		hall4.addExit(hall5, 'w');
		hall4.addExit(stairB, 'd');
		Prisoner prisoner = new Prisoner();
		hall4.addNPC(prisoner);
		
		//stairB has one (for now) exit
		stairB.addExit(hall4, 'u');
		stairB.setLocked(true);
		
		//hall5 has two exits 
		hall5.addExit(hall4, 'e');
		hall5.addExit(cell3, 'n');
		Door door = new Door();
		door.setDesc("Looks shakeable.");
		door.setHeavy(true);
		hall5.addItem(door);
		hall5.setLocked(true);
		doors.add(door);
		
		//cell3 has one exit
		cell3.addExit(hall5, 's');
		cell3.setLocked(true);
		Key key = new Key();
		key.setDesc("It is a frail old key. Annoyingly rusty.");
		cell3.addItem(key);

		
		return startCell;
	}
}