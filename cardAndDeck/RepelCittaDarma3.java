package cardAndDeck;

import characters.Character;
import buffsAndDebuffs.Buff;

public class RepelCittaDarma3 extends Card {

	private boolean postActionEnabled = false;
	
	@Override
	public void doCardEffect(Character user, Character opponent) {
		if (!postActionEnabled) {
			user.addHpAndMaxHp(8);
			
			// The dealing damage from this is yet to be implemented.
			user.addBuff(Buff.REPELCD, 4);
		} else {
			Deck deck = user.getDeck();
			deck.advanceCard();
			deck.getNextCard().doCardEffect(user, opponent);
		}
	}

}
