package cardgame;

import java.util.Scanner;

public class HigherLowerGame {

    private final Deck deck;
    private int score;
    private int highScore;

    public HigherLowerGame() {
        deck = new Deck();
        deck.shuffle();
        score = 0;
        highScore = HighScoreManager.loadHighScore();
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Higher or Lower");
        System.out.println("High Score: " + highScore);
        System.out.println();

        Card currentCard = deck.drawCard();

        while (!deck.isEmpty()) {
            System.out.println("Current card: " + currentCard);
            System.out.print("Higher or Lower (H/L): ");
            String choice = scanner.nextLine().toUpperCase();

            Card nextCard = deck.drawCard();

            if (nextCard.isJoker()) {
                System.out.println("JOKER drawn! You survive.");
                currentCard = deck.drawCard();
                System.out.println();
                continue;
            }

            System.out.println("Next card: " + nextCard);

            boolean correct =
                    (choice.equals("H") && nextCard.getValue() > currentCard.getValue()) ||
                            (choice.equals("L") && nextCard.getValue() < currentCard.getValue());

            if (correct) {
                score++;
                System.out.println("Correct");
            } else {
                System.out.println("Wrong");
                break;
            }

            System.out.println("Score: " + score);
            System.out.println();
            currentCard = nextCard;
        }

        if (score > highScore) {
            HighScoreManager.saveHighScore(score);
            System.out.println("NEW HIGH SCORE!");
        }

        System.out.println("Game Over");
        System.out.println("Final Score: " + score);
        System.out.println("High Score: " + Math.max(score, highScore));
    }
}
