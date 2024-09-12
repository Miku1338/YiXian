package cardAndDeck;

public class Deck {
	private final Card[] cards;
	private int cardPosition;
	
	public Deck(Card[] cards) {
		this.cards = cards;
		cardPosition = 0;
	}
	
	public Card[] getCards() {
		return cards;
	}
	
	public Card getNextCard() {
		Card c = cards[cardPosition];
		return c;
	}
	
	public void advanceCard() {
		cardPosition = (cardPosition + 1) % cards.length;
	}
}
