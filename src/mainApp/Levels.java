package mainApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;



public class Levels {

	
	
	
	
	private void readFile(String fileName) {
		Scanner scanner = null;
		File level1 = null;
		try {
			level1 = new File(fileName);
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
	



	private void writeFile(String outputFilename) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(outputFilename);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}}
	public void runApp() {
		String filename = "level1.txt";
		writeFile(filename);
		readFile(filename);
	} 
	public static void main(String[] args) {
		Levels app = new Levels();
		app.runApp();
	}}
	




