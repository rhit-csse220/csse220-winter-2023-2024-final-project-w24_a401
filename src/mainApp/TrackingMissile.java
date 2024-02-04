package mainApp;

import java.awt.Color;
import java.awt.Graphics;
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
	
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

