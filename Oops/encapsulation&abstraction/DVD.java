public class DVD extends LibraryItem {

    public DVD(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3;
    }
}
