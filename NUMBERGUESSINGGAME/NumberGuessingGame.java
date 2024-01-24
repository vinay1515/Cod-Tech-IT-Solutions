import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        // Generate a random number between 1 and 100
        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1;

        // Set the maximum number of attempts
        int maxAttempts = 5;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100. Can you guess it?");
        System.out.println("You have " + maxAttempts + " attempts.");

        // Main game loop
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            int userGuess = getUserGuess();

            // Check if the guess is correct
            if (userGuess == targetNumber) {
                System.out.println("Congratulations! You have guessed the correct number in " + attempt + " attempts.");
                break;
            } else {
                // Provide hints based on the comparison
                if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                // Display the remaining attempts
                int remainingAttempts = maxAttempts - attempt;
                System.out.println("Remaining attempts: " + remainingAttempts);
            }
        }

        // Display the correct number if the player couldn't guess it
        if (targetNumber != getUserGuess()) {
            System.out.println("Sorry, you couldn't guess the number. The correct number was: " + targetNumber);
        }
    }

    // Helper method to get user input for the guess
    private static int getUserGuess() {
        Scanner  scanner = new Scanner(System.in);

        int userGuess;
        while (true) {
            System.out.print("Enter your guess (1-100): ");
            if (scanner.hasNextInt()) {
                userGuess = scanner.nextInt();

                // Validate the input range
                if (userGuess >= 1 && userGuess <= 100) {
                    break;
                } else {
                    System.out.println("Please enter a number between 1 and 100.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // consume the invalid input
            }
        }

        return userGuess;
    }
}
