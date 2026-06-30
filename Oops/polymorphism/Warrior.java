// Warrior character class - Close combat fighter

public class Warrior extends GameCharacter {
    private int strength;
    
    public Warrior(String characterName) {
        super(characterName);
        this.strength = 90;
    }
    
    @Override
    public void performAttack() {
        System.out.println("[WARRIOR] Warrior " + characterName + " performs a MELEE ATTACK!");
        System.out.println("   -> Uses sword with strength: " + strength);
        System.out.println("   -> Damage dealt: " + (strength - 10) + " HP");
    }
    
    public int getStrength() {
        return strength;
    }
}
