package game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GUI extends JFrame implements ActionListener{
	private JTextArea text = new JTextArea();
	private JLabel roomName = new JLabel();

	
	public GUI() {
		setTitle("Text Game");
		setSize(600,500);
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
		JScrollPane scroll = new JScrollPane(text);
		pane.add(scroll);
		add(pane,BorderLayout.CENTER);
		text.setEditable(false);
		
		
		

		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	public void print(String s) {
		text.append(s+"\n\n");
	}
	
}
