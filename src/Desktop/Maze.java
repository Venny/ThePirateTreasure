package Desktop;

import java.awt.Toolkit;

import javax.swing.*;

public class Maze {
	public static void main(String[] args){
		new Maze();
	}
	
	public Maze(){
		JFrame f = new JFrame();
		f.setTitle("Programmer of the Caribbean: The Long Way Home");
		f.setIconImage(Toolkit.getDefaultToolkit().getImage("res/flag.png"));
		f.add(new Board());
		f.setSize(1200,794);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
