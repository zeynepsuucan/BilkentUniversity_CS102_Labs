import java.util.Scanner;

public class Question3z {

    static int minOp(String A, String B, int z, int s){
        if(z==0 ){
            return s;
        }
        if(s==0 ){
            return z;
        }
        if(A.charAt(z-1)==B.charAt(s-1))
        return minOp(A, B, z-1, s-1);

        int a = 2 + minOp(A, B, z, s-1);
        int b = 1 + minOp(A, B, z-1, s-1);
        int c = 1 + minOp(A, B, z-1, s);

        if(a<=b && a<=c)
        return a;
        else if(b<=a && b<=c)
        return b;
        else 
        return c;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("first string:");
        String str1 = in.next();
        System.out.println("second string:");
        String str2 = in.next();
        System.out.println(minOp(str1, str2, str1.length(), str2.length()));
    }
}
