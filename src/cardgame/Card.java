package cardgame;

public class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getValue() {
        return rank.getValue();
    }

    public boolean isJoker() {
        return rank == Rank.JOKER;
    }

    @Override
    public String toString() {
        if (rank == Rank.JOKER) {
            return "JOKER";
        }
        return rank + " of " + suit;
    }
}
