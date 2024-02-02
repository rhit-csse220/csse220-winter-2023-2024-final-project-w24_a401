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
    private boolean isJumping = false;
    private boolean isGoingUp = false; // Flag to track the direction of diagonal movement

    public Hero(int x, int y, int changeX) {
        this.x = x;
        this.y = y;
        this.moveX = changeX;
//        this.moveY = 0; // Initialize the vertical movement to zero
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void move() {
        if (jumpKeyPressed && !isJumping) {
            // If space bar is pressed and not already jumping, initiate diagonal jump
            isJumping = true;
            isGoingUp = true; // Set the flag for upward diagonal movement
        }

        // Diagonal movement
        this.x += this.moveX;

        // Handle vertical movement during diagonal jump
        if (isJumping) {
            if (isGoingUp) {
                this.moveY = -1; // Move upwards during diagonal jump
            } else {
                this.moveY = 1; // Move downwards during diagonal jump
            }
        } else {
            this.moveY = 1; // Automatically fall diagonally when not jumping
        }

        this.y += this.moveY;

        // Limiting x coordinate
        if (this.x > 900) {
            this.x = 900;
        }

        // Limiting y coordinate
        if (this.y < 0) {
            this.y = 0;
            isJumping = false; // Reset jumping status when reaching the top
        }
        if (this.y > 475) {
            this.y = 475;
            isJumping = false; // Reset jumping status when reaching the bottom
        }
    }

    public void setYPosition(int changeY) {
        this.y += changeY;
        if (this.y < 0) {
            this.y = 0;
        }
    }

    // Call this method when space bar is pressed to initiate the diagonal jump
    public void startJump() {
        jumpKeyPressed = true;
    }
}


