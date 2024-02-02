package mainApp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;

import javax.swing.JComponent;
import javax.swing.JFrame;



//hi!!
/**
 * Class: MainApp
 * @author Team w24_a401
 * <br>Purpose: Top level class for CSSE220 Project containing main method 
 * <br>Restrictions: None
 */
import javax.swing.*;


public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	final int frameWidth = 1000;
            final int frameHeight = 600;
            final int frameXLoc = 100;
            final int frameYLoc = 100;
  
            // Creating the JFrame
            JFrame frame = new JFrame();
            frame.setSize(frameWidth, frameHeight);
            frame.setLocation(frameXLoc, frameYLoc);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Hero hero = new Hero(0, 400, 2);
            HeroComponent heroComponent = new HeroComponent(hero);
            
            GameComponent gameComponent = new GameComponent(hero.getX(), hero.getY());
            
            frame.add(heroComponent);

            GameAdvanceListener gameAdvanceListener = new GameAdvanceListener(hero, heroComponent);
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(gameAdvanceListener, 0, 10); // Schedule the task to run every 10 milliseconds

            frame.addKeyListener(new KeyAdapter(){
            	@Override
            	public void keyPressed(KeyEvent e) {
            		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            			System.out.println("Space Bar Pressed");
            			hero.setYPosition(-100);
            			heroComponent.repaint();
            		}
            	}
            	
            	
            	public void keyReleased(KeyEvent e) {
            		if(e.getKeyCode() == KeyEvent.VK_SPACE){
            			hero.setYPosition(100);
            			System.out.println("Space Bar Released");
            			heroComponent.repaint();
        	
        }
            	}
            });
            
            
            
            frame.setVisible(true);
        });
    }
}



