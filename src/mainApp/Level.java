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
    protected List<String> levelComponent = new ArrayList<>();

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
                levelComponent.add(line);
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

    public void runApp() {
        String filename = getLevelFileName();
        readFile(filename);
    }

    // This method should be implemented by each specific level
    protected String getLevelFileName() {
        return ""; // Override this method in each specific level class
    }
}
