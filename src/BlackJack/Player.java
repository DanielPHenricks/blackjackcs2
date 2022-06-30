package BlackJack;//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;
import java.util.Scanner;



//define Player class here 
public class Player extends AbstractPlayer {
    private Deck d;

    public Player(){
        super();
    }

    public void setDeck(Deck d){
        this.d = d;
    }

    public boolean hit() {
        Card c = d.nextCard();
        addCardToHand(c);
        return getHandValue() <= 21;
    }
}