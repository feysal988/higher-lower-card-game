package cardgame;

public class GameRules {
    public static boolean isCorrectGuess(Card current, Card next, char guess) {
        if (guess == 'H') {
            return next.getValue() > current.getValue();
        }
        return next.getValue() < current.getValue();
    }
}
