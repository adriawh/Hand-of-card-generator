package ntnu.adriawh.cardGame;

import javafx.scene.image.Image;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HandOfCardsTest {

    @Test
    void getHandImages() {
        ArrayList<PlayingCard> h = new ArrayList<>();
        h.add(new PlayingCard('S', 1));
        h.add(new PlayingCard('S', 2));
        h.add(new PlayingCard('S', 3));
        h.add(new PlayingCard('S', 4));
        h.add(new PlayingCard('S', 5));

        HandOfCards hand = new HandOfCards(h);

        assert(hand.getHandImages().size() == 5);
    }

    @Nested
    class getFlush{

        @Test
        void getFlushPositive(){
            ArrayList<PlayingCard> h = new ArrayList<>();
            h.add(new PlayingCard('S', 1));
            h.add(new PlayingCard('S', 2));
            h.add(new PlayingCard('S', 3));
            h.add(new PlayingCard('S', 4));
            h.add(new PlayingCard('S', 5));

            HandOfCards hand = new HandOfCards(h);

            assertEquals(hand.getFlush(), "yes");

        }
        @Test
        void getFlushNegative(){
            ArrayList<PlayingCard> h = new ArrayList<>();
            h.add(new PlayingCard('S', 1));
            h.add(new PlayingCard('S', 2));
            h.add(new PlayingCard('S', 3));
            h.add(new PlayingCard('S', 4));
            h.add(new PlayingCard('D', 5));

            HandOfCards hand = new HandOfCards(h);

            assertEquals(hand.getFlush(), "no");
        }
    }


    @Nested
    class getQueenOfSpades{
        @Test
        void getQueenOfSpadesPositive(){
            ArrayList<PlayingCard> h = new ArrayList<>();
            h.add(new PlayingCard('S', 1));
            h.add(new PlayingCard('S', 2));
            h.add(new PlayingCard('S', 3));
            h.add(new PlayingCard('S', 12));
            h.add(new PlayingCard('D', 5));

            HandOfCards hand = new HandOfCards(h);

            assertEquals(hand.getQueenOfSpades(), "yes");
        }
        @Test
        void getQueenOfSpadesNegative(){
            ArrayList<PlayingCard> h = new ArrayList<>();
            h.add(new PlayingCard('S', 1));
            h.add(new PlayingCard('S', 2));
            h.add(new PlayingCard('S', 3));
            h.add(new PlayingCard('S', 4));
            h.add(new PlayingCard('D', 5));

            HandOfCards hand = new HandOfCards(h);

            assertEquals(hand.getQueenOfSpades(), "no");
        }
    }

    @Test
    void getSumOfFaces() {
        ArrayList<PlayingCard> h = new ArrayList<>();
        h.add(new PlayingCard('S', 1));
        h.add(new PlayingCard('S', 2));
        h.add(new PlayingCard('S', 3));
        h.add(new PlayingCard('S', 4));
        h.add(new PlayingCard('H', 5));

        HandOfCards hand = new HandOfCards(h);

        assert(hand.getSumOfFaces() == 15);
    }

    @Test
    void getCardsOfHearts() {
        ArrayList<PlayingCard> h = new ArrayList<>();
        h.add(new PlayingCard('S', 1));
        h.add(new PlayingCard('S', 2));
        h.add(new PlayingCard('S', 3));
        h.add(new PlayingCard('S', 4));
        h.add(new PlayingCard('H', 5));

        HandOfCards hand = new HandOfCards(h);

        assertEquals(hand.getCardsOfHearts(), "H5  ");
    }
}