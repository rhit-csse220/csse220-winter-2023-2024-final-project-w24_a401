package mainApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;



public class Level1 {
	
	private void readFile(String fileName) {
		Scanner scanner = null;
		File level1 = null;
		try {
			level1 = new File("src/level1.txt");
			scanner = new Scanner(level1);
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
			File parentFolder = level1.getParentFile();
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
		String filename = "level1.txt";
		readFile(filename);
	} 
	public static void main(String[] args) {
		Level1 app = new Level1();
		app.runApp();
	}}
	



