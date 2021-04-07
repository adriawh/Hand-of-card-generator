package ntnu.adriawh.cardGame;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class PlayingCardTest {

    @Test
    void getCardImage() {
        PlayingCard card = new PlayingCard('S', 1);
        assertNotNull(card.getCardImage());
    }
}