package mainApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Level1 {

    private Set<String> allowedWords = new HashSet<>();

    public Level1() {
        allowedWords.add("wall");
        allowedWords.add("electrified barrier");
        allowedWords.add("missile");
        allowedWords.add("tracking missile");
        allowedWords.add("coin");
        allowedWords.add("oscillating coin");
    }

    private void readFile(String fileName) {
        Scanner scanner = null;
        File level1 = null;
        try {
            level1 = new File("src/level1.txt");
            scanner = new Scanner(level1);

            if (!isValidFormat(scanner)) {
                throw new InvalidLevelFormatException("Invalid level format");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            File parentFolder = level1.getParentFile();
            System.out.println("Folder searched for the file not found: " + parentFolder.getAbsolutePath());
            System.exit(1);
        } catch (InvalidLevelFormatException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        String title = scanner.nextLine();
        System.out.println("Title: " + title);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        scanner.close();
    }

    private boolean isValidFormat(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();

            if (!allowedWords.contains(line)) {
                System.out.println("Invalid word found: " + line);
                return false;
            }
        }

        return true;
    }

    public void runApp() {
        String filename = "level1.txt";
        readFile(filename);
    }

    public static void main(String[] args) {
        Level1 app = new Level1();
        app.runApp();
    }
}
	



