package items;
import game.*;

public class Wand extends Item{
	
	public Wand() {
		super("wand");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("lobby")) {
			Room bar = World.rooms.get("Bar");
			Game.setCurrentRoom(bar);
			Game.print2(bar.getDesc());
			
		}
			Game.print2("You wave the wand around");
	}
}
