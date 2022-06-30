package BlackJack;//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 


//define Dealer class here
public class Dealer extends AbstractPlayer{
    private Deck deck;
    private Player p;
    public Dealer(){
        super();
        deck = new Deck();
        p = new Player();
        p.setDeck(deck);
    }
    public void shuffle(){
        deck.shuffle();
    }
    public Card deal(){
        if(deck.numCardsLeft()> 0){
            return deck.nextCard();
        }
        else {
            deck.shuffle();
            return deal();
        }

    }
    public boolean hit() {
        Card c = deck.nextCard();
        addCardToHand(c);
        return getHandValue() <= 21;
    }
}
