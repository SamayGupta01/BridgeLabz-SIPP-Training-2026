package oops.inheritance;

public class Book {
    private String title;
    private int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void displayInfo() {
        System.out.println("Book Details:");
        System.out.println("  Title: " + title);
        System.out.println("  Publication Year: " + publicationYear);
    }
}
