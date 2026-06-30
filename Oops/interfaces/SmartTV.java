package oops.interfaces;

/**
 * Problem 3: Multi-Service Smart TV
 * Demonstrates multiple interface implementation and default method conflict resolution
 * Interfaces: StreamingService, GamingService
 * Class: SmartTV implements both interfaces
 */

// Interface 1: StreamingService
interface StreamingService {
    void playMovie(String movieName);
    
    default void showSubscriptionDetails() {
        System.out.println("📺 Streaming Service: Premium 4K Ultra HD - ₹299/month");
    }
}

// Interface 2: GamingService
interface GamingService {
    void playGame(String gameName);
    
    default void showSubscriptionDetails() {
        System.out.println("🎮 Gaming Service: Premium Games Library - ₹199/month");
    }
}

// Class implementing both interfaces - must resolve default method conflict
class SmartTVDevice implements StreamingService, GamingService {
    private String[] movies = {
        "Avengers: Endgame",
        "The Dark Knight",
        "Inception",
        "Avatar",
        "Interstellar",
        "The Matrix",
        "Gladiator"
    };
    
    private String[] games = {
        "Call of Duty: Modern Warfare",
        "Elden Ring",
        "Cyberpunk 2077",
        "The Legend of Zelda",
        "Fortnite",
        "FIFA 24",
        "Minecraft"
    };
    
    @Override
    public void playMovie(String movieName) {
        boolean found = false;
        for (String movie : movies) {
            if (movie.equalsIgnoreCase(movieName)) {
                System.out.println("🎬 Now Playing: " + movie);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("❌ Movie not available: " + movieName);
        }
    }
    
    @Override
    public void playGame(String gameName) {
        boolean found = false;
        for (String game : games) {
            if (game.equalsIgnoreCase(gameName)) {
                System.out.println("🕹️  Now Playing: " + game);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("❌ Game not available: " + gameName);
        }
    }
    
    // Resolving default method conflict - calling both parent implementations
    @Override
    public void showSubscriptionDetails() {
        System.out.println("\n========== SMART TV SUBSCRIPTIONS ==========");
        StreamingService.super.showSubscriptionDetails();
        GamingService.super.showSubscriptionDetails();
        System.out.println("Combined Package: ₹449/month - Save ₹49!");
        System.out.println("===========================================\n");
    }
    
    // Display available content
    public void displayAvailableContent() {
        System.out.println("\n========== AVAILABLE CONTENT ==========");
        
        System.out.println("\n📺 MOVIES:");
        for (int i = 0; i < movies.length; i++) {
            System.out.println((i + 1) + ". " + movies[i]);
        }
        
        System.out.println("\n🎮 GAMES:");
        for (int i = 0; i < games.length; i++) {
            System.out.println((i + 1) + ". " + games[i]);
        }
        System.out.println("\n=====================================\n");
    }
}

public class SmartTV {
    public static void main(String[] args) {
        System.out.println("===== SMART TV MULTI-SERVICE DEMO =====\n");
        
        SmartTVDevice tv = new SmartTVDevice();
        
        // Display available content
        tv.displayAvailableContent();
        
        // Show subscription details with resolved conflict
        System.out.println("1. Subscription Details (Default method conflict resolved):");
        tv.showSubscriptionDetails();
        
        // Stream movies
        System.out.println("2. Streaming Movies (StreamingService interface):");
        tv.playMovie("Inception");
        tv.playMovie("The Matrix");
        tv.playMovie("Avatar 2");
        
        System.out.println();
        
        // Play games
        System.out.println("3. Playing Games (GamingService interface):");
        tv.playGame("Elden Ring");
        tv.playGame("Minecraft");
        tv.playGame("GTA VI");
        
        System.out.println("\nKey Points Demonstrated:");
        System.out.println("✓ Multiple interface implementation");
        System.out.println("✓ Default method conflict resolution using super");
        System.out.println("✓ Both interfaces' default methods can be called");
        System.out.println("✓ Custom implementation combining both services");
    }
}
