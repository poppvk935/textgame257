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
import items.*;


public class Game {
	private static Room currentRoom;
	//array list of Items that the player has picked up and can use
	public static ArrayList<Item> inventory = new ArrayList<Item>();
	//HashMap containing roomID and descriptions 
	public static HashMap<String, String> roomDesc = new HashMap<String, String>(); 
						//<RoomID, Description>
	//HashSet containing conditions the player can get from the world
	public static HashSet<String> flags = new HashSet<String>();
	public static Scanner scan = new Scanner(System.in);
	
	/**
	 * returns current room
	 * static method
	 * @return
	 */
	public static Room getCurrentRoom() {
		return currentRoom;
	}
	
	/**
	 * allows for the manual change of room
	 * @param r
	 */
	public static void setCurrentRoom(Room r) {
		currentRoom = r;
	}
	
	/**
	 * saves game at current point
	 * saves currentRoom, inventory, and World.rooms to a save file
	 */
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
	/**
	 * Loads last save file
	 * static method
	 */
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
	
	/**
	 * Populates a map based on the given file
	 * breaks map items as 
	 * keys - item directly after '#'
	 * values - anything between key and next '#'
	 * static method
	 * @param fileName
	 */
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
	
	public static void endGame() {
		System.exit(0);
	}
	
	/**
	 * moves player between rooms
	 * checks that there is a room in the input direction
	 * checks if the room is locked 
	 * @param direction
	 */
	public static void move(char direction) { //make methods for often used commands
		Room nextRoom = currentRoom.getExit(direction);
		if(nextRoom != null) {
			if(nextRoom.isLocked()) {
				Game.print(nextRoom.getDesc());
				Game.print("You can't go that way...yet.");
			} else {
				currentRoom = currentRoom.getExit(direction);
				System.out.println(currentRoom);
			}
		} else {
			System.out.println("You can't go that way.");
		}
	}
	/**
	 * gets item from inventory list 
	 * static method
	 * @param name
	 * @return
	 */
	public static Item getItem(String name) {
		for(Item i : inventory)
			if(i.getName().equals(name))
				return i;
		return null;
	}
	/**
	 * adds item to inventory
	 * static method
	 * @param name
	 */
	public static void addItem(Item name) {
		inventory.add(name);
	}
	
	public static boolean hasItem(String name) {
		return getItem(name) != null;
	}
	
	public static void removeItem(String name) {
		inventory.remove(getItem(name));
	}
	
	public static String getCondition(String cond) {
		for(String s : flags)
			if(s.equals(cond))
				return s;
		return null;
	}
	
	public static void addCondition(String cond) {
		flags.add(cond);
	}
	
	public static void removeCondition(String cond) {
		flags.remove(getCondition(cond));
	}
	
	public static void print(String message) {
		System.out.println(message+"\n");
	}
	
/***********************************************************/	
	public static void main(String[] args) {
		String playercommand = "a";
		Item i;
		NPC n;
		Game.populateMap("Room Descriptions");
		currentRoom = World.buildWorld(); 
		Game.print("You wake up on the cold jagged rock floor of a dungeon cell. With no idea how you got here or why and a terrible feeling in your gut, your only understanding is to escape.");
		System.out.println(currentRoom);
		
		/***
		 * Reads input playercommand 
		 * uses a switch statement to determine
		 * what player will do next
		 */
		while(!playercommand.equals("x")) {
			System.out.print("What do you want to do?");
			playercommand = scan.nextLine();
			String[] a = playercommand.split(" ");
			playercommand = a[0];
			flags.add("first");
			
			switch (playercommand) {
			case "e" :
			case "w" :
			case "n" :
			case "s" :
			case "u" :
			case "d" :
				move(playercommand.charAt(0));
				break; 
				
				//Inventory
			case "i" :
				if(inventory.isEmpty()) {
				System.out.println("You are holding nothing!");
				} else {
					for (Item it : inventory) {
						System.out.println(it);
					}
				}
				break;
				
				//Exit game
			case "x" :
				System.out.println("Okay. Bye!");
				break;
				
				//Take item
			case "take":
				String it = a[1];
				if(currentRoom.hasItem(it)) {
					Item item = currentRoom.getItem(it);
					item.take();
				} else {
					System.out.println("There is no "+it+"!");
				}
				break; 
				
				//Get item or NPC description
			case "look":
				if((currentRoom.hasItem(a[1]) )) {
					i = currentRoom.getItem(a[1]);
					i.look();
				} else if(currentRoom.hasNPC(a[1])) {
					n = currentRoom.getNPC(a[1]);
					n.look();
				}
				for(int z=0;z<inventory.size();z++) {
					if(inventory.get(z).getName().equals(a[1])) {
						inventory.get(z).look();
					}
				}
				
				break;
				
				//Use item in inventory
			case "use":
					i = getItem(a[1]);
					if(i == null)
						System.out.println("You don't have the " + a[1]);
					else
						i.use();
				
				break;
				
			case "push":
					Door d = World.doors.
				break;
				
			//Have dialog with NPC	
			case "talk":
				NPC npc = currentRoom.getNPC(a[1]);
				npc.talk();
				break;
				
				//save game
			case "save":
				saveGame();
				break;
				
				//load game
			case "load":
				loadGame();
				break;
				
			default:
				System.out.println("Invalid Command, reenter.");
			}
				
		} scan.close();
	} 
}

