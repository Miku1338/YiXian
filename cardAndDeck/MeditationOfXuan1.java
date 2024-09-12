package cardAndDeck;

import buffsAndDebuffs.Buff;
import characters.Character;

public class MeditationOfXuan1 extends Card {

	@Override
	public void doCardEffect(Character user, Character opponent) {
		user.addBuff(Buff.REGEN_PER_TURN, 2);
		user.addBuff(Buff.INTERNAL_INJURY_PER_TURN, 2);
		user.addPhysique(2);
	}

}
