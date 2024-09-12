package cardAndDeck;

import characters.Character;

public class EvilNunRuptsprite2 extends Card {

	@Override
	public void doCardEffect(Character user, Character opponent) {
		user.loseQi(5);
		opponent.loseQi(5);
		
	}

}
