package ntnu.adriawh.cardGame;

import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Class to represent a hand of n number of cards
 */
public class HandOfCards {

    private final ArrayList<PlayingCard> hand;

    /**
     * Constructor that takes in the hand given from the deck of cards and sorts them
     *
     * @param hand arrayList of cards that is to be the hand
     */
    public HandOfCards(ArrayList<PlayingCard> hand){
        hand.sort(Comparator.comparing(PlayingCard::getAsString));
        this.hand = hand;
    }

    /**
     * Method for getting the individual images in the hand
     *
     * @return the image files of the cards in hand
     */
    public ArrayList<Image> getHandImages(){
        return (ArrayList<Image>) hand.stream().map(PlayingCard::getCardImage).collect(Collectors.toList());
    }

    /**
     * Checks if the hand contains a flush.
     * A hand contains a flush when it contains 5 cards of the same suit
     *
     * @return yes or no
     */
    public boolean isFlush() {
        char[] suit = { 'S', 'H', 'D', 'C' };
        for(char c : suit){
            if(hand.stream()
                    .filter(playingCard -> Character.toString(playingCard.getSuit()).equals(Character.toString(c)))
                    .count() >= 5){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the hand contains the queen of spades(S13)
     *
     * @return yes or no
     */
    public boolean containsQueenOfSpades() {
        return hand.stream().anyMatch(playingCard -> playingCard.getAsString().equals("S12"));
    }

    /**
     * Adds up the sum of the faces in the hand
     *
     * @return sum of the faces
     */
    public int getSumOfFaces() {
       return hand.stream().mapToInt(PlayingCard::getFace).sum();
    }

    /**
     * Finds all cards og heart in the hand
     * @return returns a string of the cards of hearts
     */
    public String getCardsOfHearts() {
       ArrayList<PlayingCard> cardsOfHearts = (ArrayList<PlayingCard>)hand.stream()
               .filter(playingCard -> Character.toString(playingCard.getSuit()).equals("H"))
               .collect(Collectors.toList());

       if(cardsOfHearts.size() < 1) return "no cards";

       return cardsOfHearts.stream().map(p -> p.getAsString() + "  ").collect(Collectors.joining());
    }


    @Override
    public String toString() {
        return "HandOfCards{" +
                "hand=" + hand +
                '}';
    }
}
