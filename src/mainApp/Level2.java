package mainApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Level2 {
	private void readFile(String fileName) {
		Scanner scanner = null;
		File level2 = null;
		try {
			level2 = new File("src/level2.txt");
			scanner = new Scanner(level2);
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
			File parentFolder = level2.getParentFile();
			System.out.println("Folder searched for the file not found: " + parentFolder.getAbsolutePath());
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
	
	public void runApp() {
		String filename = "level2.txt";
		readFile(filename);
	} 
	public static void main(String[] args) {
		Level2 app = new Level2();
		app.runApp();
	}}
	
