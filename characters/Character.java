package characters;

import java.util.HashMap;
import java.util.Map;

import buffsAndDebuffs.Buff;
import buffsAndDebuffs.Debuff;
import cardAndDeck.Deck;
import model.GameplayConstants;

public abstract class Character {
	private int hp;
	int maxHp;
	private Map<Debuff, Integer> debuffs;
	private Map<Buff, Integer> buffs;
	private int qi;
	int physique;
	int maxPhysique;
	int defense;
	int guardUps;
	Deck deck;
	
	public Character(Deck deck) {
		maxHp = GameplayConstants.STARTING_HP;
		hp = maxHp;
		debuffs = new HashMap<>();
		buffs = new HashMap<>();
		qi = 0;
		physique = 0;
		maxPhysique = 0;
		defense = 0;
		guardUps = 0;
		this.deck = deck;
	}
	
	public void addHpAndMaxHp(int amount) {
		maxHp += amount;
		hp += amount;
	}
	
	public int getHP() {
		return hp;
	}
	
	public void addPhysique(int amount) {
		maxHp += amount;
		if (physique + amount >= maxPhysique) {
			addHp(physique + amount - maxPhysique - Math.min((maxPhysique - physique), 0));
		}
		physique += amount;
	}
	
	public void addHp(int amount) {
		hp += amount;
		if (hp > maxHp) {
			hp = maxHp;
		}
	}
	
	public Map<Buff, Integer> getBuffs() {
		return buffs;
	}
	
	public void takeDamage(int damage) {
		if (defense > 0) {
			defense -= damage;
			if (defense < 0) {
				if (guardUps > 0) {
					--guardUps;
				} else {
					hp += defense - getWounds();
				}
				defense = 0;
			}
		} else {
			takeUnblockableDamage(damage + getWounds());
		}
		
	}
	
	public void takeUnblockableDamage(int damage) {
		if (guardUps > 0) { 
			--guardUps;
		} else {
			hp -= damage;
		}
		
	}
	
	public Deck getDeck() {
		return deck;
	}
	
	public Map<Debuff, Integer> getAllDebuffs() {
		return debuffs;
	}
	
	private int getWounds() {
		if (debuffs.containsKey(Debuff.WOUND)) {
			return debuffs.get(Debuff.WOUND);
		} else {
			return 0;
		}
	}
	
	private int getInternalInjury() {
		if (debuffs.containsKey(Debuff.INTERNAL_INJURY)) {
			return debuffs.get(Debuff.INTERNAL_INJURY);
		} else {
			return 0;
		}
	}
	
	private int getRegenPerTurn() {
		if (buffs.containsKey(Buff.REGEN_PER_TURN)) {
			return buffs.get(Buff.REGEN_PER_TURN);
		} else {
			return 0;
		}
	}
	
	private int getInternalInjuryPerTurn() {
		if (buffs.containsKey(Buff.INTERNAL_INJURY_PER_TURN)) {
			return buffs.get(Buff.INTERNAL_INJURY_PER_TURN);
		} else {
			return 0;
		}
	}
	
	private int getRegen() {
		if (buffs.containsKey(Buff.REGENERATION)) {
			return buffs.get(Buff.REGENERATION);
		} else {
			return 0;
		}
	}
	
	public void addAllDebuffs(Map<Debuff, Integer> debuffs) {
		for (Debuff d : debuffs.keySet()) {
			addDebuff(d, debuffs.get(d));
		}
	}
	
	public void addDebuff(Debuff debuff, int value) {
		if (debuffs.containsKey(debuff)) {
			debuffs.put(debuff, debuffs.get(debuff) + value);
		} else {
			debuffs.put(debuff, value);
		}
	}
	
	public void addBuff(Buff buff, int value) {
		if (buffs.containsKey(buff)) {
			buffs.put(buff, buffs.get(buff) + value);
		} else {
			buffs.put(buff, value);
		}
	}
	
	public void gainQi(int amount) {
		qi += amount;
	}
	
	public void loseQi(int amount) {
		qi -= amount;
		if (qi < 0) {
			qi = 0;
		}
	}
	
	public boolean hasEnoughQi(int requirement) {
		return qi >= requirement;
	}

	public void addDefense(int d) {
		defense += d;
		
	}

	public void addGuardUps(int g) {
		guardUps += g;
		
	}
	
	public void endTurn() {
		defense /= 2;
		addHp(getRegen());
		takeUnblockableDamage(getInternalInjury());
		addBuff(Buff.REGENERATION, getRegenPerTurn());
		addDebuff(Debuff.INTERNAL_INJURY, getInternalInjuryPerTurn());
		removeDebuff(Debuff.FLAW, 1);
		removeDebuff(Debuff.ENTANGLED, 1);
		removeDebuff(Debuff.WEAKENED, 1);
	}

	private void removeDebuff(Debuff debuff, int i) {
		if (debuffs.containsKey(debuff) && debuffs.get(debuff) > 0) {
			debuffs.put(debuff, debuffs.get(debuff) - 1);
		}
		
	}
	
	public void removeBuff(Buff buff, int i) {
		if (buffs.containsKey(buff) && buffs.get(buff) > 0) {
			buffs.put(buff, buffs.get(buff) - 1);
		}
	}
}
