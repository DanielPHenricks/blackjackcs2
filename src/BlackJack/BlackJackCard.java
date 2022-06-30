package BlackJack;//� A- Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

public class BlackJackCard extends Card
{
  	//constructors
	public BlackJackCard() {
		super(0, "");
	}
	public BlackJackCard(int num, String suit){
		super(num, suit);
	}
  	public int getValue() {
		return Math.min(getFace(), 10);
	}
 }