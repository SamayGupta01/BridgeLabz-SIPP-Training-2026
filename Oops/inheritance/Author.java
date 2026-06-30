package oops.inheritance;

public class Author extends Book {
    private String name;
    private String bio;

    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author Details:");
        System.out.println("  Name: " + name);
        System.out.println("  Bio: " + bio);
    }
}
