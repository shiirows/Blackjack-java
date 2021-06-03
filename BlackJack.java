package com.wildcodeschool;

import java.util.Scanner;

import javax.swing.JFrame;

public class BlackJack extends JFrame {
	
	
	private static final long serialVersionUID = 6094889031438363682L;
	
	public BlackJack() {
		super("my first swing application");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public static void main (String[] args) {
		BlackJack blackJack = new BlackJack();
		blackJack.setVisible(true);
	
	
	 Deck playingDeck = new Deck();
		playingDeck.createFullDeck();
		playingDeck.shuffle();
		//create a deck for the player
		Deck playerDeck = new Deck();
		
		Deck dealerDeck = new Deck();
		
		double playerMoney = 100.00;
		
		Scanner userInput = new Scanner(System.in);
		
		
		while(playerMoney > 0) {
			//play on!
			//take the players bet
			System.out.println("tu a $" + playerMoney + ", combien voudriez-vous parier?");
			double playerBet = userInput.nextDouble();
			while (playerBet >  playerMoney) {
				System.out.println("vous ne pouvez pas parier plus que ce que vous avez. s'il vous plaît, partez." );
				System.out.println("tu a $" + playerMoney + ", combien voudriez-vous parier?");
				 playerBet = userInput.nextDouble();
				 
			}
			
			boolean endRound = false;
			//start Dealing
			//player gets two cards
			
			playerDeck.draw(playingDeck);
			playerDeck.draw(playingDeck);
			
			//Dealer gets two card 
			
			dealerDeck.draw(playingDeck);
			dealerDeck.draw(playingDeck);
			
			while(true) {
				System.out.println("ta main:");
				System.out.println(playerDeck.toString());
				System.out.println("votre deck est évalué à : " + playerDeck.cardsValue());
				
				//display Dealer Hand
				System.out.println("main du Croupier : " + dealerDeck.getCard(0).toString() + " and [hidden]");
				
				// what does the player want to do?
				System.out.println("voudriez-vous une nouvelle carte (1) ou rester debout (2)?");
				int response = userInput.nextInt();
				
				// they hit
				if(response == 1) {
					playerDeck.draw(playingDeck);
					System.out.println("you draw a :" + playerDeck.getCard(playerDeck.deckSize()-1));
					//bust if < 21
					if(playerDeck.cardsValue() > 21)  {
						System.out.println("perdu " + playerDeck.cardsValue());
						playerMoney -= playerBet;
						
						endRound = true;
						if(response ==1 ) {
							break;}
						
					}
				}
				
				if(response ==2 ) {
					break;
					
				}

			}
			
			System.out.println("carte du croupier:" + dealerDeck.toString());
			//see if dealer has more points than player
			if((dealerDeck.cardsValue() > playerDeck.cardsValue()) && endRound == false) {
				System.out.println("Le croupier vous bat !");
				playerMoney -= playerBet;
				endRound = true;
			}
			// Dealer Draws at 16, stand at 17
			while((dealerDeck.cardsValue() < 17) && endRound == false) {
				dealerDeck.draw(playingDeck);
				System.out.println("Tirage au sort du croupier : " + dealerDeck.getCard(dealerDeck.deckSize()-1).toString());
			}
			//Display Total Value for Dealer
			System.out.println("La main du croupier vaut : " + dealerDeck.cardsValue());
			if((dealerDeck.cardsValue() > 21)&& endRound == false) {
				System.out.println("défaite de croupier! Vous gagnez.");
				playerMoney += playerBet;
				endRound = true;
			}
			
			//determine if push 
			if((playerDeck.cardsValue() == dealerDeck.cardsValue()) && endRound == false) {
				System.out.println("push");
				endRound = true;
			}
			
			if((playerDeck.cardsValue() > dealerDeck.cardsValue()) && endRound == false) {
				System.out.println("vous gagnez la main !");
				playerMoney += playerBet;
				endRound = true;
			}
			
			playerDeck.moveALLtoDeck(playingDeck);
			dealerDeck.moveALLtoDeck(playingDeck);
			System.out.println("end of hand.");
			
			
			
			
			

		}
		
		System.out.println("jeu terminé! tu es a cours d'argent. :(" );
		
		
		
}
}
