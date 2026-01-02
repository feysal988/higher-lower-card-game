package cardgame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select a game to play:");
        System.out.println("1 - Higher or Lower");
        System.out.println("2 - Guess the Suit");
        System.out.print("Enter 1 or 2: ");

        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            HigherLowerGame game = new HigherLowerGame();
            game.play();
        } else if (choice.equals("2")) {
            GuessSuitGame game = new GuessSuitGame();
            game.play();
        } else {
            System.out.println("Invalid choice. Exiting.");
        }
    }
}
