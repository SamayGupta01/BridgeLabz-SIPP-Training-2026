// Archer character class - Ranged attacker

public class Archer extends GameCharacter {
    private int accuracy;
    private int arrowCount;
    
    public Archer(String characterName) {
        super(characterName);
        this.accuracy = 95;
        this.arrowCount = 50;
    }
    
    @Override
    public void performAttack() {
        System.out.println("[ARCHER] Archer " + characterName + " shoots a RANGED ATTACK!");
        System.out.println("   -> Accuracy: " + accuracy + "%");
        System.out.println("   -> Arrows remaining: " + (arrowCount - 1));
        System.out.println("   -> Damage dealt: " + 75 + " HP");
        arrowCount--;
    }
    
    public int getAccuracy() {
        return accuracy;
    }
    
    public int getArrowCount() {
        return arrowCount;
    }
}
