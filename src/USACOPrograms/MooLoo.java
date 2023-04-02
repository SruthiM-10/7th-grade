package USACOPrograms;
import java.util.*;

//USACO Problem 2023 Feb Contest Bronze

public class MooLoo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long N = scan.nextLong(), K = scan.nextLong(), cost = K + 1;
        long a = scan.nextLong();
        for (long i = 1; i < N; i ++){
            long b = scan.nextLong();
            cost += Math.min(b - a, K + 1);
            a = b;
        }
        System.out.println(cost);

// BOGUS SOLUTION:  This overcomplicated things and took things from the wrong angle as well.
//        long a1 = scan.nextLong();
//        long op3 = 0;
//        long x = a1;
//        for (int i = 1; i < N; i ++) {
//            long y = scan.nextLong();
//        }
//        long a2 = x;
//        long op1 = K + a2 - a1 + 1;
//        long op2 = N * K + N;
//        op2 = Math.min(op2, op3);
//        System.out.println(Math.min(op1, op2));
    }
}