package npcs;
import game.*;
public class Puppy extends NPC{
	private int talk;
	public Puppy() {
		super("puppy", "A hideous puppy wags its tail at you.");
		talk = 1;
	}
	
	@Override 
	public void talk() {
		if(talk == 1) {
			say("Hi! I'm an adorable puppy!");
			String[] options = {
					"Yes you are! Who's a good boy?",
					"Ew, no. You're actually kinda hideous."
			};
			getResponse(options);
			talk++;
		} else if(talk == 2) {
			say("Hey! Wanna play fetch? Say yes! Say yes!");
			String[] options = {
					"Yes! I love fetch!",
					"No. I am a horrible person and dont't like playing with puppies."
			};
			getResponse(options);
			talk++;
		} else if(getLeft() == true) {
			//cant talk to puppy
			Game.print("The puppy ran away.");
			
		} else {
			say("Yip");
			Game.print("The puppy wags his tail at you.");
		}
	}
	
	@Override
	public void response(int option) {
		if(talk == 1) {
			switch(option) {
			case 1:
				say("I am! I'm a good boy!");
				break;
			case 2:
				say("I am adorable! Why are you so mean?");
				Game.print("The puppy bites you. You deserve it.");
				break;
			default:
				Game.print("You say nothing.");
				talk --;
		}
	} else if(talk == 2) {
		switch(option) {
		case 1:
			say("Yay! Fetch!");
			Game.print("The puppy runs off and returns with a ball.");
			Item ball = new Item("ball");
			ball.setDesc("A yellow ball the hideous puppy gave you. You should play fetch with him.");
			Game.addItem(ball);
			break;
		case 2:
			say("You're a bad person! I don't like you!");
			Game.print("The puppy runs away");
			setLeft(true);
			World.rooms.get("openCor").setRoomID("openCor_B");
			break;
		default:
			Game.print("You say nothing.");
			talk--;
		}
	}
}
}
