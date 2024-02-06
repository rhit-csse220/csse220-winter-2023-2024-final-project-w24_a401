package mainApp;

public class Scoreboard extends GameComponent{

	private Hero hero;
	private int committedCoins;
	private int lives;
	
	public Scoreboard(Hero hero) {
		this.hero = hero;
	}
	
	//return count of TOTAL CURRENT COINS, committed + non committed
	public int countCoins(){
		return this.hero.getCoinCount();
	}
	
	//return count of current lives
	public int countlives(Hero hero){
		return this.hero.getLives(); 
	}
	
	public static void endGame(){
		
	}
	
}

