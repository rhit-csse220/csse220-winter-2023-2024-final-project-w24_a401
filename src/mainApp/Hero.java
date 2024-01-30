package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;

public class Hero {
	
	private int xSpeed;
	private int ySpeed;
	private Shape heroShape;
	private Color heroColor;
	private int lives;
	private int xPosition;
	private int yPosition;
	private int heroHeight;
	private int heroWidth;
	
	
	public Hero(Color color, int xPosition, int yPosition, int height, int width) {
		this.heroColor = color;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.heroHeight = height;
		this.heroWidth = width;
		
	}
	
	
	public void drawHero(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawRect(xPosition, yPosition, heroWidth, heroHeight);
		g2.setColor(heroColor);
		g2.fillRect(xPosition, yPosition, heroWidth, heroHeight);
	}

	
	public void moveHero(Hero hero) {
		for(int i = 0; i < 100000; i ++) {
			hero.xPosition += 10;
		}
		
	}
}
