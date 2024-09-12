package characters;

import cardAndDeck.Deck;
import model.GameplayConstants;

public class JiFangSheng extends Character {
	private static final boolean HAS_IMMORTAL_FATE = true;
	
	public JiFangSheng(Deck deck) {
		super(deck);
		maxPhysique = GameplayConstants.STARTING_MAX_PHYSIQUE;
		physique = GameplayConstants.STARTING_PHYSIQUE;
		if (HAS_IMMORTAL_FATE) {
			++physique;
		}
		maxHp += physique;
	}
	
	@Override
	public void addPhysique(int amount) {
		super.addPhysique(amount);
		if (HAS_IMMORTAL_FATE) {
			defense += amount;
		}
	}
	
}
