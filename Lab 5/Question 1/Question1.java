import java.util.ArrayList;
import java.util.Scanner;

/**
 * Question1
 */
public class Question1 {

    int N;
    int k;
    int a;
    int count;
    public static ArrayList<Integer> pos = new ArrayList();


    public static boolean ifPossible(int N, int k, int a){
        if(a==0 && N==k){return true;} 
        if(a == 0 && N != k){return false;}
        else{
            if(ifPossible(N-2,k,a-1)){return true;}
            else{return ifPossible(N-3, k, a-1);}
        }
    }

    /*public static boolean ifPossible(int N, int k, int a){
        if(a==0){
            if(N==k)
            return true;
            else
            return false; 
        }
        
        if((N-k)/a <= 3 && (N-k)/a >= 2){
            return true;
        }
        else return false;
    }*/

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("N:");
        int N = in.nextInt();
        System.out.print("k:");
        int k = in.nextInt();
        System.out.print("a:");
        int a = in.nextInt();

        if(ifPossible(N,k,a) == true){
            System.out.println("true");
        }
       else{
            System.out.println("false");
        }



        
    }

    
}