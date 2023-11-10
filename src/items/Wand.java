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
			Game.print(bar.getDesc());
			
		}
			System.out.println("You wave the wand around");
	}
}
