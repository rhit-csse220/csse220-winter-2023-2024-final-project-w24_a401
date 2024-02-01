package mainApp;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class WallComponent extends JComponent {
	private Wall wall;
	
	public WallComponent(Wall wall) {
		this.wall = wall;
	}
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(wall.getX(), wall.getY(), 10, 200);
    }

}
