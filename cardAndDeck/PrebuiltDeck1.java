package cardAndDeck;

public class PrebuiltDeck1 extends Deck {

	public PrebuiltDeck1(Card[] cards) {
		super(cards);
	}

	public static Card[] getPrebuiltCards() {
		Card[] cards = new Card[] {new RepelCittaDarma3(), new RepelCittaDarma3(), new FallingPaperClouds3(), new SplashInk3(), new FallingPaperClouds3(), new SplashInk3(), new DragMoonInSea3(), new NormalAttack() };
		return cards;
	}
}
