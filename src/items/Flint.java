package items;
import game.*;
public class Flint extends Item {
	public Flint() {
		super("Flint");
	}
	
	public void use() {
		if(game.Game.inventory.contains("torch")) {
			for(int i=0;i<game.Game.inventory.size();i++) {
			Item t = game.Game.inventory.get(i);
			if(t.getName().equals("torch")) {
				
			}
		}
	}
}
