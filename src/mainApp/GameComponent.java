package mainApp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

class GameComponent extends JPanel {
    private static final int WIDTH = 800;
    static final int HEIGHT = 600;
    private static final int HERO_WIDTH = 50;
    protected static final int HERO_HEIGHT = 50;
    protected static final int WALL_WIDTH = 20;
    protected static final int COIN_SIZE = 20;
    protected static final int HERO_SPEED = 5;
    protected static final int WALL_SPEED = 3;
    protected static final int COIN_SPEED = 3;

    private Hero hero;
    private ArrayList<Wall> walls;
    private ArrayList<Coin> coins;
    private Timer timer;

    private boolean upKeyPressed;
    private boolean diagonalForwardKeyPressed;
    private boolean diagonalDownKeyPressed;

    public GameComponent() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.WHITE);

        hero = new Hero(10, HEIGHT - HERO_HEIGHT - 20, 3, 51);

        walls = new ArrayList<>();
        coins = new ArrayList<>();

        timer = new Timer();
        upKeyPressed = false;

        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
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

    public void startGame() {
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
        g2d.setColor(Color.RED);
        for (Wall wall : walls) {
            g2d.fillRect(wall.getX(), wall.getY(), WALL_WIDTH, 20);
        }

        // Draw coins
        g2d.setColor(Color.YELLOW);
        for (Coin coin : coins) {
            g2d.fillOval(coin.getX(), coin.getY(), COIN_SIZE, COIN_SIZE);
        }
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

    private void checkCollisions() {
        Rectangle heroRect = new Rectangle(hero.getX(), hero.getY(), HERO_WIDTH, HERO_HEIGHT);

        // Check collisions with walls
        for (Wall wall : walls) {
            Rectangle wallRect = new Rectangle(wall.getX(), wall.getY(), WALL_WIDTH, 20);
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
                // Handle collision with coin (e.g., increase score)
                // For now, let's just remove the coin
                i--;
            }
        }
    }
}