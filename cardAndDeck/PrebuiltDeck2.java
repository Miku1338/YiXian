package cardAndDeck;

public class PrebuiltDeck2 extends Deck {

	public PrebuiltDeck2(Card[] cards) {
		super(cards);
	}
	
	public static Card[] getPrebuiltCards() {
		Card[] cards = new Card[] {new MeditationOfXuan1(), new EvilNunRuptsprite1(), new EvilNunRuptsprite2(), new EvilNunRuptsprite2(), new EvilNunRuptsprite2(), new EvilNunRuptsprite1(), new ConcentricTune3(), new ConcentricTune3() };
		return cards;
	}
}
