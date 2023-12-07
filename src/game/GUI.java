package game;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

import java.awt.*;
import java.awt.event.*;
public class GUI extends JFrame implements KeyListener {
	private JTextArea text = new JTextArea();
	private JTextArea text2 = new JTextArea();
	private JLabel roomName = new JLabel();
	public JTextField uin = new JTextField();
	//private String playercommand = "a";

	
	public GUI() {
		setTitle("Text Game");
		setSize(600,550);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
	
		
		
		roomName.setText(Game.getCurrentRoom().getName());
		add(roomName,BorderLayout.NORTH);
		
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(2,1));
		text.setFont(new Font(null, Font.PLAIN, 16));
		text.setRows(20);
		text.setColumns(40);

		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		
		text2.setFont(new Font(null, Font.PLAIN, 16));
		text2.setRows(20);
		text2.setColumns(40);

		text2.setLineWrap(true);
		text2.setWrapStyleWord(true);
		text2.setEditable(false);

		
		DefaultCaret caret = (DefaultCaret) text.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		
		JScrollPane scroll = new JScrollPane(text);
		pane.add(scroll);
		pane.add(text2);
		add(pane,BorderLayout.CENTER);
		text.setEditable(false);
		
		JPanel ui = new JPanel(new GridLayout(2,1));

		JLabel prompt = new JLabel("What do you want to do?\n");

		uin.setFont(new Font(null, Font.PLAIN, 16));
		uin.setColumns(40);
		uin.addKeyListener(this);
	
		
		ui.add(prompt);
		ui.add(uin);
		add(ui, BorderLayout.SOUTH);
		
		

		
		setVisible(true);
	}
	

	public String getUserText() {
		String t = uin.getText();
		return t;
	}
	
	public void print(String s) {
		text.append(s+"\n\n");
	}
	
	public void print2(String s) {
		text2.append(s+"\n\n");
	}
	
	
/*
public String getPlayerCommand() {
	return playercommand;
}
*/
//KeyListener events

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
			if(e.getKeyChar() == '\n') {
				//playercommand = uin.getText();
				text2.setText("");
				String playercommand = uin.getText();

				
				
				
				String g = Game.getCommand();
				if((Game.getCurrentRoom().getNPCName(Game.getCommand())).equals(g)) {
				NPC npc = Game.getCurrentRoom().getNPC(Game.getCommand());
				try {
				int option = Integer.parseInt(uin.getText());
				npc.response(option);
				} catch(NumberFormatException ex) {
					print2("This is an error");
					ex.printStackTrace();
				}
				} else {
					Game.processCommand(playercommand);
				}
				uin.setText("");
			}
	}





	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
