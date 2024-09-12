package characters;

import cardAndDeck.Deck;
import cardAndDeck.HepstarSoulStat1;
import cardAndDeck.NormalAttack;

public class JiangXiming extends Character {
	private static final boolean HAS_IMMORTAL_FATE = true;
	
	public JiangXiming(Deck deck) {
		super(deck);
		if (HAS_IMMORTAL_FATE && deck.getCards()[7] instanceof NormalAttack) {
			deck.getCards()[7] = new HepstarSoulStat1();
		}
	}
	
}
