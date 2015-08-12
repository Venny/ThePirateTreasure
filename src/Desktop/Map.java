package Desktop;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ButtonGroup;
import javax.swing.JDesktopPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.TextArea;
import java.awt.Label;
import java.awt.Panel;
import javax.swing.JLayeredPane;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class Map {

	private JFrame frmPirateTreasureHunt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField pirateName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Map window = new Map();
					window.frmPirateTreasureHunt.setVisible(true);
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
		frmPirateTreasureHunt = new JFrame();
		frmPirateTreasureHunt.setResizable(false);
		frmPirateTreasureHunt.setSize(1024, 765);
		frmPirateTreasureHunt.setIconImage(Toolkit.getDefaultToolkit().getImage(Map.class.getResource("/pictures/flag.png")));
		frmPirateTreasureHunt.setTitle("Pirate Treasure Hunt");
		frmPirateTreasureHunt.setAlwaysOnTop(true);
		frmPirateTreasureHunt.setBackground(Color.WHITE);
		frmPirateTreasureHunt.setBounds(100, 100, 1024, 740);
		frmPirateTreasureHunt.setLocationRelativeTo(null);
		frmPirateTreasureHunt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		GroupLayout groupLayout = new GroupLayout(frmPirateTreasureHunt.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 1020, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 706, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLayeredPane panel = new JLayeredPane();
		panel.setFocusCycleRoot(true);
		panel.setBorder(null);
		panel.setBounds(168, 81, 667, 503);
		layeredPane.add(panel);
		
		JLabel choosePlayerLabel = new JLabel("Choose your player:");
		choosePlayerLabel.setFont(new Font("Gabriola", Font.BOLD, 35));
		
		JRadioButton rbFemale = new JRadioButton("Female");
		rbFemale.setContentAreaFilled(false);
		buttonGroup.add(rbFemale);
		rbFemale.setFont(new Font("Gabriola", Font.PLAIN, 28));
		
		JRadioButton rbMale = new JRadioButton("Male");
		rbMale.setActionCommand(" Male");
		rbMale.setFocusPainted(false);
		rbMale.setContentAreaFilled(false);
		buttonGroup.add(rbMale);
		rbMale.setFont(new Font("Gabriola", Font.PLAIN, 28));
		
		JLabel setNameLabel = new JLabel("Your pirate's name:");
		setNameLabel.setFont(new Font("Gabriola", Font.BOLD, 30));
		
		JLabel editorLabel = new JLabel("");
		editorLabel.setIcon(new ImageIcon(Map.class.getResource("/pictures/faceless.jpg")));
		editorLabel.setPreferredSize(new Dimension(180, 300));
		editorLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		rbMale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editorLabel.setIcon(new ImageIcon(Map.class.getResource("/pictures/Male.png")));
			}
		});
		
		rbFemale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editorLabel.setIcon(new ImageIcon(Map.class.getResource("/pictures/Female.png")));
			}
		});
		
		pirateName = new JTextField();
		pirateName.setFont(new Font("Gabriola", Font.ITALIC, 24));
		pirateName.setColumns(10);
		
		JButton startTheHuntButton = new JButton("START THE HUNT!");
		startTheHuntButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = pirateName.getText();
			}
		});
		startTheHuntButton.setFont(new Font("Gabriola", Font.BOLD, 30));
		
	
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(54)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(choosePlayerLabel)
								.addComponent(rbMale)
								.addComponent(rbFemale)
								.addComponent(setNameLabel)
								.addComponent(pirateName, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE))
							.addGap(91)
							.addComponent(editorLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(196)
							.addComponent(startTheHuntButton)))
					.addContainerGap(93, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(choosePlayerLabel)
							.addGap(9)
							.addComponent(rbMale)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rbFemale)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(setNameLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pirateName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(editorLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
					.addComponent(startTheHuntButton)
					.addGap(31))
		);
		panel.setLayout(gl_panel);
		
		JLabel BgLabel = new JLabel("");
		BgLabel.setIcon(new ImageIcon(Map.class.getResource("/pictures/bg.jpeg")));
		BgLabel.setBounds(0, 0, 1020, 706);
		layeredPane.add(BgLabel);
		frmPirateTreasureHunt.getContentPane().setLayout(groupLayout);
	}
}
