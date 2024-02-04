package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Missile extends GameComponent {
	
	private int x;
	private int y;
	
    public Missile(int x, int y) {
    	this.x = 700;
    	this.y = y;
    }
    
    public void move() {
    	this.x -= 2;	
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
	
	public static void setPosition(){
		
	}
	
	public static void loseLife(){
		
	}
	

}
