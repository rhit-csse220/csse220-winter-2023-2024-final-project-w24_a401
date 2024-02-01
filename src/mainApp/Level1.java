package mainApp;

public class Level1 extends Level {

    @Override
    protected String getLevelFileName() {
        return "src/level1.txt";
    }

    public static void main(String[] args) {
        Level1 app = new Level1();
        app.runApp();
    }
}
	



