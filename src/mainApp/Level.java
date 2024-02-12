package mainApp;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Level {

    private List<GameComponent> levelComponents = new ArrayList<>();
    int currentLevelIndex = 0;
    private List<String> levelFileNames = List.of("src/level1.txt", "src/level2.txt");
	private Hero hero;

    public boolean hasMoreLevels() {
        return currentLevelIndex < levelFileNames.size();
    }

    public void loadNextLevel() {
        System.out.println("Loading next level.");
        String filename = getLevelFileName();
        try {
            readFile(filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    

    public List<GameComponent> getLevelComponents() {
        return new ArrayList<>(levelComponents);
    }

    private String getLevelFileName() {
        if (currentLevelIndex < levelFileNames.size()) {
            return levelFileNames.get(currentLevelIndex);
        }
        return null;  // No more levels
    }

    private void readFile(String fileName) {
        System.out.println("Reading file: " + fileName);  // Add this line

        File levelFile = new File(fileName);

        try (Scanner scanner = new Scanner(levelFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Read from file: " + line);  // Add this line

                String[] components = line.split(",");
                if (components.length == 3) {
                    String type = components[0].trim();
                    int x = Integer.parseInt(components[1].trim());
                    int y = Integer.parseInt(components[2].trim());

                    GameComponent gameComponent = createGameComponent(type, x, y);
                    levelComponents.add(gameComponent);
                }
            }
        } catch (FileNotFoundException | NumberFormatException e) {
            e.printStackTrace();
        } catch (InvalidLevelFormatException e) {
			e.printStackTrace();
		}
    }

    private GameComponent createGameComponent(String type, int x, int y) throws InvalidLevelFormatException {
        switch (type) {
            case "c":
                return new Coin(3, x, y);
            case "o":
                return new OscillatingCoin(x, y);
            case "h":
            	return new HealPickup(3, x, y);
            case "w":
                return new Wall(3, x, y);
            case "e":
                return new ElectrifiedBarrier(3, x, y);
            case "m":
                return new Missile(x, y);
            case "t":
                return new TrackingMissile(x, y, hero);
            default:
                throw new InvalidLevelFormatException("Invalid game component type: " + type);
        }
    }

    public void nextLevel() {
        currentLevelIndex++;
        levelComponents.clear();
        System.out.println("Next Level Index: " + currentLevelIndex);  // Add this line
    }

    public void previousLevel() {
        currentLevelIndex--;
        levelComponents.clear();
        System.out.println("Previous Level Index: " + currentLevelIndex);  // Add this line
    }

	public int getCurrentLevelIndex() {
		return this.currentLevelIndex;
	}
}
