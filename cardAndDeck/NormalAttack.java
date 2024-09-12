package cardAndDeck;

import characters.Character;
import sim.BattleSim;

public class NormalAttack extends Card {

	@Override
	public void doCardEffect(Character user, Character opponent) {
		opponent.takeDamage(BattleSim.calculateModifiedDamage(3, user, opponent));
		
	}

}
