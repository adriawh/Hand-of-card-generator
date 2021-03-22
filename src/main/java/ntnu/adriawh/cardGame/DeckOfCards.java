package ntnu.adriawh.cardGame;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

public class DeckOfCards {
    private ArrayList<PlayingCard> cards;
    private final char[] suit = { 'S', 'H', 'D', 'C' };


    public DeckOfCards() {
        cards = new ArrayList<>();
        for (char c: suit) {
            for(int i = 0; i<13;i++){
                cards.add(new PlayingCard(c, i));
            }
        }
    }

    public ArrayList<PlayingCard> getCards() {
        return cards;
    }

    public ArrayList<PlayingCard> DealHand(int n) throws InvalidParameterException {
       if(n<1 ||n>52){
           throw new InvalidParameterException("Number must be bigger than 0, and smaller than 52");
       }else{
           ArrayList<PlayingCard> hand = new ArrayList<>();
           Random generator = new Random();
           for(int i = 0; i<n; i++){
               hand.add(cards.get(generator.nextInt()));
           }
           return hand;
       }
    }

    @Override
    public String toString() {
        return "DeckOfCards{" +
                "cards=" + cards +
                ", suit=" + Arrays.toString(suit) +
                '}';
    }
}