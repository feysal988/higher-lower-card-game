package cardgame;

import java.util.Scanner;

public class GuessSuitGame {

    private final Deck deck;
    private int score;
    private int highScore;

    public GuessSuitGame() {
        deck = new Deck();
        deck.shuffle();
        score = 0;
        highScore = HighScoreManager.loadHighScore();
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Guess the Suit!");
        System.out.println("High Score: " + highScore);
        System.out.println();

        while (!deck.isEmpty()) {
            Card card = deck.drawCard();

            if (card.isJoker()) {
                System.out.println("JOKER drawn! You survive.");
                System.out.println();
                continue;
            }

            System.out.print("Guess the suit (HEARTS, DIAMONDS, CLUBS, SPADES): ");
            String guess = scanner.nextLine().toUpperCase();

            if (guess.equals(card.getSuit().toString())) {
                score++;
                System.out.println("Correct! It was " + card);
            } else {
                System.out.println("Wrong! It was " + card);
                break;
            }

            System.out.println("Score: " + score);
            System.out.println();
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
