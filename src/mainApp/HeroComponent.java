package mainApp;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import javax.swing.*;
import java.awt.*;

public class HeroComponent extends JComponent {
    private Hero hero;

    public HeroComponent(Hero hero) {
        this.hero = hero;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(hero.getX(), hero.getY(), 100, 100); // Draw the hero
    }
}



