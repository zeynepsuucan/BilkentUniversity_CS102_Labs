import java.util.ArrayList;
import java.util.Scanner;

public class Arraymain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("number 1: ");
        String n1 = in.next();
        IntegerArray n1A = new IntegerArray(n1);
        System.out.println("number 2: ");
        String n2 = in.next();
        IntegerArray n2A = new IntegerArray(n2);

        System.out.println("The sum is: " + n1A.add(n2A));

        System.out.println("number 3: ");
        String n3 = in.next();
        IntegerArray n3A = new IntegerArray(n3);
        System.out.println("number 4: ");
        String n4 = in.next();
        IntegerArray n4A = new IntegerArray(n4);

        System.out.println("The difference is: " + n3A.substract(n4A));

    }
}