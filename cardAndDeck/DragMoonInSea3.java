package cardAndDeck;

import buffsAndDebuffs.Debuff;
import characters.Character;
import sim.BattleSim;

public class DragMoonInSea3 extends Card {

	boolean postActionEnabled = false;
	
	@Override
	public void doCardEffect(Character user, Character opponent) {
		if (postActionEnabled) {
			opponent.takeDamage(BattleSim.calculateModifiedDamage(24, user, opponent));
			if (user.isEntangled()) {
				user.removeDebuff(Debuff.ENTANGLED, 1);
			} else {
				Deck deck = user.getDeck();
				deck.advanceCard();
				deck.getNextCard().doCardEffect(user, opponent);
			}
		} else {
			postActionEnabled = true;
		}
		
	}

}
