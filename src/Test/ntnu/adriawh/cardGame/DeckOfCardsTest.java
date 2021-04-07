package ntnu.adriawh.cardGame;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsTest {


    @Test
    void DeckOfCards(){
        DeckOfCards deck = new DeckOfCards();
        ArrayList<PlayingCard> checkList = new ArrayList<>();
        boolean isNew = true;
        for(PlayingCard card : deck.getCards()){
            if(!checkList.contains(card)){
                checkList.add(card);
            }else{
                isNew = false;
                break;
            }
        }
        assert(isNew);
    }

    @Nested
    class DealHand{
        @Test
        void dealHandPositive() {
            DeckOfCards deck = new DeckOfCards();

            HandOfCards hand = deck.dealHand(5);
            assert(hand.getHandImages().size() == 5);
        }
        @Test
        void dealHandNegative() {
            DeckOfCards deck = new DeckOfCards();
            assertThrows(InvalidParameterException.class, ()-> deck.dealHand(2));
        }
    }

}