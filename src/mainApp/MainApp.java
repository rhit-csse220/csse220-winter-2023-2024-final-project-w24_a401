package mainApp;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


/**
 * Class: MainApp
 * @author Team w24_a401
 * <br>Purpose: Top level class for CSSE220 Project containing main method 
 * <br>Restrictions: None
 */


public class MainApp {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Game");
            GameComponent gameComponent = new GameComponent();
            frame.add(gameComponent);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            // Create and use the Level class
            Level level = new Level();

            // Main game loop
            while (level.hasMoreLevels()) {
                // Load the next level
                level.loadNextLevel();

                // Get the components for the current level
                List<GameComponent> components = level.getLevelComponents();

                // Set the components to your GameComponent
                gameComponent.addInitialComponents(components);

                // Start the game
                gameComponent.startGame();

                // Wait for the level to finish
                // For simplicity, you can add a flag in your GameComponent to indicate when the level is finished
                // For example, add a boolean variable in GameComponent like: private boolean levelFinished;

                // Move to the next level
                level.nextLevel();
            }
        });

        JFrame frame = new JFrame("Game");
        final int frameWidth = 1000;
        final int frameHeight = 600;
        frame.setSize(frameWidth, frameHeight);
        GameComponent gameComponent = new GameComponent();
        frame.add(gameComponent);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        gameComponent.startGame();
    }
}