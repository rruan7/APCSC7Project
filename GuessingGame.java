/* Renee Ruan
 * P3 APCS Peterson
 * 7 December 2020
 * Chapter 5 Programming Project
 */

import java.util.*;

public class GuessingGame {
	
	//class constants to keep track of overall stats
	public static int totalGuesses = 0;
	public static int gameNum = 0;
	public static int bestGuessNum = 0;
	public static int bestGameNum = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		gameNum++; //set game number = 1
		int g1 = game(scanner, random); //first game, returns number of guesses
		totalGuesses += g1; //add number of guesses to total guesses
		bestGuessNum = g1; //set best guess number equal to guesses in first game
		bestGameNum = gameNum; //set best guess number equal to game one
		
		while (playAgain(scanner)) { //boolean method that returns true if user wants to play again
			gameNum++; //add 1 to game number
			int g = game(scanner, random);
			totalGuesses += g; //add number of guesses to total guesses
			if (g < bestGuessNum) { //test if this is a new best game
				bestGuessNum = g;
				bestGameNum = gameNum;
			}
		}
		
		//calculating and truncating guesses per game
		double guessesPerGame = (double)(totalGuesses) / gameNum;
		guessesPerGame = Math.floor(guessesPerGame * 100) / 100;
		
		//printing overall stats
		System.out.println("Your overall results: ");
		System.out.println("Total games = " + gameNum);
		System.out.println("Total guesses = " + totalGuesses);
		System.out.println("Guesses/game = " + guessesPerGame);
		System.out.println("Best game = " + bestGameNum);

	}
	
	//method that runs guessing game and prompts user input
	public static int game(Scanner scanner, Random random) {
		int number = random.nextInt(100) + 1; //throws random number 1-100
		System.out.println("I'm thinking of a number between 1 and 100...");
		System.out.println("Your guess?");
		boolean guessed = false;
		int guesses = 1; //keeps track of number of guesses within each game
		
		while (! guessed) { //runs while user has not guessed number
			while (! scanner.hasNextInt()) { //handles exception for non-integer guesses
				scanner.next();
				System.out.println("Your guess was not a whole number between 1 and 100");
				System.out.println("Your guess?");
			}
			int guess = scanner.nextInt();
			while (guess < 1 || guess > 100) { //if user inputs an out-of-range guess
				System.out.println("Your guess was not a whole number between 1 and 100");
				System.out.println("Your guess?");
				guess = scanner.nextInt();
			}
			
			//tests if guess is too high, too low, or correct
			if (guess < number) {
				System.out.println("It's higher.");
				guesses++;
				System.out.println("Your guess?");
			} else if (guess > number) {
				System.out.println("It's lower.");
				guesses++;
				System.out.println("Your guess?");
			} else if (guess == number) {
				guessed = true; //exits while loop
			}
		}
			
		if (guessed) { //if guessed is true
			System.out.println("You guessed it in " + guesses + " guesses!");
			return guesses; //returns number of guesses
		} else {
			return -1000000;
		}
			
	}
		
	//method to test if user wants to play again
	public static boolean playAgain(Scanner scanner) {
		System.out.println("Play again?");
		String response = scanner.next();
		if (response.toLowerCase().charAt(0) == 'y') { //if user input starts with y
			return true;
		} else {
			return false;
		}
	}
	
}


