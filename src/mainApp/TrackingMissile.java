package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;

public class TrackingMissile extends Missile {
	
	private int x;
	private int y;
	private Hero hero;
	
	public TrackingMissile(int x, int y) {
		super(x, y);
	}

	public void moveMissile(){
    	super.move();
    	if (hero.getY() > this.y && hero.getX() < this.x) {
    		this.y += 2;
	}
    	if (hero.getY() < this.y && hero.getX() < this.x) {
    		this.y -= 2;
	}
    	if (hero.getX() > this.x) {
    		this.y = this.y;
    	}
	}
	
    @Override
    public void render(Graphics2D g2d) {
        // Implement rendering logic for Coin
        g2d.setColor(Color.RED);
        g2d.fillRect(x, y, 30, 30);
    }

    @Override
    public void update() {
        // Implement update logic for Coin
        // For example, check for collisions, movement, etc.
    }
}

