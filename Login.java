import java.io.*;
import java.util.Scanner;

public class Login {

	public static void main(String[] args) {
		init();
		input();
	}

	public static void init() {
		// Just create a file for now... won't have a save.
		try{
		    PrintWriter writer = new PrintWriter("details.txt", "UTF-8");
		    writer.println("Optometrist"); // User
		    writer.println("twentytwenty"); // Password
		    writer.close();
		} catch (IOException e) {
		   // do something
		}
	}

	public static void input() {
		try {

			//Caveman way of reading txt file, will be improved further down.
			Scanner scan = new Scanner (new File("details.txt"));
			Scanner keyboard = new Scanner (System.in);
			String user = scan.nextLine();
			String password = scan.nextLine();

			System.out.println("User Input:");
			String inputUser = keyboard.nextLine();
			System.out.println("Password Input");
			String inputPassword = keyboard.nextLine();

			//Validation, testing the files reading and user inputs are correct step by step.
			/*if(inputUser.equals(user)) {
				System.out.println("User Valid. " + inputUser);
			}else
				System.out.println("User Invalid. " + inputUser + " Try: " + user);

			if(inputPassword.equals(password)) {
				System.out.println("Password Valid. " + inputPassword);
			}else
				System.out.println("Password Invalid. " + inputPassword + " Try: " + password);
			*/

			//Simple Validation check.
			if(inputUser.equals(user) && inputPassword.equals(password)) {
				System.out.println("Valid Session");
			}else
				System.out.println("Invalid Inputs");

		} catch (FileNotFoundException e) {
			System.out.println("File does not exist, Creating.");
			init();
		}
	}
}
