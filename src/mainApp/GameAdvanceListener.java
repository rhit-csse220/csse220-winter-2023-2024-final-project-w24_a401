package mainApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JComponent;


public class GameAdvanceListener extends TimerTask {
    private Hero hero;
    private HeroComponent heroComponent;

    public GameAdvanceListener(Hero hero, HeroComponent heroComponent) {
        this.hero = hero;
        this.heroComponent = heroComponent;
    }

    @Override
    public void run() {
        hero.move();
        heroComponent.repaint();
    }
}


