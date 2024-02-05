package mainApp;

public class Scoreboard {

	private Hero hero;
	
	public Scoreboard(Hero hero) {
		this.hero = hero;
	}
	
	public int countCoins(){
		return this.hero.getCoinCount();
	}
	
	public int countlives(){
		return this.hero.getLives(); 
	}
	
	public static void endGame(){
		
	}
	
}

