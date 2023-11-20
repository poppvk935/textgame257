package items;
import game.*;

public class Door extends Item {
	public Door() {
		super("door");
	}

	public void use() {
		if(Game.getCurrentRoom().getName().equals("hall5") ){ //|| Game.getCurrentRoom().getName().equals("cell3")) {
			Game.print("You shake the rusty old door and it break off its hinges, falling to the ground with an echoing thud.");
			setDesc("The heavy door now lays on the ground.");
			World.rooms.get("cell3").setLocked(false);
			World.rooms.get("cell3").setRoomID("cell3_B");
		}else if(Game.getCurrentRoom().equals("stairwell")) {

		} else {
			Game.print("You shake the door but it doesn't budge. Not getting out that easy...");		}
	}
}
