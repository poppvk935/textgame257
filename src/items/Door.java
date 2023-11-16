package items;
import game.*;

public class Door extends Item {
	public Door() {
		super("Door");
	}
	public void use() {
		if(Game.getCurrentRoom().equals("hall5")) {
			Game.print("You shake the rusty old door and it break off its hinges, falling to the ground with an echoing thud.");
			Room c = game.World.rooms.get("cell3");
			c.setLocked(false);
			setDesc("The heavy door now lays on the ground.");
			setUsed(true);
		}
	}
}