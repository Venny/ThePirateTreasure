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
		
		ImageIcon img = new ImageIcon("C:\\Users\\k8\\s.png");
		sand = img.getImage();
		img = new ImageIcon("C:\\Users\\k8\\w.png");
		water = img.getImage();
		img = new ImageIcon("C:\\Users\\k8\\f.png");
		forest = img.getImage();
		img = new ImageIcon("C:\\Users\\k8\\java.png");
		java = img.getImage();
		img = new ImageIcon("C:\\Users\\k8\\computer.png");
		computer = img.getImage();
		img = new ImageIcon("C:\\Users\\k8\\internet.png");
		internet = img.getImage();
		img = new ImageIcon("C:\\Users\\k8\\eclipse.png");
		eclipse = img.getImage();
		img = new ImageIcon("C:\\Users\\k8\\coffee.png");
		coffee = img.getImage();
		img = new ImageIcon("C:\\Users\\k8\\github.png");
		github = img.getImage();
		img = new ImageIcon("C:\\Users\\k8\\cookie.png");
		cookie = img.getImage();
		img = new ImageIcon("C:\\Users\\k8\\hb.png");
		hb = img.getImage();
		img = new ImageIcon("C:\\Users\\k8\\mouse.png");
		mouse = img.getImage();
		img = new ImageIcon("C:\\Users\\k8\\palace.png");
		palace = img.getImage();
		
		img = new ImageIcon("C:\\Users\\k8\\parrot.png");
		parrot = img.getImage();
		
		img = new ImageIcon("C:\\Users\\k8\\flag.png");
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
		m = new Scanner(new File("C:\\Users\\k8\\TreasureMap.txt"));
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
