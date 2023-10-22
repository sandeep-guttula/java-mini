import java.util.Scanner;
import java.util.Random;

public class RockPaperScissorsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = { "Rock", "Paper", "Scissors" };

        while (true) {
            System.out.println("Enter your choice (Rock, Paper, or Scissors): ");
            String userChoice = scanner.nextLine();

            // Validate user input
            if (!userChoice.equals("Rock") && !userChoice.equals("Paper") && !userChoice.equals("Scissors")) {
                System.out.println("Invalid choice. Please choose Rock, Paper, or Scissors.");
                continue;
            }

            // Generate a random choice for the computer
            int computerChoiceIndex = random.nextInt(3);
            String computerChoice = choices[computerChoiceIndex];

            System.out.println("Computer chooses: " + computerChoice);

            // Determine the winner
            if (userChoice.equals(computerChoice)) {
                System.out.println("It's a tie!");
            } else if ((userChoice.equals("Rock") && computerChoice.equals("Scissors"))
                    || (userChoice.equals("Scissors") && computerChoice.equals("Paper"))
                    || (userChoice.equals("Paper") && computerChoice.equals("Rock"))) {
                System.out.println("You win!");
            } else {
                System.out.println("Computer wins!");
            }

            System.out.println("Play again? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();

            if (!playAgain.equals("yes")) {
                break;
            }
        }

        scanner.close();
    }
}
