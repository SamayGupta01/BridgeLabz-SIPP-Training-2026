import java.util.LinkedList;
import java.util.Scanner;

public class MusicPlaylistRecommendationEngine {
    private static final int LIMIT = 10;
    private static final LinkedList<String> recentlyPlayed = new LinkedList<>();

    public static void playSong(String song) {
        recentlyPlayed.remove(song);
        recentlyPlayed.addFirst(song);

        if (recentlyPlayed.size() > LIMIT) {
            String removedSong = recentlyPlayed.removeLast();
            System.out.println("Removed oldest song: " + removedSong);
        }

        System.out.println("Song added to recently played.");
    }

    public static void searchSong(String song) {
        if (recentlyPlayed.contains(song)) {
            System.out.println("Song exists in recently played history.");
        } else {
            System.out.println("Song not found.");
        }
    }

    public static void displayRecentlyPlayed() {
        if (recentlyPlayed.isEmpty()) {
            System.out.println("Recently played list is empty.");
            return;
        }

        System.out.println("Recently Played:");
        for (String song : recentlyPlayed) {
            System.out.println(song);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Play Song");
            System.out.println("2. Search Song");
            System.out.println("3. Display Recently Played");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter song name: ");
                    playSong(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Enter song name: ");
                    searchSong(scanner.nextLine());
                    break;
                case 3:
                    displayRecentlyPlayed();
                    break;
                case 4:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
