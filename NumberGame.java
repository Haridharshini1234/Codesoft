import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String playAgain = "yes";
        
        while (playAgain.equalsIgnoreCase("yes")) {
            System.out.println("Welcome to the Number Guessing Game...");
            int lowerBound = 1;
            int upperBound = 100;
            int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int maxAttempts = 5;
            int attempts = 0;
            
            while (attempts < maxAttempts) {
                System.out.printf("Guess the number between ,%d and %d: ", lowerBound, upperBound);
                int guess = scanner.nextInt();
                attempts++;
                
                if (guess == secretNumber) {
                    System.out.printf("Congratulations! You guessed the number %d correctly in %d attempts.%n", secretNumber, attempts);
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("sorry Too low! Try again.");
                } else {
                    System.out.println("sorry Too high! Try again.");
                }
            }
            
            if (attempts == maxAttempts) {
                System.out.printf("Sorry, you've run out of attempts. The correct number was %d.%n", secretNumber);
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next();
        }
        
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}