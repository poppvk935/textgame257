package game;
import java.io.Serializable;
import java.util.HashMap;

public class Room implements Serializable{

	//Object Variables
	private boolean locked; 
	private String name; //name, not in map
	private String roomID; //denotes description, for fetching map data
	
	private Room east; 
	private Room west;
	private Room north; 
	private Room south;
	private Room up;
	private Room down; 
	
	private int entry;
	
	private HashMap<String, Item> roomItems; 
	private HashMap<String, NPC> roomNPCs;
	
	//Constructor Method
	public Room(String s) {
		name = s;
		roomID = s;
		locked = false;
		roomItems = new HashMap<String, Item>();
		roomNPCs = new HashMap<String, NPC>();
		entry = 1;
		
		World.rooms.put(name, this); //puts room in hashmap
	}
	
	public String getName() {
		return name;
	}
	
	public void setRoomID(String id) {
		roomID = id;
	}
	
	public boolean isLocked() {
		return locked;
	}
	
	public void setLocked(boolean b) {
		locked = b;
	}
	
	public String getDesc() {
		String b = Game.roomDesc.get(roomID);
		return b;
	}
	
	public void addItem(Item i) {
		roomItems.put(i.getName(), i); //ask the item what its name is
	}
	
	public Item removeItem(String name) {
		Item it = roomItems.get(name);
		roomItems.remove(name);
		return it;
		// or return roomItems.remove(name);
	}
	
	public boolean hasItem(String name) {
		return roomItems.containsKey(name);
	}
	
	public Item getItem(String i) {
		Item it = roomItems.get(i);
		return it;
	}
	
	public boolean hasNPC(String name) {
		return roomNPCs.containsKey(name);
	}
	
	public void addNPC(NPC p) {
		roomNPCs.put(p.getName(), p);
	}
	
	public NPC getNPC(String name) {
		return roomNPCs.get(name);
	}
	
	public String getNPCName(String n) {
		NPC p = getNPC(n);
		if(p == null) {
			return "There is no npc";
		}
		return p.getName();
	}
	
	
	public int getEntry() {
		return entry;
	}
	
	public void setEntry(int i) {
		entry += i;
	}
	
	
	//returns room variable based on move input
	//returns null if invalid variable
	public Room getExit(char c) {
		if(c =='e')  {
			return east;
		}
		else if(c == 'w') {
			return west;
		}
		else if(c == 'n') {
			return north;
		}
		else if(c == 's') {
			return south;
		}
		else if(c == 'u') {
			return up;
		}
		else if(c == 'd') {
			return down;
		}
		else {
			return null;
		}
	} //end of getExit
	
	public void addExit(Room b, char c) {
		if(c == 'e') {
			east = b;
		}
		else if(c == 'w') {
			west = b;
		}
		else if(c == 'n') {
			north = b;
		}
		else if(c == 's') {
			south = b;
		}
		else if(c == 'u') {
			up = b;
		}
		else if(c == 'd') {
			down = b;
		}
	} //end of addExit
	
	public String toString() {
		return Game.roomDesc.get(roomID);
	}
}
