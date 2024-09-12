package cardAndDeck;

import characters.Character;

public abstract class Card {
	public abstract void doCardEffect(Character user, Character opponent);
}
