package mainApp;

public class OscillatingCoin extends Coin {
	
	private int y;
	
	public OscillatingCoin(int x, int y) {
		super(x, y);
	}

	public void moveCoin(){
		if (this.y <= 0) {
			this.y += 2;
		}
		
		if (this.y >= 475) {
			this.y -= 2;
		}
		
	}

}
