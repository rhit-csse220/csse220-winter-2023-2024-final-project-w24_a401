package mainApp;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class CoinComponent extends JComponent {
	private Coin coin;
	
	public CoinComponent(Coin coin) {
		this.coin = coin;
	}
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.YELLOW);
        g.fillOval(coin.getX(), coin.getY(), 30, 30);
    }
	

}