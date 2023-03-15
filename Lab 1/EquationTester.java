import java.util.Scanner;
public class EquationTester {

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);

        System.out.print("Enter the value of a, b and c for the first equation: ");
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        Equation eq = new Equation(a, b, c);

        System.out.print("Enter the value of a, b and c for the second equation: ");
        int a2 = in.nextInt();
        int b2 = in.nextInt();
        int c2 = in.nextInt();
        Equation eq2 = new Equation(a2, b2, c2);

        System.out.println(eq.equals(eq2));
        

        System.out.println("Sum of equations: " + eq.add(eq2));

        System.out.print("Enter the value of a, b and c for the first equation: ");
        int a3 = in.nextInt();
        int b3 = in.nextInt();
        int c3 = in.nextInt();
        Equation eq3 = new Equation(a3, b3, c3);

        System.out.print("Enter the value of a, b and c for the second equation: ");
        int a4 = in.nextInt();
        int b4 = in.nextInt();
        int c4 = in.nextInt();
        Equation eq4 = new Equation(a4, b4, c4);
        System.out.println("Substraction of equations: " + eq3.substract(eq4));


        System.out.print("Enter the value of a, b and c for the equation to be reduced: ");
        int a5 = in.nextInt();
        int b5 = in.nextInt();
        int c5 = in.nextInt();
        Equation eq5 = new Equation(a5, b5, c5);
        eq5.reduceEquation();
        System.out.println(eq5);
    }
    
}
