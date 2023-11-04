import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int first = 1;
        int last = 100;
        int maxAttempts = 5;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            int secretNumber = random.nextInt(last - first + 1) + first;
            int attempts = 0;

            System.out.println("I've generated a random number between " + first + " and " + last + ". Try to guess it!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == secretNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score++;
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }

                if (attempts == maxAttempts) {
                    System.out.println("You've reached the maximum number of attempts. The correct number was: " + secretNumber);
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                System.out.println("Game Over. Your final score: " + score + " rounds won.");
                break;
            }
        }

        scanner.close();
    }
}

