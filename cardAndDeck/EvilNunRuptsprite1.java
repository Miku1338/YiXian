package cardAndDeck;

import characters.Character;

public class EvilNunRuptsprite1 extends Card {

	@Override
	public void doCardEffect(Character user, Character opponent) {
		user.loseQi(3);
		opponent.loseQi(3);
		
	}

}
