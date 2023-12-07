package game;

import java.io.Serializable;

public class Item implements Serializable{

	private String name;
	private String description;
	private boolean heavy; 
	private boolean used;	//better for multi purpose 
	
	public Item(String n) {
	/*	if(n.contains(" "))
			throw new IllegalArgumentException("Name must be one word : " +n);*/
		name = n;
		heavy = false;
		used = false;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDesc(String desc) {
		description = desc;
	}
	public String getDesc() {
		return description;
	}
	
	public boolean isUsed()  {
		return used;
	}
	
	public void setUsed(boolean b) {
		used = b;
	}
	
	public boolean isHeavy() {
		return heavy;
	}
	
	public void setHeavy(boolean i) {
		heavy = i;
	}
	
	public void look() {
		Game.print2(description);
	}
	
	public void use() {
		Game.print2("You can't use the " + name + ", yet...");
	}
	
	public void take() {
		if (heavy) {
			Game.print2("That's too heavy to carry around!");
		} else {
		Game.inventory.add(Game.getCurrentRoom().removeItem(name));
		Game.print2("You take the "+name+"!");
		}
	}
	
	public String toString() {
		return name; 
	}
	
}
