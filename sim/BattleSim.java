package sim;

import characters.Character;
import characters.JiFangSheng;
import characters.JiangXiming;
import buffsAndDebuffs.Buff;
import buffsAndDebuffs.Debuff;
import cardAndDeck.Deck;
import cardAndDeck.PrebuiltDeck1;
import cardAndDeck.PrebuiltDeck2;

public class BattleSim {
	public static final double WEAKENED_MULTIPLIER = 0.4;
	public static final double FLAW_MULTIPLIER = 0.4;
	public static void main(String[] args) {
		int jiangXimingWins = 0;
		int jiFangshengWins = 0;
		for (int trials = 0; trials < 1000000; ++trials) {
			Deck d1 = new PrebuiltDeck1(PrebuiltDeck1.getPrebuiltCards());
			Deck d2 = new PrebuiltDeck1(PrebuiltDeck2.getPrebuiltCards());
			Character c1 = new JiangXiming(d1);
			Character c2 = new JiFangSheng(d2);
			for (int i = 0; i < 32; ++i) {
				if (c1.getBuffs().containsKey(Buff.MISS_TURN) && c1.getBuffs().get(Buff.MISS_TURN) > 0) {
					c1.removeBuff(Buff.MISS_TURN, 1);
				} else {
					c1.getDeck().getNextCard().doCardEffect(c1, c2);
				}
				if (c1.getHP() <= 0 || c2.getHP() <= 0) {
					break;
				}
				c1.endTurn();
				if (c1.getHP() <= 0 || c2.getHP() <= 0) {
					break;
				}
				if (c2.getBuffs().containsKey(Buff.MISS_TURN) && c2.getBuffs().get(Buff.MISS_TURN) > 0) {
					c2.removeBuff(Buff.MISS_TURN, 1);
				} else {
					c2.getDeck().getNextCard().doCardEffect(c2, c1);
				}
				if (c1.getHP() <= 0 || c2.getHP() <= 0) {
					break;
				}
				c2.endTurn();
				if (c1.getHP() <= 0 || c2.getHP() <= 0) {
					break;
				}
			}
			if (c1.getHP() >= c2.getHP()) {
				++jiangXimingWins;
			} else {
				++jiFangshengWins;
			}
		}
		System.out.println("Jiang Ximing win % = " + (jiangXimingWins * 1.0 / (jiangXimingWins + jiFangshengWins)));
	}
	
	public static int calculateModifiedDamage(int damage, Character user, Character opponent) {
		double damage_multiplier = 1.0;
		if (user.getAllDebuffs().containsKey(Debuff.WEAKENED) && user.getAllDebuffs().get(Debuff.WEAKENED) > 0) {
			damage_multiplier -= WEAKENED_MULTIPLIER;
		}
		if (opponent.getAllDebuffs().containsKey(Debuff.FLAW) && opponent.getAllDebuffs().get(Debuff.FLAW) > 0) {
			damage_multiplier += FLAW_MULTIPLIER;
		}
		if (user.getAllDebuffs().containsKey(Debuff.DECREASE_ATTACK)) {
			damage -= user.getAllDebuffs().get(Debuff.DECREASE_ATTACK);
		}
		if (user.getBuffs().containsKey(Buff.INCREASED_ATTACK)) {
			damage += user.getBuffs().get(Buff.INCREASED_ATTACK);
		}
		return (int) (damage * damage_multiplier);
	}
}
