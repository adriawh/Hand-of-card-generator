package ntnu.adriawh;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import ntnu.adriawh.cardGame.DeckOfCards;
import ntnu.adriawh.cardGame.HandOfCards;

public class PrimaryController {

    @FXML
    private Text handOfCards;
    @FXML
    private TextField numberOfCards;
    @FXML
    private Text cardsOfHearts;
    @FXML
    private Text sumOfFaces;
    @FXML
    private Text flush;
    @FXML
    private Text queenOfSpades;

    private final DeckOfCards deck = new DeckOfCards();
    private HandOfCards hand;


    @FXML
    private void dealHand(){
        int handSize = Integer.parseInt(numberOfCards.getText());
        if(handSize > 52){
            numberOfCards.setText(null);
            numberOfCards.setPromptText("Number of cards must be lower than 52");
        }
        hand = deck.DealHand(handSize);
        handOfCards.setText(hand.getHand());
    }

    @FXML
    private void checkHand(){
        if(hand == null){
            return;
        }
        cardsOfHearts.setText(hand.getCardsOfHearts());
        sumOfFaces.setText(hand.getSumOfFaces());
        flush.setText(hand.getFlush());
        queenOfSpades.setText(hand.getQueenOfSpades());
    }

}
