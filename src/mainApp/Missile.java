package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Missile extends GameComponent {

    private int x;
    private int y;

    public Missile(int x, int y) {
        this.x = x; // Use the provided x parameter instead of a fixed value
        this.y = y;
    }

    public void move() {
        this.x -= 10; // Move towards the left
        if (x <= 0) {
            x = 800;
        } // Wrap to the right side
    }

    // Remove unnecessary static methods

    // Provide getters and setters for x and y if needed
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // If you need to change the position, use setters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
	
	public static void setPosition(){
		
	}
	
	public static void loseLife(){
		
	}
	

}
