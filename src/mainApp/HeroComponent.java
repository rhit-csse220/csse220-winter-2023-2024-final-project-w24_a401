package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class HeroComponent extends JComponent {
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		Hero hero1 = new Hero(Color.BLACK,10, 400, 100, 100);
		hero1.drawHero(g2);
		hero1.moveHero(hero1);

	}
	
	

	
	}
