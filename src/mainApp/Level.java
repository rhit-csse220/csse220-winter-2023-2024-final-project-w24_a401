package mainApp;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Level {

    protected Set<String> allowedWords = new HashSet<>();
    protected List<GameComponent> levelComponents = new ArrayList<>();

    public Level() {
        allowedWords.add("wall");
        allowedWords.add("electrified barrier");
        allowedWords.add("missile");
        allowedWords.add("tracking missile");
        allowedWords.add("coin");
        allowedWords.add("oscillating coin");
    }

    protected void readFile(String fileName) {
        File levelFile = new File(fileName);

        try (Scanner scanner = new Scanner(levelFile)) {
            // Validate the format here
            if (!isValidFormat(scanner)) {
                throw new InvalidLevelFormatException("Invalid level format");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (InvalidLevelFormatException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        // Reset the scanner to the beginning of the file
        try (Scanner scanner = new Scanner(levelFile)) {
            // Read and add each line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] components = line.split(",");
                if (components.length == 3) {
                    String type = components[0].trim();
                    int x = Integer.parseInt(components[1].trim());
                    int y = Integer.parseInt(components[2].trim());

                    GameComponent gameComponent = createGameComponent(type, x, y);
                    levelComponents.add(gameComponent);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    private boolean isValidFormat(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (!allowedWords.contains(line.trim())) {
                return false;
            }
        }

        return true;
    }

    private GameComponent createGameComponent(String type, int x, int y) {
        switch (type) {
            case "c":
                return new Coin(x, y);
            case "o":
                return new OscillatingCoin(x, y);
            case "w":
                return new Wall(x, y);
            case "e":
                return new ElectrifiedBarrier(x, y);
            case "m":
                return new Missile(x, y);
            case "t":
                return new TrackingMissile(x, y);
            default:
                throw new IllegalArgumentException("Invalid game component type: " + type);
        }
    }

    public void runApp() {
        String filename = getLevelFileName();
        readFile(filename);
        // Now you can use the levelComponents list in your game
    }

    protected String getLevelFileName() {
        // Return the appropriate file name for the level
        return "";
    }
}
