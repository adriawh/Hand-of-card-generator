package ntnu.adriawh.cardGame;

import java.security.InvalidParameterException;
import java.util.*;

public class DeckOfCards {
    private final ArrayList<PlayingCard> cards;
    private final char[] suit = { 'S', 'H', 'D', 'C' };


    public DeckOfCards() {
        cards = new ArrayList<>();
        for (char c: suit) {
            for(int i = 1; i<=13;i++){
                cards.add(new PlayingCard(c, i));
            }
        }
    }

    public HandOfCards DealHand(int n) throws InvalidParameterException {
        Collections.shuffle(cards);
        if(n<1 ||n>52){
           throw new InvalidParameterException("Number must be bigger than 0, and smaller than 52");
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