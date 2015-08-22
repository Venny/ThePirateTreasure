package Desktop;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Board extends JPanel implements ActionListener{
	
	private Timer timer;
	
	private NewMap m;
	private Player p;
	
	private boolean win = false;
	
	private int questCounter = 0;
	
	private String Message1 = "Quests: 0/10";
	private String Message2 = "Hey, mate! \n Your first step\n is to get yourself\n a computer!";
	private Font font1 = new Font("Gabriola",Font.BOLD, 30);
	private Font font2 = new Font("Gabriola",Font.PLAIN, 28);
	
	public Board(){
		
		m = new NewMap();
		p = new Player();
		addKeyListener(new Al());
		setFocusable(true);
		
		timer = new Timer(25, this);
		timer.start();
	}
	
	private void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }
	@Override
	public void actionPerformed(ActionEvent e) { 

		switch(questCounter){
		case 0: if(p.getTileX()==29 && p.getTileY()==1){if(true){questCounter++; Message1 = "Quests: 1/10"; 
		 Message2 = "Ooops! \n It seems that \n the seller does\n not have a mouse\n to give you!";}}; break;
		case 1: if(p.getTileX()==4 && p.getTileY()==14){if(true){questCounter++; Message1 = "Quests: 2/10";
		 Message2 = "Next you will\n need the best\n Internet\n connection\n on the island!";}}; break;
		case 2: if(p.getTileX()==27 && p.getTileY()==16){if(true){questCounter++; Message1 = "Quests: 3/10";
		 Message2 = "Now that you\n have successfully\n connected to the\n web, you need to\n get your hands\n on Java!"; }}; break;
		case 3: if(p.getTileX()==11 && p.getTileY()==2){if(true){questCounter++; Message1 = "Quests: 4/10";
		 Message2 = "And you will\n also need an \nintegrated \ndevelopment\n environment - \n Eclipse! "; }}; break;
		case 4: if(p.getTileX()==8 && p.getTileY()==21){if(true){questCounter++; Message1 = "Quests: 5/10";
		 Message2 = "Before you get\n to work, I\n advise you to\n get a cup of \n delicious coffee!"; }}; break;
		case 5: if(p.getTileX()==20 && p.getTileY()==6){if(true){questCounter++; Message1 = "Quests: 6/10"; 
		 Message2 = "...And some\n yummy chocolate\n cookies to give\n you energy \n to code!";}}; break;
		case 6: if(p.getTileX()==29 && p.getTileY()==15){if(true){questCounter++; Message1 = "Quests: 7/10"; 
		 Message2 = "As you work on \n your project,you\n realise that you\n will need some help\n from those prodigies\n at HackBulgaria!";}}; break;
		case 7: if(p.getTileX()==1 && p.getTileY()==3){if(true){questCounter++; Message1 = "Quests: 8/10";
		 Message2 = "Everything is\n perfect now!\n The king is\n waiting for your\n code on GitHub!"; }}; break;
		case 8: if(p.getTileX()==6 && p.getTileY()==23){if(true){questCounter++; Message1 = "Quests: 9/10"; 
		 Message2 = "The king is\n satisfied, so he\n invites you to the\n palace to give\n you your prize -\n a trip home!";}}; break;
		case 9: if(p.getTileX()==16 && p.getTileY()==12){if(true){questCounter++; Message1 = "Quests: 10/10"; }}; break;
		}
		repaint();
	}

	public void paint(Graphics g){
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		if(!win){
		for(int y = 0; y < 25; y++){ //row
			for(int x = 0; x < 40; x++){ //column
				if(m.getMap(x, y).equals("f")){
					g2.drawImage(m.getForest(), x*30, y*30, null);
				}
				if(m.getMap(x, y).equals("s")){
					g2.drawImage(m.getSand(), x*30, y*30, null);
				}
				if(m.getMap(x, y).equals("w")){
					g2.drawImage(m.getWater(), x*30, y*30, null);
					
				}
					
			}
		}
		
		
		g2.drawImage(m.getParrot(), 960, 15, null);
		g2.setColor(Color.RED);g2.setFont(font1);g2.drawString(Message1, 990, 80);
		g2.setColor(Color.WHITE);g2.setFont(font2);drawString(g2, Message2, 975, 400);
		g2.drawImage(p.getPlayer(), p.getTileX() * 30, p.getTileY() * 30, null);
		
		switch(questCounter){
		case 0: g2.drawImage(m.getComputer(), 29*30, 1*30, null); break;
		
		case 1: g2.drawImage(m.getMouse(), 4*30, 14*30, null);     g2.drawImage(m.getComputer(), 1000, 90, null); break;
		
		case 2: g2.drawImage(m.getInternet(), 27*30, 16*30, null); g2.drawImage(m.getComputer(), 1000, 90, null);
																   g2.drawImage(m.getMouse(), 1040, 90, null); break;
																   
		case 3: g2.drawImage(m.getJava(), 11*30, 2*30, null);      g2.drawImage(m.getComputer(), 1000, 90, null);
																   g2.drawImage(m.getMouse(), 1040, 90, null);
																   g2.drawImage(m.getInternet(), 1080, 90, null); break;
																   
		case 4: g2.drawImage(m.getEclipse(), 8*30, 21*30, null);   g2.drawImage(m.getComputer(), 1000, 90, null);
		   														   g2.drawImage(m.getMouse(), 1040, 90, null);
		   														   g2.drawImage(m.getInternet(), 1080, 90, null);
		   														   
		   														   g2.drawImage(m.getJava(), 1000, 130, null); break;
		   														   
		case 5: g2.drawImage(m.getCoffee(), 20*30, 6*30, null);    g2.drawImage(m.getComputer(), 1000, 90, null);
		   														   g2.drawImage(m.getMouse(), 1040, 90, null);
		   														   g2.drawImage(m.getInternet(), 1080, 90, null);
		   														   
		   														   g2.drawImage(m.getJava(), 1000, 130, null); 
		   													   	   g2.drawImage(m.getEclipse(), 1040, 130, null);break;
		   													   	   
		case 6: g2.drawImage(m.getCookie(), 29*30, 15*30, null);   g2.drawImage(m.getComputer(), 1000, 90, null);
		   														   g2.drawImage(m.getMouse(), 1040, 90, null);
		   														   g2.drawImage(m.getInternet(), 1080, 90, null);
		   														   
		   														   g2.drawImage(m.getJava(), 1000, 130, null); 
		   														   g2.drawImage(m.getEclipse(), 1040, 130, null);
		   														   g2.drawImage(m.getCoffee(), 1080, 130, null);break;
		   														   
		case 7: g2.drawImage(m.getHb(), 1*30, 3*30, null);         g2.drawImage(m.getComputer(), 1000, 90, null);
		   														   g2.drawImage(m.getMouse(), 1040, 90, null);
		   														   g2.drawImage(m.getInternet(), 1080, 90, null);
		   														   
		   														   g2.drawImage(m.getJava(), 1000, 130, null); 
		   														   g2.drawImage(m.getEclipse(), 1040, 130, null);
		   														   g2.drawImage(m.getCoffee(), 1080, 130, null);
		   														   
		   														   g2.drawImage(m.getCookie(), 1000, 170, null);break;
		   														   
		case 8: g2.drawImage(m.getGithub(), 6*30, 23*30, null);    g2.drawImage(m.getComputer(), 1000, 90, null);
		   														   g2.drawImage(m.getMouse(), 1040, 90, null);
		   														   g2.drawImage(m.getInternet(), 1080, 90, null);
		   
		   														   g2.drawImage(m.getJava(), 1000, 130, null); 
		   														   g2.drawImage(m.getEclipse(), 1040, 130, null);
		   														   g2.drawImage(m.getCoffee(), 1080, 130, null);
		   
		   														   g2.drawImage(m.getCookie(), 1000, 170, null);
		   														   g2.drawImage(m.getHb(), 1040, 170, null); break;
		   														   
		case 9: g2.drawImage(m.getPalace(), 16*30, 12*30, null);   g2.drawImage(m.getComputer(), 1000, 90, null);
		   														   g2.drawImage(m.getMouse(), 1040, 90, null);
		   														   g2.drawImage(m.getInternet(), 1080, 90, null);

		   														   g2.drawImage(m.getJava(), 1000, 130, null); 
		   														   g2.drawImage(m.getEclipse(), 1040, 130, null);
		   														   g2.drawImage(m.getCoffee(), 1080, 130, null);

		   														   g2.drawImage(m.getCookie(), 1000, 170, null);
		   														   g2.drawImage(m.getHb(), 1040, 170, null);
		   														   g2.drawImage(m.getGithub(), 1080, 170, null); break;
		}
		
		
		}
		
		if(win){
			g2.setColor(Color.RED);
			g2.setFont(font1);
			g2.drawString(Message1, 150, 300);
		}
		
	}
	
	public class Al extends KeyAdapter{
		
		public void keyPressed(KeyEvent e){
			int keycode = e.getKeyCode();
			
			if(keycode == KeyEvent.VK_LEFT){
				if(!m.getMap(p.getTileX()-1, p.getTileY()).equals("w") && !m.getMap(p.getTileX()-1, p.getTileY()).equals("f")){
				p.move(-1, 0);
			}}
			
			if(keycode == KeyEvent.VK_RIGHT){
				if(!m.getMap(p.getTileX() + 1, p.getTileY()).equals("w") && !m.getMap(p.getTileX()+1, p.getTileY()).equals("f")){
				p.move(1, 0);
			}}

			if(keycode == KeyEvent.VK_UP){
				if(!m.getMap(p.getTileX(), p.getTileY() -1).equals("w") && !m.getMap(p.getTileX(), p.getTileY() -1).equals("f")){
				p.move(0, -1);
			}}

			if(keycode == KeyEvent.VK_DOWN){
				if(!m.getMap(p.getTileX(), p.getTileY() +1).equals("w") && !m.getMap(p.getTileX(), p.getTileY() +1).equals("f")){
				p.move(0, 1);
			}}
		}
		
		public void keyReleased(KeyEvent e){
			
		}
		
		public void keyTyped(KeyEvent e){
			
		}
	}
}
