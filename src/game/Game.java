package game;
import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Game {
	private static Room currentRoom;
	public static ArrayList<Item> inventory = new ArrayList<Item>();
	public static HashMap<String, String> roomDesc = new HashMap<String, String>(); 
						//<RoomID, Description>
	public static Scanner scan = new Scanner(System.in);
	
	public static Room getCurrentRoom() {
		return currentRoom;
	}
	
	public static void setCurrentRoom(Room r) {
		currentRoom = r;
	}
	
	public static void saveGame() {
		File saveFile = new File("save");
		try {
		saveFile.createNewFile();
		ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(saveFile));
		stream.writeObject(currentRoom);
		stream.writeObject(inventory);
		stream.writeObject(World.rooms);
		stream.close();
		Game.print("Game Saved.");
		} catch (FileNotFoundException ex) {
			Game.print("Error accessing save file.");
		} catch (IOException e) {
			Game.print("Error creating save file.");
			e.printStackTrace();
		}
	}
	
	public static void loadGame() {
		try {
		ObjectInputStream stream = new ObjectInputStream(new FileInputStream(new File("save")));
		currentRoom = (Room) stream.readObject();
		inventory = (ArrayList) stream.readObject();
		World.rooms = (HashMap) stream.readObject();
		stream.close();
		} catch (FileNotFoundException e) {
			Game.print("Error accessing load file.");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			Game.print("Error finding item class.");
		} catch (IOException e) {
			Game.print("Error reading load file.");
		}
	}
	
	public static void populateMap(String fileName)  {
		try {
			Scanner scan = new Scanner(new File(fileName));
			while(scan.hasNextLine()) {
				String line = scan.nextLine();
					if(!line.equals("#")) {
						String id = line;
						String desc = " ";
						String d = scan.nextLine();
						while(!d.equals("#")) {
							desc+=d;
							d = scan.nextLine();
						} //End of while
						roomDesc.put(id, desc);
					} else {
						scan.nextLine();
					} // end of if else
			
			}	//end of while loop
		} catch(FileNotFoundException ex ) {
			System.out.println("File "+fileName+" not found.");
		}
	}
	
	public static void move(char direction) { //make methods for often used commands
		if(currentRoom.getExit(direction) != null) {
			if(currentRoom.getExit(direction).isLocked()) {
				System.out.println("The room is locked!");
			} else {
				currentRoom = currentRoom.getExit(direction);
				System.out.println(currentRoom);
			}
		} else {
			System.out.println("You can't go that way.");
		}
	}
	
	public static Item getItem(String name) {
		for(Item i : inventory)
			if(i.getName().equals(name))
				return i;
		return null;
	}
	
	public static void print(String message) {
		System.out.println(message+"\n");
	}
	
	public static void main(String[] args) {
	
	//TODO Auto-generated method stub

		String playercommand = "a";
		Item i;
		Game.populateMap("Room Descriptions");
		currentRoom = World.buildWorld(); //call a static method by [Class].[Method()] instead of [Object].[Method()]
		System.out.println(currentRoom);
	//	do { do loop doesn't need to have the original variable defined before
			// and runs at least once
		

		
		
		while(!playercommand.equals("x")) {
			System.out.print("What do you want to do?");
			playercommand = scan.nextLine();
			String[] a = playercommand.split(" ");
			playercommand = a[0];
			
			switch (playercommand) {
			case "e" :
			case "w" :
			case "n" :
			case "s" :
			case "u" :
			case "d" :
				if(currentRoom.getExit(playercommand.charAt(0)) != null){
					currentRoom = currentRoom.getExit(playercommand.charAt(0));
					System.out.println(currentRoom);
					
				} else {
					System.out.println("You can't go that way!");
				}
				break; 
				
				
			case "i" :
				if(inventory.isEmpty()) {
				System.out.println("You are holding nothing!");
				} else {
					for (Item it : inventory) {
						System.out.println(it);
					}
				}
				break;
				
				
			case "x" :
				System.out.println("Okay. Bye!");
				break;
				
				
			case "take":
				String it = a[1];
				if(currentRoom.hasItem(it)) {
					Item item = currentRoom.getItem(it);
					item.take();
				} else {
					System.out.println("There is no "+it+"!");
				}
				break; 
				
				
			case "look":
				if((currentRoom.hasItem(a[1]))) {
					i = currentRoom.getItem(a[1]);
					i.look();
				}
				for(int z=0;z<inventory.size();z++) {
					if(inventory.get(z).getName().equals(a[1])) {
						inventory.get(z).look();
					}
				}
				
				break;
				
				
			case "use":
					i = getItem(a[1]);
					if(i == null)
						System.out.println("You don't have the " + a[1]);
					else
						i.use();
				
				break;
				
			case "talk":
				NPC npc = currentRoom.getNPC(a[1]);
				npc.talk();
				break;
				
			case "save":
				saveGame();
				break;
				
			case "load":
				loadGame();
				break;
				
			default:
				System.out.println("Invalid Command, reenter.");
			}
				
		} scan.close();
	} 
}

