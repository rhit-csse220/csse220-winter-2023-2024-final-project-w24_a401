package mainApp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;

import javax.swing.JComponent;
import javax.swing.JFrame;



//hi!!
/**
 * Class: MainApp
 * @author Team w24_a401
 * <br>Purpose: Top level class for CSSE220 Project containing main method 
 * <br>Restrictions: None
 */
import javax.swing.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Game");
        final int frameWidth = 1000;
        final int frameHeight = 600;
        frame.setSize(frameWidth, frameHeight);
        GameComponent gameComponent = new GameComponent();
        frame.add(gameComponent);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        gameComponent.startGame();
    }
}