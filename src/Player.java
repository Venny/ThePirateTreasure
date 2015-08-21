package ProjectTraining;

import java.awt.*;

import javax.swing.*;

public class Player {
	
	private int tileX, tileY;
	
	private Image player;
	
	public Player(){
		
		ImageIcon img = new ImageIcon("C:\\Users\\k8\\sparrow.png");
		player = img.getImage();
	
		
		tileX = 1; //starting?
		tileY = 1;
	}
	
	public Image getPlayer(){ //gives the picture
		return player;
	}
	
	
	public int getTileX(){
		return tileX;
	}
	
	public int getTileY(){
		return tileY;
	}
	
	public void move(int dx, int dy){
		
		tileX += dx;
		tileY += dy;
	}
}
