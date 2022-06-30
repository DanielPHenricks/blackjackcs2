package BlackJack;//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 


public abstract class Card
{
	public static final String[] FACES = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

	private String suit;
	private int face;
	private int value;
  	//constructors
	public Card(int face, String suit){
		if(face > 13 | face < 0) face = 1;
		this.face = face;
		this.suit = suit;
		this.value = -1;
	}

	public String getSuit() {
		return suit;
	}
	public int getFace(){
		return face;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

  	//accessors
	public void setValue(int v){
		this.value = v;
	}

  	public abstract int getValue();

	public boolean equals(Object obj) {
		return obj instanceof BlackJackCard &&
				(((BlackJackCard) obj).getSuit().equals(this.suit) &&
						((BlackJackCard) obj).getFace() == (this.face));

	}

  	//toString
  	public String toString() {
		return "" + (value == -1 ? getValue() : value);
	}

 }