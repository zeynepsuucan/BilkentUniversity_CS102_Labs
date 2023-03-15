import java.io.*;
import java.util.ArrayList;

public class Question2Test {
    static int N =100;
    static int max = 0;
    static int maxDig;
    static String result;
    static ArrayList<Integer> sums = new ArrayList<>();

    static void subsets(int[] array, int l, int r, int sum) {
        subsets(array, l + 1, r, sum + array[l]);
        subsets(array, l + 1, r, sum);
    }

    static void printSubsets(Game set[]) {
        int n = set.length;
        int sum = 0;
        int sum2 = 0;
        String sumW;
        String print = "";

        int i = 0;
        for (i = 0; i < (1 << n); i++) {
            sum = 0;
            sum2 = 0;
            sumW = "";

            int j = 0;
            for (j = 0; j < n; j++)

                if ((i & (1 << j)) > 0) {
                    sum += set[j].getScore();
                    sumW += " ";
                    sumW += set[j].getScore();
                    sum2 += set[j].getGB();
                }

            if (sum > max && sum2 < N) {
                max = sum;
                maxDig = n;
                print = sumW;
            }

            else
                result = "";

        }

        System.out.println(print);
    }

    // Driver code
    public static void main(String[] args) {
        boolean b = false;
        Game[] games = new Game[6];
        games[0] = new Game("a", 45, 50);
        games[1] = new Game("a", 10, 85);
        games[2] = new Game("a", 15, 45);
        games[3] = new Game("a", 15, 25);
        games[4] = new Game("a", 15, 15);
        games[5] = new Game("a", 15, 85);


        printSubsets(games);
    }
}