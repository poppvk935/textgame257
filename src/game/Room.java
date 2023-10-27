package game;
import java.util.HashMap;

public class Room {

	//Object Variables
	private boolean locked; 
	private String name;
	private String desc; 
	
	private Room east; 
	private Room west;
	private Room north; 
	private Room south;
	private Room up;
	private Room down; 
	
	private HashMap<String, Item> roomItems; 
	
	//Constructor Method
	public Room(String s, String n) {
		name = n;
		desc = s;
		locked = false;
		roomItems = new HashMap<String, Item>();
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isLocked() {
		return locked;
	}
	
	public void setLocked(boolean b) {
		locked = b;
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
	
	public String getDesc() {
		return desc;
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
		return desc;
	}
	
}
