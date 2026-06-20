package GRCcodebase.ExceptionHandelling;
public class ArrayDemo {

    public static void main(String[] args) {

        int[] arr = {10,20,30};

        int index = 5;

        try {

            System.out.println(
                    "Value = " + arr[index]);

        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        }
        catch(NullPointerException e) {
            System.out.println(
                    "Array is not initialized!");
        }
    }
}