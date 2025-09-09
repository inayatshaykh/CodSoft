import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int roundsWon = 0;
        boolean playAgain;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Can you guess the number between 1 and 100?");

        do {
            int randomNumber = random.nextInt(100) + 1; // Generates a random number from 1 to 100
            int attempts = 0;
            final int MAX_ATTEMPTS = 10;
            boolean hasGuessedCorrectly = false;

            System.out.println("\n--- New Round ---");

            while (attempts < MAX_ATTEMPTS && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess;

                // Validate user input to ensure it's an integer
                if (scanner.hasNextInt()) {
                    userGuess = scanner.nextInt();
                    attempts++;

                    if (userGuess == randomNumber) {
                        System.out.println("Congratulations! You guessed the correct number!");
                        System.out.println("It took you " + attempts + " attempts.");
                        roundsWon++;
                        hasGuessedCorrectly = true;
                    } else if (userGuess < randomNumber) {
                        System.out.println("Too low. Try again.");
                    } else {
                        System.out.println("Too high. Try again.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Clear the invalid input from the scanner
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("\nGame Over! You ran out of attempts.");
                System.out.println("The correct number was: " + randomNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.next().toLowerCase();
            playAgain = playChoice.equals("yes");

        } while (playAgain);

        System.out.println("\n--- Game Summary ---");
        System.out.println("You won " + roundsWon + " round(s).");
        System.out.println("Thanks for playing!");

        scanner.close();
    }
}