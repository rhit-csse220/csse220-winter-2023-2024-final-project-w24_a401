package mainApp;

import javax.swing.JComponent;
import javax.swing.JFrame;



//hi!!
/**
 * Class: MainApp
 * @author Team w24_a401
 * <br>Purpose: Top level class for CSSE220 Project containing main method 
 * <br>Restrictions: None
 */
public class MainApp {
	
	
	private void runApp() {
		System.out.println("Write your cool arcade game here!!");		
	} // runApp

	/**
	 * ensures: runs the application
	 * @param args unused
	 */
	public static void main(String[] args) {
		MainApp mainApp = new MainApp();
		mainApp.runApp();
		
        final int frameWidth = 1000;
        final int frameHeight = 600;
        final int frameXLoc = 100;
        final int frameYLoc = 100;

        // Creating the JFrame
        JFrame frame = new JFrame();
        frame.setSize(frameWidth, frameHeight);
        frame.setLocation(frameXLoc, frameYLoc);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JComponent heroComponent = new HeroComponent();
        frame.add(heroComponent);
        
        
        
        
        frame.setVisible(true);
		
	} // main

}