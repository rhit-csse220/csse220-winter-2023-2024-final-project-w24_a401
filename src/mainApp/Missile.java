package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;

public class Missile extends GameComponent {
	
	private int x;
	private int y;
	
    public Missile(int x, int y) {
    	super(x,y);
    }
    
    public void move() {
    	this.x -= 2;	
    }
	
	public static void setPosition(){
		
	}
	
	public static void loseLife(){
		
	}
	
    @Override
    public void render(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.fillRect(x, y, 30, 30); 
    }

    @Override
    public void update() {
        // Implement update logic for Coin
        // For example, check for collisions, movement, etc.
    }

}
