package com.wildcodeschool;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	
	
	private ArrayList<Card> cards;
	
	//construct
	public Deck() {
		this.cards = new  ArrayList<Card>(); 
	}

	public void createFullDeck() {
		//on genere les cartes 
		
		for(Suit cardSuit : Suit.values()) {
			for(Value cardValue : Value.values()) {
				//add a new card to the mix
				this.cards.add(new Card(cardSuit,cardValue));
				
			}
		}
	}
	
	// creation du Deck aleatoire
	public void shuffle() {
		ArrayList<Card> tmpDeck = new ArrayList<Card>();
		// use random
		Random random = new Random();
		int rendomCardIndex = 0;
		int originalSize = this.cards.size();
		for(int i = 0; i < originalSize; i++) {
			//generate Random index rand.nextInt ((max - min) + 1) + min;
			rendomCardIndex = random.nextInt((this.cards.size()-1 - 0) + 1) + 0;
			tmpDeck.add(this.cards.get(rendomCardIndex));
			//remove from original deck
			this.cards.remove(rendomCardIndex);
			
			
		}
		this.cards = tmpDeck;
		
	}
	//
	public String toString() {
		String cardListOutput = "";
		for(Card aCard : this.cards) {
			cardListOutput += "/n " + aCard.toString();
			
		}
		return cardListOutput;
	}
	
	public void removeCard(int i) {
		this.cards.remove(i);
	}
	
	public Card getCard(int i) {
		return this.cards.get(i);
	}
	
	public void addCard(Card addCard) {
		this.cards.add(addCard);
	}
	
	public void draw(Deck comingFrom) {
		this.cards.add(comingFrom.getCard(0));
		comingFrom.removeCard(0);
		
	}
	
	public int deckSize() {
		return this.cards.size();
	}
	
	public void moveALLtoDeck(Deck moveTo) {
		int thisDeckSize = this.cards.size();
		
		//put cards into movto deck
		for(int i = 0; i < thisDeckSize; i++) {
			moveTo.addCard(this.getCard(i));
		}
		
		for(int i = 0; i < thisDeckSize; i++) {
			this.removeCard(0);
		}
	}
	
	
	
	//return total value of cards in deck
	public int cardsValue(){
		int totalValue = 0;
		int aces = 0;
		
		for(Card aCard : this.cards) {
			switch(aCard.getValue()) {
			case Two: totalValue += 2; break;
			case Three: totalValue += 3; break;
			case Four: totalValue += 4; break;
			case Five: totalValue += 5; break;
			case Six: totalValue += 6; break;
			case Seven: totalValue += 7; break;
			case Eight: totalValue += 8; break;
			case Nine: totalValue += 9; break;
			case Ten: totalValue += 10; break;
			case Jack: totalValue += 10; break;
			case King: totalValue += 10; break;
			case Queen: totalValue += 10; break;
			case Ace: aces += 1; break;
			}
		}
		
		
		for(int i = 0; i < aces; i++) {
			
			if(totalValue > 10) {
				totalValue += 1;
				
			}else {
				totalValue += 11;
			}
		}
		
		return totalValue;
	}
	
	
}

