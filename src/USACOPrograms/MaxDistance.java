package USACOPrograms;
import java.util.*;

//USACO Guide (Section 2.1 Example 1)

public class MaxDistance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];
        for (int i = 0; i < N; i ++){ x[i] = scan.nextInt(); }
        for (int i = 0; i < N; i ++){ y[i] = scan.nextInt(); }

        int max = 0;
        for (int a = 0; a < N; a ++){
            for (int b = a + 1; b < N; b ++){
                int dx = x[a] - x[b], dy = y[a] - y[b];
                max = Math.max(dx*dx + dy*dy, max);
            }
        }
        System.out.println(max);
    }
}
