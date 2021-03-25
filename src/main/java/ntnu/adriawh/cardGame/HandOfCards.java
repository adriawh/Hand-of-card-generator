package ntnu.adriawh.cardGame;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class HandOfCards {

    private final ArrayList<PlayingCard> hand;

    public HandOfCards(ArrayList<PlayingCard> hand){
        this.hand = hand;
    }

    public String getHand(){
        StringBuilder result = new StringBuilder();
        for(PlayingCard p : hand){
            result.append(p.getAsString()).append("  ");
        }
        return result.toString();
    }

    public String getFlush() {
        char[] suit = { 'S', 'H', 'D', 'C' };
        for(char c : suit){
            if(hand.stream().filter(playingCard -> Character.toString(playingCard.getSuit()).equals(Character.toString(c))).count() >= 5){
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

    public String getSumOfFaces() {
       return String.valueOf(hand.stream().mapToInt(PlayingCard::getFace).sum());
    }

    public String getCardsOfHearts() {
       ArrayList<PlayingCard> cardsOfHearts = (ArrayList<PlayingCard>)hand.stream().filter(playingCard -> Character.toString(playingCard.getSuit()).equals("H")).collect(Collectors.toList());

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
