package BlackJack;//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    public static final int NUMFACES = 13;
    public static final int NUMSUITS = 4;
    public static final int NUMCARDS = 52;

    public static final String[] SUITS = {"CLUBS", "SPADES", "DIAMONDS", "HEARTS"};

    private static int topCardIndex;
    private ArrayList<Card> stackOfCards;

    public Deck() {
        //initialize data - stackOfCards - topCardIndex
        stackOfCards = new ArrayList<Card>();
        topCardIndex = NUMFACES * NUMSUITS - 1;
        for (String s : SUITS) {
            for (int i = 1; i <= NUMFACES; i++) {
                stackOfCards.add(new BlackJackCard(i, s));
            }
        }
        shuffle();
    }

    //modifiers
    public void shuffle() {
        topCardIndex = 51;
        Collections.shuffle(stackOfCards);
    }

    public int size() {
        return stackOfCards.size();
    }

    public int numCardsLeft() {
        return topCardIndex + 1;
    }

    public Card nextCard() {
        return stackOfCards.get(topCardIndex--);
    }

    public String toString() {
        return stackOfCards + "   topCardIndex = " + topCardIndex;
    }
}