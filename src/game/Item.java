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
		System.out.println(description);
	}
	
	public void use() {
		System.out.println("You can't use the " + name + ", yet...");
	}
	
	public void take() {
		if (heavy) {
			System.out.println("That's too heavy to carry around!");
		} else {
		Game.inventory.add(Game.getCurrentRoom().removeItem(name));
		System.out.println("You take the "+name+"!");
		}
	}
	
	public String toString() {
		return name; 
	}
	
}
