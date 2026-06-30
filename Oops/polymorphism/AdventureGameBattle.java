// Problem 3: Adventure Game Battle System Demo
// Demonstrates polymorphic attacks and battle mechanics

public class AdventureGameBattle {
    
    public static void startBattle(GameCharacter[] characters) {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║       ADVENTURE GAME - BATTLE STARTED    ║");
        System.out.println("╚══════════════════════════════════════════╝\n");
        
        int roundNumber = 1;
        int warriorCount = 0, mageCount = 0, archerCount = 0;
        
        // First, display participant information
        System.out.println("[BATTLE] Battle Participants:");
        for (GameCharacter character : characters) {
            System.out.print("   • " + character.getCharacterName() + " (" + 
                           character.getClass().getSimpleName() + ") - ");
            
            if (character instanceof Warrior) {
                System.out.println("HP: " + character.getHealthPoints());
                warriorCount++;
            } else if (character instanceof Mage) {
                System.out.println("HP: " + character.getHealthPoints());
                mageCount++;
            } else if (character instanceof Archer) {
                System.out.println("HP: " + character.getHealthPoints());
                archerCount++;
            }
        }
        
        System.out.println("\n--- ROUND " + roundNumber + " ---");
        
        // Polymorphic method dispatch - each character attacks differently
        for (GameCharacter character : characters) {
            if (character.isAlive()) {
                character.performAttack();
                System.out.println();
            }
        }
        
        // Battle Summary
        System.out.println("=========================================================");
        System.out.println("          BATTLE PARTICIPATION SUMMARY");
        System.out.println("=========================================================");
        System.out.println("Total Participants: " + characters.length);
        System.out.println("[WARRIOR] Warriors: " + warriorCount);
        System.out.println("[MAGE] Mages: " + mageCount);
        System.out.println("[ARCHER] Archers: " + archerCount);
    }
    
    public static void main(String[] args) {
        // Create different game characters
        GameCharacter[] characters = {
            new Warrior("Aragorn"),
            new Mage("Gandalf"),
            new Archer("Legolas"),
            new Warrior("Boromir"),
            new Mage("Saruman"),
            new Archer("Gollum's Nemesis")
        };
        
        // Start the battle - polymorphic calls
        startBattle(characters);
    }
}
