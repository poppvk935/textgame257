package items;
import java.io.Serializable;

import game.*;
public class Torch extends Item implements Serializable{
	private boolean lit;
	public Torch() {
		super("torch");
		lit = false;
	}
	public void setLit(boolean l) {
		lit = l;
	}
	public void use() {
		if(lit == true) {
			Game.print("You hold the lit torch up, lighting your surroundings.");
		} else {
			Game.print("The torch isn't lit. What are you going to do? Hit someone with it?");
		}
	}
	
	public void look() {
		if(lit == true) {
			
		}
	}
}
