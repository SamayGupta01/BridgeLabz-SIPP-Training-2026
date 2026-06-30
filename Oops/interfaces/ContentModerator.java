package oops.interfaces;

/**
 * Problem 4: AI-Based Content Moderation Platform
 * Demonstrates interface abstraction with static methods and default methods
 * Interfaces: TextModeration, SpamDetection
 * Class: ContentModerator implements both interfaces
 */

// Interface 1: TextModeration
interface TextModeration {
    boolean checkForOffensiveContent(String post);
    
    default void displayModerationPolicy() {
        System.out.println("📋 Text Moderation Policy: Posts with offensive language will be flagged and may be removed.");
    }
    
    static boolean containsRestrictedWords(String post) {
        String[] restrictedWords = {"hate", "abuse", "violence", "discrimination", "bullying"};
        String lowerPost = post.toLowerCase();
        for (String word : restrictedWords) {
            if (lowerPost.contains(word)) {
                return true;
            }
        }
        return false;
    }
}

// Interface 2: SpamDetection
interface SpamDetection {
    boolean checkForSpam(String post);
    
    default void displayModerationPolicy() {
        System.out.println("🚫 Spam Detection Policy: Repetitive links, excessive hashtags, or promotional content will be marked as spam.");
    }
    
    static boolean containsRestrictedWords(String post) {
        String[] spamPatterns = {"buy now", "click here", "free money", "guaranteed", "limited offer"};
        String lowerPost = post.toLowerCase();
        for (String pattern : spamPatterns) {
            if (lowerPost.contains(pattern)) {
                return true;
            }
        }
        return false;
    }
}

// Class implementing both interfaces
class ContentModerationEngine implements TextModeration, SpamDetection {
    private String[] posts = {
        "Just finished an amazing workout! Feeling great 💪",
        "I hate all people who disagree with me",
        "Buy now! Click here for free money! Limited offer!!!",
        "Beautiful sunset at the beach today 🌅",
        "Check out my new blog post on productivity",
        "You are such a bully and deserve violence",
        "Click here for guaranteed riches! Act now!",
        "Having coffee with friends, what a lovely day ☕",
        "This product is amazing, 10/10 would recommend",
        "I'm disgusted by people who abuse animals"
    };
    
    @Override
    public boolean checkForOffensiveContent(String post) {
        return TextModeration.containsRestrictedWords(post);
    }
    
    @Override
    public boolean checkForSpam(String post) {
        boolean hasSpamPatterns = SpamDetection.containsRestrictedWords(post);
        boolean hasExcessiveHashtags = post.split("#").length > 4;
        return hasSpamPatterns || hasExcessiveHashtags;
    }
    
    // Resolving default method conflict
    @Override
    public void displayModerationPolicy() {
        System.out.println("\n========== CONTENT MODERATION POLICY ==========");
        TextModeration.super.displayModerationPolicy();
        SpamDetection.super.displayModerationPolicy();
        System.out.println("===============================================\n");
    }
    
    // Analyze all posts
    public void analyzeAllPosts() {
        System.out.println("\n========== POST ANALYSIS RESULTS ==========\n");
        
        int validPosts = 0;
        int offensivePosts = 0;
        int spamPosts = 0;
        
        for (String post : posts) {
            boolean isOffensive = checkForOffensiveContent(post);
            boolean isSpam = checkForSpam(post);
            
            String status;
            if (isOffensive) {
                status = "❌ OFFENSIVE";
                offensivePosts++;
            } else if (isSpam) {
                status = "⚠️  SPAM";
                spamPosts++;
            } else {
                status = "✅ VALID";
                validPosts++;
            }
            
            System.out.println(status);
            System.out.println("Post: " + post);
            System.out.println("Offensive: " + isOffensive + " | Spam: " + isSpam);
            System.out.println();
        }
        
        System.out.println("========== SUMMARY ==========");
        System.out.println("✅ Valid Posts: " + validPosts);
        System.out.println("⚠️  Spam Posts: " + spamPosts);
        System.out.println("❌ Offensive Posts: " + offensivePosts);
        System.out.println("Total Posts: " + posts.length);
        System.out.println("==============================\n");
    }
}

public class ContentModerator {
    public static void main(String[] args) {
        System.out.println("===== CONTENT MODERATION PLATFORM DEMO =====\n");
        
        ContentModerationEngine moderator = new ContentModerationEngine();
        
        // Display moderation policy
        System.out.println("1. Moderation Policy (Resolved default method conflict):");
        moderator.displayModerationPolicy();
        
        // Analyze all posts
        System.out.println("2. Analyzing posts for spam and offensive content:");
        moderator.analyzeAllPosts();
        
        System.out.println("\nKey Points Demonstrated:");
        System.out.println("✓ Multiple interface implementation");
        System.out.println("✓ Static methods in interfaces");
        System.out.println("✓ Default method conflict resolution");
        System.out.println("✓ Content classification (valid, spam, offensive)");
        System.out.println("✓ Moderation policy enforcement");
    }
}
