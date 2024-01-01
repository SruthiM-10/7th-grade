package USACOPrograms;
import java.util.*;

//USACO 2023 December Contest

public class CandyCaneFeast {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(), M = scan.nextInt();
        long[] height_cows = new long[N];
        long[] height_canes_max = new long[M];
        long[] height_canes = new long[M];
        for (int i = 0; i < N; i ++){
            height_cows[i] = scan.nextLong();
        }
        for (int i = 0; i < M; i ++){
            height_canes_max[i] = scan.nextLong();
        }
        for (int a = 0; a < M; a ++) {
            for (int b = 0; b < N; b ++){
                if (height_cows[b] > height_canes[a]) {
                    long original = height_canes[a];
                    height_canes[a] = Math.min(height_canes_max[a], height_cows[b]);
                    height_cows[b] += height_canes[a] - original;
                }
                if (height_canes[a] == height_canes_max[a]) break;
            }
        }
        for(int i = 0; i < N; i ++){
            System.out.println(height_cows[i]);
        }
    }
}
