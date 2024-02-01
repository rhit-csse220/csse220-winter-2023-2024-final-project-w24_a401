package mainApp;

public class Wall extends Obstacle {
	
    private int x;
    private int y;
	
    public Wall(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

}
