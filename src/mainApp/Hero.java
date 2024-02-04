package mainApp;


class Hero {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
    private int y;
    private final int speed;
    private final int height;
    private int lives;
    private int coinCount;

    public Hero(int x, int y, int speed, int height) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.height = height;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
 
    public int getLives() {
    	return this.lives;
    }

    public int getCoinCount() {
    	return this.coinCount;
    }
    public void moveUp() {
        y -= speed;
        if (y < 0) {
            y = 0;
        }
    }

    public void moveDown() {
        y += speed;
        if (y + height > GameComponent.HEIGHT) {
            y = GameComponent.HEIGHT - height;
        }
    }
}