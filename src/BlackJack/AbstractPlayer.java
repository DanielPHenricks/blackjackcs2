package BlackJack;//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import java.util.ArrayList;
import java.util.LinkedList;

import BlackJack.Card;

public abstract class AbstractPlayer implements Playerable {
    private ArrayList<Card> hand;
    private int winCount;

    //constructors
    public AbstractPlayer() {
        this.hand = new ArrayList<Card>();
        this.winCount = 0;
    }

    public void addCardToHand(Card temp) {
        hand.add(temp);
    }

    public void resetHand() {
        hand.clear();
    }

    public void setWinCount(int numwins) {
        this.winCount = numwins;
    }

    public int getWinCount() {
        return this.winCount;
    }

    public int getHandSize() {
        return hand.size();
    }

    public int getHandValue() {
        //great example of polymorphism
        int total = 0;
        LinkedList<Card> aces = new LinkedList<>();
        for (Card c: hand) {
            if(c.getValue() == 1) aces.add(c);
            total += c.getValue();
        }
        //System.out.println(aces);
        while(total <= 11 && !aces.isEmpty()){
            Card ace = aces.remove();
            ace.setValue(11);
            total += 10;
        }
        return total;
    }

    public String toString() {
        return hand.toString();
    }
}