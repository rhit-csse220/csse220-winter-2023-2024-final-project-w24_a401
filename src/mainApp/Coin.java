package mainApp;

public class Coin extends Obstacle {
	
    private int x;
    private int y;
	
    public Coin(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
	public static void addScore(){
		
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

}
