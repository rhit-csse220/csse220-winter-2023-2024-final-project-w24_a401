package mainApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Game extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private Level currentLevel;
    private Timer gameTimer;
    private int currentLevelIndex;

    public Game() {
        initializeGame();
        setupGameLoop();
        startNextLevel();
    }

    private void initializeGame() {
        currentLevel = new Level();
        currentLevelIndex = 1; // Start with level 1
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void setupGameLoop() {
        int delay = 16; // Milliseconds per frame (approximately 60 FPS)
        gameTimer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateGame();
                repaint();
            }
        });
        gameTimer.start();
    }

    void startNextLevel() {
        if (currentLevelIndex <= 2) {
            String levelFileName = "level" + currentLevelIndex + ".txt";
            currentLevel.readFile(levelFileName);
            currentLevelIndex++;

            // Add a delay before moving on to the next level (e.g., 3000 milliseconds)
            Timer levelSwitchTimer = new Timer(3000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    startNextLevel();
                }
            });
            levelSwitchTimer.setRepeats(false); // Only execute once
            levelSwitchTimer.start();
        } else {
            // All levels completed, prompt the player to play again or quit
            int option = JOptionPane.showOptionDialog(
                    this,
                    "Congratulations! You completed all levels. What would you like to do?",
                    "Game Over",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    new String[]{"Play Again", "Quit"},
                    "Play Again"
            );

            if (option == JOptionPane.YES_OPTION) {
                // Player chose to play again, reset game state and start over
                currentLevelIndex = 1;
                startNextLevel();
            } else {
                // Player chose to quit, stop the game
                gameTimer.stop();
                System.out.println("Game Over");
            }
        }
    }

    private void updateGame() {
        for (GameComponent component : currentLevel.levelComponents) {
            component.update();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        for (GameComponent component : currentLevel.levelComponents) {
            component.render(g2d);
        }

        Toolkit.getDefaultToolkit().sync(); // Sync the display on some systems
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Game();
            }
        });
    }

    public void addGameComponent(GameComponent gameComponent) {
        gameComponents.add(gameComponent);
    }
	    // Add key listener for level switching
    @addKeyListener(new KeyListener() {
        public void keyPressed(KeyEvent e) {
            handleKeyPress(e);
        }

        public void keyReleased(KeyEvent e) {
            // Handle key released events if needed
        }

        public void keyTyped(KeyEvent e) {
            // Handle key typed events if needed
        }
	
	private void handleKeyPress(KeyEvent e) {
	    int keyCode = e.getKeyCode();
	    char keyChar = Character.toUpperCase(e.getKeyChar());
	
	    if (keyChar == 'U') {
	        switchToNextLevel();
	    } else if (keyChar == 'D') {
	        switchToPreviousLevel();
	    }
	}
	
	private void switchToNextLevel() {
	    if (currentLevelIndex < levelComponents.size() - 1) {
	        currentLevelIndex++;
	        repaint(); // Repaint to show the components of the new level
	    }
	}
	
	private void switchToPreviousLevel() {
	    if (currentLevelIndex > 0) {
	        currentLevelIndex--;
	        repaint(); // Repaint to show the components of the new level
	    }
	}

