package items;
import game.*;

public class Key extends Item {
	public Key() {
		super("Key");
	}
	
	@Override //tells java to check the override
	public void use() {
			if(Game.getCurrentRoom().getName().equals("hall")) {
				if(isUsed())
					System.out.println("This room is already open.");
				else {
					System.out.println("The key fits in the the lock.");
					World.rooms.get("lockedRoom").setLocked(false);
					World.rooms.get("lockedRoom").setRoomID("lockedRoom_B");
					setUsed(true);
				}
			} else 
				System.out.println("They key doesn't fit any lock in this room.");
		}
/*	@Override 
	public void take() {
		super.take();
		Game.getCurrentRoom().setRoomID(getName());
		}
	
*/
	
	
}