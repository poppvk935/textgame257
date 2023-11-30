package npcs;
import game.*;
import items.*;
public class Prisoner extends NPC	{
	public Prisoner() {
		super("prisoner", "A shadowy figure looks at you from the bars of the cell. You can barely make out any features.");	
	}
	
	/*
	 * Prisoner gives you shoes to go up staircase B
	 */
	@Override
	public void talk() {
		if(getTalk() == 1) {
			say("Hey, you! Come here.");
			Game.print("The shadowy figure sticks their hands out the bars, motioning for you to come closer.");
			String[] options = {
					"'Uh... Hello?' You move closer to the cell.", 
					"You pretend you didn't hear anything and move on."
			};
			getResponse(options);
			increaseTalk(1);
			//player talks to them
		} else if(getTalk() == 2) {
			say("What are you just staring at me for?!");
			String[] options = {
					"Second floor? There's a second floor to this maze?", 
					"How am I supposed to get up there? The way is blocked with rusty old stuff!"
			};
			getResponse(options);
			increaseTalk(1);
			//player brushes them off
		} else if(getTalk() == 3) {
			say("I knew you would come around. You have to get me out of here! They keep all they keys in the guard room on the second floor.");
			String[] options = {
					"Second floor? There's a second floor to this maze?", 
					"How am I supposed to get up there? The way is blocked with rusty old stuff!"
			};
			getResponse(options);
			increaseTalk(-1);
		}
	}
	
	public void response(int option) {
		if(getTalk() == 1) {
			switch(option) {
			case 1:
				say("You have to get me out of here! They keep all they keys in the guard room on the second floor.");
				break;
			case 2:
				say("Hey! I know you can hear me!");
				Game.print("They throw a rock at you. It hits you in the arm.");
				increaseTalk(1);
				break;
			default:
				Game.print("You say nothing.");
				increaseTalk(-1);
			}
		} else if(getTalk() == 2) {
			switch(option) {
			case 1:
			say("Yes, of course there's a second floor. Haven't you seen all the staircases?!");
			increaseTalk(1);
			break;
			case 2:
				say("Oh? Really?");
				Shoes shoes = new Shoes();
				Game.addItem(shoes);
				increaseTalk(1);
				break;
			}
		}
	}
}
