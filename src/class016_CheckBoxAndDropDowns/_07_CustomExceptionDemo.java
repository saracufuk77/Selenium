package class016_CheckBoxAndDropDowns;

public class _07_CustomExceptionDemo {
    public static void main(String[] args) throws Exception {
        int myint = 10;

        if (myint >= 15) {
            System.out.println("Hi");
        } else {
            try {
                System.out.println("Please enter a number equal to or less than " + myint);
                throw new Exception(String.valueOf(myint));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}