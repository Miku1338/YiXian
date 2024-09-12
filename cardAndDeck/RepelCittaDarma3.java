package cardAndDeck;

import characters.Character;
import buffsAndDebuffs.Buff;

public class RepelCittaDarma3 extends Card {

	@Override
	public void doCardEffect(Character user, Character opponent) {
		user.addHpAndMaxHp(8);
		
		// The dealing damage from this is yet to be implemented.
		user.addBuff(Buff.REPELCD, 4);
	}

}
