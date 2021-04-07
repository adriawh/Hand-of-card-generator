package ntnu.adriawh.cardGame;

import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class HandOfCards {

    private final ArrayList<PlayingCard> hand;

    public HandOfCards(ArrayList<PlayingCard> hand){
        hand.sort(Comparator.comparing(PlayingCard::getAsString));
        this.hand = hand;
    }

    public ArrayList<Image> getHandImages(){
        return (ArrayList<Image>) hand.stream().map(PlayingCard::getCardImage).collect(Collectors.toList());
    }

    public String getFlush() {
        char[] suit = { 'S', 'H', 'D', 'C' };
        for(char c : suit){
            if(hand.stream()
                    .filter(playingCard -> Character.toString(playingCard.getSuit()).equals(Character.toString(c)))
                    .count() >= 5){
                return "yes";
            }
        }
        return "no";
    }

    public String getQueenOfSpades() {
        if(hand.stream().anyMatch(playingCard -> playingCard.getAsString().equals("S12"))){
            return "yes";
        }else {
            return "no";
        }
    }

    public int getSumOfFaces() {
       return hand.stream().mapToInt(PlayingCard::getFace).sum();
    }

    public String getCardsOfHearts() {
       ArrayList<PlayingCard> cardsOfHearts = (ArrayList<PlayingCard>)hand.stream()
               .filter(playingCard -> Character.toString(playingCard.getSuit()).equals("H"))
               .collect(Collectors.toList());

       if(cardsOfHearts.size() < 1){
            return "no cards";
        }

        StringBuilder result = new StringBuilder();
        for(PlayingCard p : cardsOfHearts){
            result.append(p.getAsString()).append("  ");
        }
        return result.toString();
    }
}
