package items;
import game.*;

public class Key extends Item {
	public Key() {
		super("frail key");
	}
	
	@Override //tells java to check the override
	public void use() {
			if(Game.getCurrentRoom().getName().equals("lockedRoom")|| Game.getCurrentRoom().getName().equals("openCor")) {
				if(isUsed())
					Game.print("This room is already open.");
				else {
					Game.print("The key fits in the the lock.");
					World.rooms.get("lockedRoom").setLocked(false);
					World.rooms.get("lockedRoom").setRoomID("lockedRoom_B");
					setUsed(true);
				}
			} else 
				Game.print("They key doesn't fit any lock in this room.");
		}
/*	@Override 
	public void take() {
		super.take();
		Game.getCurrentRoom().setRoomID(getName());
		}
	
*/
	
	
}