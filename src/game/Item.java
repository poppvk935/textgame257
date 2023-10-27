package game;
public class Item {

	private String name;
	private String description;
	private boolean heavy; 
	private boolean used;	//better for multi purpose 
	
	public Item(String n) {
		if(n.contains(" "))
			throw new IllegalArgumentException("Name must be one word : " +n);
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
	
	public String toString() {
		return name; 
	}
	
}
