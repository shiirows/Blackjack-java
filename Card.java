

public class Card {
	
	//piche les valeur qui se trouvent dans Suit et Value.java

	private Suit suit;
	private Value value;
	
	public Card(Suit suit, Value value) {
		
		this.value = value;
		this.suit = suit;
	}
	
	// tout ce qui se situent dans suit et value son des String 
	public String toString() {
		return this.suit.toString() + "-" + this.value.toString();
	}
	
	public Value getValue() {
		return this.value;
	}
	
	
	
}
