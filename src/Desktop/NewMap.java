package Desktop;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class NewMap {
	
	private Scanner m;
	private String Map[] = new String[25]; //tiles going down
	
	private Image sand,water,forest, java, computer, internet, coffee, github, eclipse, cookie, hb, mouse, palace, parrot, flag;
	
	public NewMap(){
		
		ImageIcon img = new ImageIcon("src/res/s.png");
		sand = img.getImage();
		img = new ImageIcon("src/res/w.png");
		water = img.getImage();
		img = new ImageIcon("src/res/f.png");
		forest = img.getImage();
		img = new ImageIcon("src/res/java.png");
		java = img.getImage();
		img = new ImageIcon("src/res/computer.png");
		computer = img.getImage();
		img = new ImageIcon("src/res/internet.png");
		internet = img.getImage();
		img = new ImageIcon("src/res/eclipse.png");
		eclipse = img.getImage();
		img = new ImageIcon("src/res/coffee.png");
		coffee = img.getImage();
		img = new ImageIcon("src/res/github.png");
		github = img.getImage();
		img = new ImageIcon("src/res/cookie.png");
		cookie = img.getImage();
		img = new ImageIcon("src/res/hb.png");
		hb = img.getImage();
		img = new ImageIcon("src/res/mouse.png");
		mouse = img.getImage();
		img = new ImageIcon("src/res/palace.png");
		palace = img.getImage();
		
		img = new ImageIcon("src/res/parrot.png");
		parrot = img.getImage();
		
		img = new ImageIcon("src/res/flag.png");
		flag = img.getImage();
		
		openFile();
		readFile();
		closeFile();
	}
	
	public Image getSand(){
		return sand;
	}
	public Image getWater(){
		return water;
	}
	public Image getForest(){
		return forest;
	}
	public Image getJava(){
		return java;
	}
	public Image getComputer(){
		return computer;
	}
	public Image getInternet(){
		return internet;
	}
	public Image getCoffee(){
		return coffee;
	}
	public Image getEclipse(){
		return eclipse;
	}
	public Image getGithub(){
		return github;
	}
	public Image getMouse(){
		return mouse;
	}
	public Image getCookie(){
		return cookie;
	}
	public Image getHb(){
		return hb;
	}
	public Image getPalace(){
		return palace;
	}
	public Image getParrot(){
		return parrot;
	}
	public Image getFlag(){
		return flag;
	}
	
	public String getMap(int x, int y){
		String index = Map[y].substring(x, x+1);
		return index;
	}
	
	public void openFile(){
		try{
		m = new Scanner(new File("src/res/TreasureMap.txt"));
	}catch(Exception e){
		System.out.println("error loading map");
	}
	}
	
	public void readFile(){
		while(m.hasNext()){
			for(int i = 0; i < 25; i++){
				Map[i] = m.next();
			}
		}
	}
	
	public void closeFile(){
		m.close();
	}
}
