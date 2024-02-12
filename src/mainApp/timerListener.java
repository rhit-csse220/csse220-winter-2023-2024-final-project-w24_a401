package mainApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class timerListener implements ActionListener{
	private GameComponent gameComponent;
	public timerListener(GameComponent gameComponent) {
		this.gameComponent = gameComponent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gameComponent.update();
	}

}
