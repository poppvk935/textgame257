package items;
import game.*;

public class Door extends Item {
	public Door() {
		super("Door");
	}

	public void push() {
		if(Game.getCurrentRoom().equals("cell3") || Game.getCurrentRoom().equals("hall5")) {
			Game.print("You shake the rusty old door and it break off its hinges, falling to the ground with an echoing thud.");
			setDesc("The heavy door now lays on the ground.");
			World.rooms.get("cell3").setLocked(false);
		} else {
			Game.print("You shake the door but it doesn't budge. Not getting out that easy...");
		}
	}
}
