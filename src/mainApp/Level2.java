package mainApp;

public class Level2 extends Level {

    @Override
    protected String getLevelFileName() {
        return "src/level2.txt";
    }

    public static void main(String[] args) {
        Level2 app = new Level2();
        app.runApp();
    }
}	
