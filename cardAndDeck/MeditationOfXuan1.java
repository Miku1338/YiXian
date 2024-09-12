package cardAndDeck;

import buffsAndDebuffs.Buff;
import characters.Character;

public class MeditationOfXuan1 extends Card {

	private boolean postActionEnabled = false;
	
	@Override
	public void doCardEffect(Character user, Character opponent) {
		if (!postActionEnabled) {
			user.addBuff(Buff.REGEN_PER_TURN, 2);
			user.addBuff(Buff.INTERNAL_INJURY_PER_TURN, 2);
			user.addPhysique(2);
			postActionEnabled = true;
		} else {
			Deck deck = user.getDeck();
			deck.advanceCard();
			deck.getNextCard().doCardEffect(user, opponent);
		}

	}

}
