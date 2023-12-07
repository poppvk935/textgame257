package items;
import game.*;
public class Flint extends Item {
	public Flint() {
		super("flint");
	}
	
	public void use() {
		if(Game.hasItem("torch")) {
			Torch t = (Torch) game.Game.getItem("torch");
			t.setLit(true);
			Game.print2("You use the firestarter to light the torch.");
			World.rooms.get("hall5").setLocked(false);
			World.rooms.get("hall5").setRoomID("hall5_B");
			setUsed(true);
		} else {
			Game.print2("What are you going to use it on? The air?");
		}
}
	public void take() {
		super.take();
		World.rooms.get("muckyBath").setRoomID("muckyBath_B");
	}
}