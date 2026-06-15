package GRCcodebase.String;


public class NullPointerExceptionDemo {

    static void handleException() {
        String text = null;

        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException Handled");
        }
    }

    public static void main(String[] args) {
        handleException();
    }
}