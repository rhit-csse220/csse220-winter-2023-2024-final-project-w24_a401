package mainApp;

public class Scoreboard {

	private Hero hero;
	private int committedCoins;
	
	public Scoreboard(Hero hero) {
		this.hero = hero;
	}
	
	//add coins collected to permanent score (should happen at end of level)
	public void commitCoins() {
		this.committedCoins += this.hero.getCoinCount();
	}
	
	//return count of TOTAL CURRENT COINS, committed + non committed
	public int countCoins(){
		return this.committedCoins + this.hero.getCoinCount();
	}
	
	//add coin
	public void addCoin() {
		this.committedCoins++;
	}
	
	//return count of current lives
	public int countlives(Hero hero){
		return this.hero.getLives(); 
	}
	
	public static void endGame(){
		
	}
	
}

