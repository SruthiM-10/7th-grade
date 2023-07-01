package USACOPrograms;
import java.util.*;

//2020 December Contest (Bronze) -- Also USACO Guide (Section 2.1 Problem 3)

public class DaisyChains {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] daisies = new int[N];
        for (int i = 0; i < N; i ++){daisies[i] = scan.nextInt();}
        int count = 0;
        for (int a = 0; a < N; a ++){
            int sum = 0;
            for (int b = a; b < N; b ++){
                sum += daisies[b];
                double avg = (double) sum / (double) (b-a + 1);
                if ((int)avg  == avg) {
                    for (int i = a; i <= b; i++) {
                        if ((int) avg == daisies[i]){ count ++; break; }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
