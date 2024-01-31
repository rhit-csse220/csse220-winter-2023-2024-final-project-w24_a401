package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.KeyEvent;


public class Hero {
    private int x;
    private int y;
    private int moveX;
    private int moveY;
    private boolean jumpKeyPressed = false;

    public Hero(int x, int y, int changeX) {
        this.x = x;
        this.y = y;
        this.moveX = changeX;
    }
    public int getX() {
    	return this.x;
 
    }
    
    public int getY() {
    	return this.y;
    }

    public void move() {
        this.x += this.moveX;
        if (this.x > 900) {
            this.x = 0;
 //           this.moveX = -this.moveX; // Reverse direction when hitting left edge
        }
//        } else if (x > 1000) { // Assuming width of the screen is 400
//            this.x = 1000;
//            this.moveX = -this.moveX; // Reverse direction when hitting right edge
//        }
    }

    public void setYPosition(int changeY) {
    	this.y += changeY;
    	if(this.y < 0) {
    		this.y = 500;
    		
    	}
    }
    
    
}


