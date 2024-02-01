package mainApp;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class LevelSwitcher extends JFrame implements KeyListener {

    private Level currentLevel;

    public LevelSwitcher(Level initialLevel) {
        this.currentLevel = initialLevel;

//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(400, 300);
        addKeyListener(this);
        setFocusable(true);
        requestFocus();

        switchLevel(currentLevel);
    }

    private void switchLevel(Level newLevel) {
        currentLevel = newLevel;
        System.out.println(currentLevel.getClass().getSimpleName());
        currentLevel.runApp();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'U' || e.getKeyChar() == 'u') {
            switchLevel(new Level2());
        } else if (e.getKeyChar() == 'D' || e.getKeyChar() == 'd') {
            switchLevel(new Level1());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LevelSwitcher levelSwitcher = new LevelSwitcher(new Level1());
            levelSwitcher.setVisible(true);
        });
    }
}
