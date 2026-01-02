package cardgame;

import java.util.Scanner;

public class HigherLowerGame {
    private final Deck deck;
    private Card currentCard;
    private int score;
    private int streak;

    public HigherLowerGame() {
        deck = new Deck();
        deck.shuffle();
        currentCard = deck.drawCard();
        score = 0;
        streak = 0;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean playing = true;

        System.out.println("Welcome to Higher or Lower");

        while (playing && !deck.isEmpty()) {
            System.out.println("Current card: " + currentCard);
            System.out.print("Higher or Lower (H/L): ");

            char guess = scanner.nextLine().toUpperCase().charAt(0);

            Card nextCard = deck.drawCard();
            System.out.println("Next card: " + nextCard);

            if (nextCard.isJoker()) {
                System.out.println("JOKER drawn! You survive.");
                streak = 0;
                currentCard = deck.drawCard();
                System.out.println();
                continue;
            }

            if (GameRules.isCorrectGuess(currentCard, nextCard, guess)) {
                streak++;
                score += streak;
                System.out.println("Correct");
                System.out.println("Streak: " + streak);
            } else {
                System.out.println("Wrong");
                playing = false;
            }

            currentCard = nextCard;
            System.out.println("Score: " + score);
            System.out.println();
        }

        System.out.println("Game Over");
        System.out.println("Final Score: " + score);
    }
}

