// Mage character class - Magic caster

public class Mage extends GameCharacter {
    private int manaPoints;
    private int spellPower;
    
    public Mage(String characterName) {
        super(characterName);
        this.manaPoints = 150;
        this.spellPower = 85;
    }
    
    @Override
    public void performAttack() {
        System.out.println("[MAGE] Mage " + characterName + " casts a MAGIC SPELL!");
        System.out.println("   -> Spell Power: " + spellPower);
        System.out.println("   -> Mana consumed: 30 | Remaining: " + (manaPoints - 30));
        System.out.println("   -> Damage dealt: " + (spellPower + 15) + " HP");
        manaPoints -= 30;
    }
    
    public int getManaPoints() {
        return manaPoints;
    }
    
    public int getSpellPower() {
        return spellPower;
    }
}
