package cardAndDeck;

import java.util.Random;

import characters.Character;

public class FallingPaperClouds3 extends Card {

	private static final Random r = new Random();
	
	@Override
	public void doCardEffect(Character user, Character opponent) {
		int effect = r.nextInt(3);
		if (effect == 0) {
			user.addDefense(34);
		} else if (effect == 1) {
			user.addHp(26);
		} else {
			user.addGuardUps(3);
		}
		
	}

}
