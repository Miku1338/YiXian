package cardAndDeck;

import java.util.Random;

import characters.Character;
import buffsAndDebuffs.Debuff;

public class SplashInk3 extends Card {

	private static final Random r = new Random();
	
	@Override
	public void doCardEffect(Character user, Character opponent) {
		Debuff[] allDebuffs = Debuff.allDebuffs;
		int randomInt = r.nextInt(allDebuffs.length);
		opponent.addDebuff(allDebuffs[randomInt], 4);
		
	}

}
