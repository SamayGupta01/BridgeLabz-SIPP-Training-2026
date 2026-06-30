public class LibraryManagementSystem {
    public static void main(String[] args) {
        Book book = new Book(101, "Java Fundamentals", "Amit Sharma");
        Magazine magazine = new Magazine(102, "Tech Today", "Priya Verma");
        DVD dvd = new DVD(103, "Learning Java", "Sunil Gupta");

        System.out.println("--- Book Details ---");
        book.displayItemDetails();

        System.out.println("\n--- Magazine Details ---");
        magazine.displayItemDetails();

        System.out.println("\n--- DVD Details ---");
        dvd.displayItemDetails();
    }
}
