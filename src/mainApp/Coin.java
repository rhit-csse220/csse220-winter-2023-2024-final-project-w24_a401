package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;

public class Coin extends GameComponent {
	
    private int x;
    private int y;
	
    public Coin(int x, int y) {
    	super(x,y);
    }
    
	public static void addScore(){
		
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
    @Override
    public void render(Graphics2D g2d) {
        // Implement rendering logic for Coin
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(x, y, 20, 20); // Example: drawing a yellow circle
    }

    @Override
    public void update() {
        // Implement update logic for Coin
        // For example, check for collisions, movement, etc.
    }

}



