package items;

import game.*;
public class Torch extends Item{
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
			Game.print2("You hold the lit torch up, lighting your surroundings.");
		} else {
			Game.print2("The torch isn't lit. What are you going to do? Hit someone with it?");
		}
	}
	
	public void look() {
		if(lit == true) {
			Game.print2("The lit torch burns bright, allowing you to see far ahead. Wouldn't hold it too close to your head though.");
		}else {
			Game.print2(getDesc());
		}
	}
	
	public void take() {
		super.take();
		World.rooms.get("ajarCell").setRoomID("ajarCell_B");
		
	}

}

