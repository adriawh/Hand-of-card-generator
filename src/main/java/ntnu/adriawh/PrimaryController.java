package ntnu.adriawh;

import java.io.IOException;
import javafx.fxml.FXML;
import ntnu.adriawh.cardGame.DeckOfCards;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    @FXML
    private void dealHand() throws IOException {

    }
}
