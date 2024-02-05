package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class TrackingMissile extends Missile {

    private Hero hero;
    private int x;
    private int y;

    public TrackingMissile(int x, int y, Hero hero) {
        super(x, y);
        this.hero = hero;
    }

    public void moveMissile() {
        super.move();
        if (hero.getY() > this.y) {
            this.y += 2;
        } else if (hero.getY() < this.y) {
            this.y -= 2;
        }

        // If hero.getX() is less than this.x, you may want to move left.
        if (hero.getX() < this.x) {
            this.x -= 2; // Adjust the value based on the desired speed.
        }
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    }

