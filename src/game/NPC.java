package game;

import java.io.Serializable;

public class NPC implements Serializable{
	private String name;
	private String desc;
	private boolean left;
	private int talk;
	private static boolean isTalking;
	
	public NPC(String n, String d) {
		name = n;
		desc = d;
		talk = 1;
		isTalking = false;
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
		Game.print2(desc);
	}

	public void say(String dialog) {
		Game.print2(name+": " + dialog);
	}
	
	public void talk() { //npc talking to player
		Game.print2("You can't talk to "+name);
		setTalking(true);
	}
	
	public static boolean isTalking() {
			return isTalking;
	}
	
	public void setTalking(boolean b) {
		isTalking = b;
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
			Game.print2("Option "+(i+1)+ ": "+options[i]);
		}
		Game.print2("Enter an option (1-"+options.length+"): ");
		setTalking(false);


	}
		
}
