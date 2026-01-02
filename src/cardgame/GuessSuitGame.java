package cardgame;

import java.util.Scanner;

public class GuessSuitGame {
    private final Deck deck;
    private int score;

    public GuessSuitGame() {
        deck = new Deck();
        deck.shuffle();
        score = 0;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean playing = true;

        System.out.println("Welcome to Guess the Suit!");

        while (playing && !deck.isEmpty()) {
            Card card = deck.drawCard();

            if (card.isJoker()) {
                System.out.println("JOKER drawn! You survive.");
                System.out.println();
                continue;
            }

            System.out.println("A card has been drawn. Guess the suit (HEARTS, DIAMONDS, CLUBS, SPADES):");
            String guess = scanner.nextLine().toUpperCase();

            if (guess.equals(card.getSuit().name())) {
                score++;
                System.out.println("Correct! It was " + card);
            } else {
                System.out.println("Wrong! It was " + card);
                playing = false;
            }

            System.out.println("Score: " + score);
            System.out.println();
        }

        System.out.println("Game Over");
        System.out.println("Final Score: " + score);
    }
}
