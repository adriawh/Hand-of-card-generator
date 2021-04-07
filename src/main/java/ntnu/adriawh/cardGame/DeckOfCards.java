package ntnu.adriawh.cardGame;

import java.security.InvalidParameterException;
import java.util.*;

/**
 * Class to represent a deck of cards
 */
public class DeckOfCards {
    private final ArrayList<PlayingCard> cards;
    private final char[] suit = { 'S', 'H', 'D', 'C' };

    /**
     * Constructor that generates the 52 cards that a regular stack of cards contains
     */
    public DeckOfCards() {
        cards = new ArrayList<>();
        for (char c: suit) {
            for(int i = 1; i<=13;i++){
                cards.add(new PlayingCard(c, i));
            }
        }
    }

    public ArrayList<PlayingCard> getCards() {
        return cards;
    }

    /**
     * Creates an instance of the class handOfCards with n cards
     * @param n number of cards to be in hand
     * @return HandOfCards
     * @throws InvalidParameterException A hand can only be 5 and up to 52 cards in size
     */
    public HandOfCards dealHand(int n) throws InvalidParameterException {
        Collections.shuffle(cards);
        if(n<5 ||n>52){
           throw new InvalidParameterException("Number must be bigger than 4, and smaller than 52");
        }
        ArrayList<PlayingCard> hand = new ArrayList<>();

        for(int i = 0; i<n; i++) {
            hand.add(cards.get(i));
        }
        return new HandOfCards(hand);

    }


    @Override
    public String toString() {
        return "DeckOfCards{" +
                "cards=" + cards +
                ", suit=" + Arrays.toString(suit) +
                '}';
    }
}