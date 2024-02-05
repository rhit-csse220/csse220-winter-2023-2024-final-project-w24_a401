
package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

class ElectrifiedBarrier extends GameComponent {
	
	private int x;
	private int y;
    private final int speed;
    private final int screenWidth;
    private final int screenHeight;
	
    public ElectrifiedBarrier(int speed, int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.x = screenWidth; // Start from the right side
        this.y = new Random().nextInt(screenHeight); // Random y position within the screen height
        this.speed = speed;
    }
	
	public static void loseLife(){
		
	}
	
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void move() {
        x -= speed; // Move towards the left
        if (x <= 0) {
            x = screenWidth; // Wrap to the right side
        }
    }
}

//package mainApp;
//
//import java.awt.Color;
//import java.awt.Graphics2D;
//
//public class ElectrifiedBarrier extends GameComponent {
//	
//	private int x;
//	private int y;
//	
//    public ElectrifiedBarrier(int x, int y) {
//    	super();
//    }
//	
//	public static void loseLife(){
//		
//	}
//	
//    public void render(Graphics2D g2d) {
//        // Implement rendering logic for Coin
//        g2d.setColor(Color.BLUE);
//        g2d.fillRect(x, y, 50, 100); 
//    }
//
////    @Override
////    public void update() {
////        // Implement update logic for Coin
////        // For example, check for collisions, movement, etc.
////    }
//}
//package mainApp;
//
//import java.awt.Color;
//import java.awt.Graphics2D;
//
//public class ElectrifiedBarrier extends GameComponent {
//	
//	private int x;
//	private int y;
//	
//    public ElectrifiedBarrier(int x, int y) {
//    	super();
//    }
//	
//	public static void loseLife(){
//		
//	}
//	
//    public void render(Graphics2D g2d) {
//        // Implement rendering logic for Coin
//        g2d.setColor(Color.BLUE);
//        g2d.fillRect(x, y, 50, 100); 
//    }
//
////    @Override
////    public void update() {
////        // Implement update logic for Coin
////        // For example, check for collisions, movement, etc.
////    }
//}
