package cardAndDeck;

import characters.Character;

public class ConcentricTune3 extends Card {

	@Override
	public void doCardEffect(Character user, Character opponent) {
		opponent.addAllDebuffs(user.getAllDebuffs());
		
	}

}
