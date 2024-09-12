package cardAndDeck;

import buffsAndDebuffs.Buff;
import characters.Character;

public class HepstarSoulStat1 extends Card {

	@Override
	public void doCardEffect(Character user, Character opponent) {
		opponent.takeUnblockableDamage(4);
		opponent.addBuff(Buff.MISS_TURN, 1);

	}

}
