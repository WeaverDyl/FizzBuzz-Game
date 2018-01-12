package game;

import java.util.Scanner;

/**
 * Just a stupid command-line game I wrote out of boredom. Maybe I'll do more
 * with this at some point because it's incredibly basic right now and I have
 * some ideas that I can expand this with.
 * 
 * The game is just FizzBuzz. A number is printed, and you have to type the
 * correct response (the number, fizz, buzz, or fizzbuzz). If you don't know
 * how to play, instructions are provided. If you don't understand the
 * instructions, google the game.
 * 
 * @author Dylan Weaver
 *
 */
public class FizzBuzz {
	// Used by the user to input their answer
	static Scanner scanner = new Scanner(System.in);
	
	static int score = 0;
	
	public static void main(String[] args) {
		printRules();
		startGame();
	}
	
	/**
	 * Simply prints the rules of the game.
	 */
	private static void printRules() {
		System.out.println("Rules of FizzBuzz:\n");
		System.out.println("For each number, if the number is divisible by 3, "
				+ "write 'fizz'.");
		System.out.println("If the number is divisible by 5, write 'buzz'. ");
		System.out.println("If it's divisible by 3 and 5, write 'fizzbuzz'");
		System.out.println("A number will be printed, and you need to respond"
				+ " with the correct response. See how far you can get!");
		
		System.out.println();
	}
	
	/**
	 * Starts the game by printing the first number and accepting input
	 */
	private static void startGame() {
		int roundNumber = 0; // The current round number
		boolean correctAnswer = true; // Only false if user answers incorrectly
		String userAnswer; // Set by the scanner to represent the user's answer
		
		while (correctAnswer) {
			roundNumber++; // Start at round 1
			
			System.out.print(roundNumber + ": "); // Print the round number
			userAnswer = scanner.next(); // Accept user response
			
			// Check if the user answer is incorrect
			if (!userAnswer.equalsIgnoreCase(answer(roundNumber))) {
				correctAnswer = false;
			} else {
				score++; // User answered correctly, increment score.
			}
		}
		
		// If the user responded incorrectly, tell them the correct answer
		// and ask them if the want to play again
		if (!correctAnswer) {
			System.out.println("Incorrect! The correct answer was: " 
					+ answer(roundNumber));	
			
			// Print score and reset it
			System.out.println("Your score was: " + score);
			System.out.println();
			score = 0;
			askReplay();
		}
	}
	
	/**
	 * A FizzBuzz implementation used to check user solutions against
	 * correct solutions
	 * 
	 * @param round The current round (number) that we want the solution for
	 * @return A string containing the correct FizzBuzz response for the round
	 */
	private static String answer(int round) {
		if (round % 15 == 0) {
			return "FizzBuzz";
		} else if (round % 3 == 0) {
			return "Fizz";
		} else if (round % 5 == 0) {
			return "Buzz";
		} else {
			return Integer.toString(round);
		}
	}
	
	/**
	 * Asks the user if they want to play again after losing
	 */
	private static void askReplay() {
		String response;
		
		System.out.println("Would you like to play again? (Yes/No)");
		
		response = scanner.next(); // Accept input
		
		// If user wants to try again, clear the screen and let them.
		if (response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y")) {
			startGame();
		} else {
			return;
		}
	}
	
}
