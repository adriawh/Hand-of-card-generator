package ntnu.adriawh;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import ntnu.adriawh.cardGame.DeckOfCards;
import ntnu.adriawh.cardGame.HandOfCards;

public class PrimaryController {

    @FXML
    public VBox showHand;
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

    /**
     * Method called when the user presses the deal hand button
     *
     * Generates a hand of card in the said size from the user.
     *
     * If the input is false, the user is alerted with a text
     *
     * Calls the checkHand() method
     */
    @FXML
    private void dealHand(){

        showHand.getChildren().clear();

        int handSize = Integer.parseInt(numberOfCards.getText());

        //Checks if the user input is within wanted limits
        if(handSize > 52 || handSize <5){
            numberOfCards.setText(null);
            numberOfCards.setPromptText("Number of cards must be lower than 52");
            Text t = new Text("False input, try again. \n Number of cards must be higher than 4 and lower than 52");
            showHand.getChildren().add(t);
            return;
        }

        hand = deck.dealHand(handSize);

        HBox h = new HBox();
        showHand.getChildren().add(h);

        //Sets the size of the cards based on the number of cards
        int count = 0;
        int width;
        if(handSize<=5) {
            width = 800/5;
        }else if(handSize<=15){
             width = 800/handSize;
        }else {
            width = 800/15; }

        for(Image i : hand.getHandImages()){
            if(count%15 == 0){
                h = new HBox();
                showHand.getChildren().add(h);
            }
            ImageView box = new ImageView(i);
            box.setPreserveRatio(true);
            box.setFitWidth(width);
            h.getChildren().add(box);
            count += 1;
        }

        checkHand();
    }

    /**
     * Checks the generated hand for different scenarios and prints them to the user
     */
    private void checkHand(){
        if(hand == null){
            return;
        }
        cardsOfHearts.setText(hand.getCardsOfHearts());
        sumOfFaces.setText(String.valueOf(hand.getSumOfFaces()));
        flush.setText(toText(hand.isFlush()));
        queenOfSpades.setText(toText(hand.containsQueenOfSpades()));

    }

    private String toText(boolean b){
        if(b){
            return "yes";
        }
        return "no";
    }
}
