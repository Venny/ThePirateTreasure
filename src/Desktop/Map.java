package Desktop;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;

public class Map {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Map window = new Map();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Map() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.getContentPane().setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
<<<<<<< HEAD
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel label = new JLabel(new ImageIcon("C:\\Users\\k8\\Downloads\\pirate.png"));
		label.setIconTextGap(2);
		panel.add(label);
=======
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\k8\\Downloads\\pirate.png"));
		frame.getContentPane().add(lblNewLabel, BorderLayout.WEST);
>>>>>>> dev
		frame.setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 1024, 740);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**** TO DO ******/
}
