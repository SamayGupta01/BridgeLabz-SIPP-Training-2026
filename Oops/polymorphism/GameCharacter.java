// Problem 3: Adventure Game Character System
// Superclass GameCharacter

public abstract class GameCharacter {
    protected String characterName;
    protected int healthPoints;
    
    public GameCharacter(String characterName) {
        this.characterName = characterName;
        this.healthPoints = 100;
    }
    
    // Abstract method - each character attacks differently
    public abstract void performAttack();
    
    public String getCharacterName() {
        return characterName;
    }
    
    public int getHealthPoints() {
        return healthPoints;
    }
    
    public void takeDamage(int damage) {
        this.healthPoints -= damage;
        if (healthPoints < 0) {
            healthPoints = 0;
        }
    }
    
    public boolean isAlive() {
        return healthPoints > 0;
    }
}
