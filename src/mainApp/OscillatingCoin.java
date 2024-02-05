package mainApp;

public class OscillatingCoin extends Coin {
	
	private static int speed;
	private int y;
	
	
	public OscillatingCoin(int x, int y) {
		super(speed, x, y);
	}

	public void moveCoin(){
		if (this.y >= 0) {
			this.y += 2;
		}
		
		if (this.y >= 475) {
			this.y -= 2;
		}
		
	}
	
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
