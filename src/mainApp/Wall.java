package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;

public class Wall extends GameComponent {
	
    private int x;
    private int y;
	
    public Wall(int x, int y) {
    	super(x,y);
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
        g2d.setColor(Color.GRAY);
        g2d.fillRect(x, y, 50, 100);
    }

    @Override
    public void update() {
        // Implement update logic for Coin
        // For example, check for collisions, movement, etc.
    }

}
