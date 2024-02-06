package mainApp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JPanel;

public class GameComponent extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 800;
    static final int HEIGHT = 600;
    private static final int HERO_WIDTH = 50;
    protected static final int HERO_HEIGHT = 50;
    protected static final int WALL_WIDTH = 20;
    protected static final int COIN_SIZE = 20;
    protected static final int HERO_SPEED = 3;
    protected static final int WALL_SPEED = 3;
    protected static final int COIN_SPEED = 3;

    private Hero hero;
    protected Scoreboard scoreboard;
    
    private CopyOnWriteArrayList<Wall> walls = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Coin> coins = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Missile> missiles = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<TrackingMissile> tmissiles = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<ElectrifiedBarrier> ebarriers = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<OscillatingCoin> ocoins = new CopyOnWriteArrayList<>();
    
    private Timer timer;

    private boolean upKeyPressed;

    private Level currentLevel;
    
    private boolean diagonalForwardKeyPressed;
    private boolean diagonalDownKeyPressed;


    public GameComponent() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.WHITE);


        hero = new Hero(10, HEIGHT - HERO_HEIGHT, HERO_SPEED, 51);
        
//        walls = new ArrayList<>();
//        coins = new ArrayList<>();
//        missiles = new ArrayList<>();
//        tmissiles = new ArrayList<>();
//        ebarriers = new ArrayList<>();
//        ocoins = new ArrayList<>();

        hero = new Hero(10, HEIGHT - HERO_HEIGHT - 20, 3, 51);
        scoreboard = new Scoreboard(hero);

        timer = new Timer();
        upKeyPressed = false;
        currentLevel = new Level();

        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                handleKeyPress(e);


                handleKeyPress(e);

                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    upKeyPressed = true;
                }else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                	diagonalForwardKeyPressed = true;
                }else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                	diagonalDownKeyPressed = true;
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                handleKeyRelease(e);

                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    upKeyPressed = false;
                }else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                	diagonalForwardKeyPressed = false;
                }else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                	diagonalDownKeyPressed = false;
                }
            }
            
            
        });
    }

    private void handleKeyPress(KeyEvent e) {
        System.out.println("Key Pressed: " + e.getKeyChar()); 
        int keyCode = e.getKeyCode();
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upKeyPressed = true;
        } else if (keyCode == KeyEvent.VK_U) {
            switchToNextLevel();
        } else if (keyCode == KeyEvent.VK_D) {
            switchToPreviousLevel();
        }
    }
    


    private void handleKeyRelease(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upKeyPressed = false;
        }
    }
    
        
    public void addInitialComponents(List<GameComponent> initialComponents) {
        for (GameComponent component : initialComponents) {
            if (component instanceof Wall) {
                walls.add((Wall) component);
            } else if (component instanceof Coin) {
                coins.add((Coin) component);
            } else if (component instanceof Missile) {
                missiles.add((Missile) component);
            } else if (component instanceof TrackingMissile) {
                tmissiles.add((TrackingMissile) component);
            } else if (component instanceof ElectrifiedBarrier) {
                ebarriers.add((ElectrifiedBarrier) component);
            } else if (component instanceof OscillatingCoin) {
                ocoins.add((OscillatingCoin) component);
            }
        }
    }

    public void startGame() {
        System.out.println("Starting game.");  // Add this line

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                update();
            }
        }, 0, 20);

        requestFocusInWindow();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw hero
        g2d.setColor(Color.BLUE);
        g2d.fillRect(hero.getX(), hero.getY(), HERO_WIDTH, HERO_HEIGHT);

        // Draw walls
        g2d.setColor(Color.GRAY);
        for (Wall wall : walls) {
            g2d.fillRect(wall.getX(), wall.getY(), WALL_WIDTH, 10);
            wall.move();
            g2d.fillRect(wall.getX(), wall.getY(), WALL_WIDTH, 20);
        }

        // Draw coins
        g2d.setColor(Color.YELLOW);
        for (Coin coin : coins) {
            g2d.fillOval(coin.getX(), coin.getY(), COIN_SIZE, COIN_SIZE);
        }
        
        // Draw missiles
        g2d.setColor(Color.BLACK);
        for (Missile missile: missiles) {
        	g2d.fillRect(missile.getX(), missile.getY(), 30, 10);
        	missile.move();
        }
        
     // Draw tracking missiles
        g2d.setColor(Color.RED);
        for (TrackingMissile trackingmissile : tmissiles) {
            g2d.fillRect(trackingmissile.getX(), trackingmissile.getY(), 30, 10);
            trackingmissile.moveMissile();
        }
        
        // Draw electrified barriers
        g2d.setColor(Color.CYAN);
        for (ElectrifiedBarrier electrifiedbarrier: ebarriers) {
        	g2d.fillRect(electrifiedbarrier.getX(), electrifiedbarrier.getY(), WALL_WIDTH, 10);
        	electrifiedbarrier.move();
        }
        
        // Draw oscillating coins
        g2d.setColor(Color.YELLOW);
        for (OscillatingCoin oscillatingcoin : ocoins) {
            g2d.fillOval(oscillatingcoin.getX(), oscillatingcoin.getY(), COIN_SIZE, COIN_SIZE);
            oscillatingcoin.moveCoin();
        }
        
    }

    private void switchToNextLevel() {
        if (currentLevel != null && currentLevel.hasMoreLevels()) {
            currentLevel.nextLevel();
            System.out.println("Switched to level: " + currentLevel.getCurrentLevelIndex());
            loadCurrentLevel();
        }
    }

    private void switchToPreviousLevel() {
        if (currentLevel != null && currentLevel.getCurrentLevelIndex() > 0) {
            currentLevel.previousLevel();
            loadCurrentLevel();
        }
    }

    private void loadCurrentLevel() {
        List<GameComponent> components = currentLevel.getLevelComponents();
        clearGameComponents();
        addInitialComponents(components);  // Add this line to add components from the new level
        startGame();
    }

    private void clearGameComponents() {
        walls.clear();
        coins.clear();
        missiles.clear();
        tmissiles.clear();
        ebarriers.clear();
        ocoins.clear();
    }
    
    
    private void update() {
        // Move hero
        if (upKeyPressed) {
            hero.moveUp();
        } else {
            hero.moveDown();
        }
        
        if(diagonalForwardKeyPressed) {
        	hero.moveDiagonallyForwardDown();
        }
        if(diagonalForwardKeyPressed && upKeyPressed) {
        	hero.moveDiagonallyForwardUp();
        }
        if(diagonalDownKeyPressed) {
        	hero.moveDiagonallyBackDown();
        }
        
        if(diagonalDownKeyPressed && upKeyPressed) {
        	hero.moveDiagonallyBackUp();
        }

        // Move walls
        moveWalls();

        // Move coins
        moveCoins();

        // Move missiles
        moveMissiles();

        // Move tracking missiles
        moveTrackingMissiles();

        // Move electrified barriers
        moveElectrifiedBarriers();

        // Move oscillating coins
        moveOscillatingCoins();

        // Check collisions
        checkCollisions();

        // Repaint
        repaint();
    }

    private void moveWalls() {
        Random rand = new Random();
        if (rand.nextInt(100) < 5) {
            int x = rand.nextInt(WIDTH - WALL_WIDTH);
            walls.add(new Wall(WALL_SPEED, getWidth(), getHeight()));
        }

        for (int i = 0; i < walls.size(); i++) {
            Wall wall = walls.get(i);
            wall.move();
            if (wall.getY() > HEIGHT) {
                walls.remove(i);
                i--;
            }
        }
    }

    private void moveCoins() {
        Random rand = new Random();
        if (rand.nextInt(100) < 5) {
            int x = rand.nextInt(WIDTH - COIN_SIZE);
            coins.add(new Coin(COIN_SPEED,getWidth(),getHeight()));
        }

        for (int i = 0; i < coins.size(); i++) {
            Coin coin = coins.get(i);
            coin.move();
            if (coin.getY() > HEIGHT) {
                coins.remove(i);
                i--;
            }
        }
    }
    
    private void moveElectrifiedBarriers() {
        Random rand = new Random();
        if (rand.nextInt(100) < 5) {
            int x = rand.nextInt(WIDTH - WALL_WIDTH);
            ebarriers.add(new ElectrifiedBarrier(WALL_SPEED, getWidth(), getHeight()));
        }

        for (int i = 0; i < ebarriers.size(); i++) {
            ElectrifiedBarrier electrifiedbarrier = ebarriers.get(i);
            electrifiedbarrier.move();
            if (electrifiedbarrier.getY() > HEIGHT) {
                ebarriers.remove(i);
                i--;
            }
        }
    }

    private void moveOscillatingCoins() {
        Random rand = new Random();
        if (rand.nextInt(100) < 5) {
            int x = rand.nextInt(WIDTH - COIN_SIZE);
            ocoins.add(new OscillatingCoin(getWidth(),getHeight()));
        }

        for (int i = 0; i < ocoins.size(); i++) {
            OscillatingCoin oscillatingcoin = ocoins.get(i);
            oscillatingcoin.move();
            if (oscillatingcoin.getY() > HEIGHT) {
                ocoins.remove(i);
                i--;
            }
        }
    }

    private void moveMissiles() {
        Random rand = new Random();
        if (rand.nextInt(100) < 5) {
            int x = rand.nextInt(WIDTH - WALL_WIDTH);
            missiles.add(new Missile(getWidth(), getHeight()));
        }

        for (int i = 0; i < missiles.size(); i++) {
            Missile missile = missiles.get(i);
            missile.move();
            if (missile.getY() > HEIGHT) {
                missiles.remove(i);
                i--;
            }
        }
    }

    private void moveTrackingMissiles() {
        Random rand = new Random();
        if (rand.nextInt(100) < 5) {
            int x = rand.nextInt(WIDTH - WALL_WIDTH);
            tmissiles.add(new TrackingMissile(getWidth(), getHeight(), hero));
        }

        for (int i = 0; i < tmissiles.size(); i++) {
            TrackingMissile trackingmissile = tmissiles.get(i);
            trackingmissile.move();
            if (trackingmissile.getY() > HEIGHT) {
                tmissiles.remove(i);
                i--;
            }
        }
    }

    private void checkCollisions() {
        Rectangle heroRect = new Rectangle(hero.getX(), hero.getY(), HERO_WIDTH, HERO_HEIGHT);

        // Check collisions with walls
        for (Wall wall : walls) {
            Rectangle wallRect = new Rectangle(wall.getX(), wall.getY(), WALL_WIDTH, 10);
            if (heroRect.intersects(wallRect)) {
   
            	System.out.println("Collides");
            	
                // handle collision with wall
                // stops game right now but will later implement lose life method
                timer.cancel();
            }
        }

        // Check collisions with coins
        for (int i = 0; i < coins.size(); i++) {
            Coin coin = coins.get(i);
            Rectangle coinRect = new Rectangle(coin.getX(), coin.getY(), COIN_SIZE, COIN_SIZE);
            if (heroRect.intersects(coinRect)) {
                coins.remove(i);
                scoreboard.addCoin();
                // Handle collision with coin (e.g., increase score)
                // For now, let's just remove the coin
                i--;
            }
        }
    }
}