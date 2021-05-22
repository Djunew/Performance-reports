package reports;

import java.util.Scanner;

public class ReadFile {

	/* 
	 * This method takes user input from console
	 * and return it as string 
	 */
	public static String readFilePathFromConsole () {
			
		System.out.print("File path: ");
			
		Scanner scan = new Scanner(System.in);
		String path;
		path = scan.nextLine();
		
		//System.out.println(path);
		
		return path;
	}
	
}
