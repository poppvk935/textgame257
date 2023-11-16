package game;

import java.io.Serializable;

public class NPC implements Serializable{
	private String name;
	private String desc;
	private boolean left;
	private int talk;
	
	public NPC(String n, String d) {
		name = n;
		desc = d;
		talk = 1;
		
	}
	
	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}
	
	public int getTalk() {
		return talk;
	}
	
	public void increaseTalk(int i) {
		talk+=i;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public void look() {
		Game.print(desc);
	}

	public void say(String dialog) {
		Game.print(name+": " + dialog);
	}
	
	public void talk() { //npc talking to player
		Game.print("You can't talk to "+name);
	}
	
	public void response(int option) {
		
	}
	
	public void give(String i) {
		
	}
	
	public void setLeft(boolean b) {
		left = b;
	}
	
	public boolean getLeft() {
		return left;
	}
	
	/**
	 * Displays options to player
	 * Prompts player to select an option
	 * Read player choice
	 * Call associated response with player's choice as parameter
	 * 
	 * @param options
	 */
	public void getResponse(String[] options) {
		for (int i =0; i<options.length; i++) {
			Game.print("Option "+(i+1)+ ": "+options[i]);
		}
		Game.print("Enter an option (1-"+options.length+"): ");
		int choice = Game.scan.nextInt();
		Game.scan.nextLine(); //flush input buffer
		response(choice);
		
	}
}
