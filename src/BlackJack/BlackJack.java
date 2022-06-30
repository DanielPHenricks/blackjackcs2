package BlackJack;//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;

import java.sql.SQLOutput;
import java.util.Scanner;

public class BlackJack
{
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_GREEN = "\u001B[32m";
	private Player player;
	private Dealer dealer;
	int funds = 1000;

	public BlackJack() {
		player = new Player();
		dealer = new Dealer();
	}

	public void playGame() {
		Scanner keyboard = new Scanner(System.in);
		do{
			int stake = 100;
			funds -= stake;
			boolean playerCanHit = true;
			player.addCardToHand(dealer.deal());
			Card temp = dealer.deal();
			out.println("Dealer top card: " + temp);
			dealer.addCardToHand(temp);
			player.addCardToHand(dealer.deal());
			dealer.addCardToHand(dealer.deal());
			while(playerCanHit){
				out.println("1 to hit, 2 to stand, 3 to double.");
				out.println("Your hand total is " + player.getHandValue());
				out.println("Your hand: " + player);
				int choice = keyboard.nextInt();
				if(choice == 1) {
					player.addCardToHand(dealer.deal());
					if(player.getHandValue() >= 21) playerCanHit = false;
				}
				else if(choice == 3){
					funds -= stake;
					stake *= 2;
					player.addCardToHand(dealer.deal());
					playerCanHit = false;
				}
				else playerCanHit = false;
			}
			while(dealer.getHandValue() < 17) dealer.hit();
			out.println(dealer);
			int pVal = player.getHandValue();
			int dVal = dealer.getHandValue();
			out.println("Player had " + pVal + "\n" + "Dealer had " + dVal);
			int winner = (pVal != dVal ?
					(pVal <= 21 && pVal > dVal ||
							(dVal >21 && pVal <=21) ?
							1 : 2) : 3);
			if(winner == 1) {
				funds += 2 * stake;
				if(player.getHandSize() == 2 && player.getHandValue() == 21) funds += (int)(.5 * stake);
			}
			if(winner == 3) funds += stake;
			if(funds >= 1000){
				System.out.println(ANSI_GREEN + funds + ANSI_RESET);
			}
			else System.out.println(ANSI_RED + funds + ANSI_RESET);
			player.resetHand();
			dealer.resetHand();

		}
		while(true);
	}
	
	public static void main(String[] args)
	{
		BlackJack game = new BlackJack();
		game.playGame();
	}
}