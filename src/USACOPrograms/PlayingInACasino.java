package USACOPrograms;
import java.util.*;

//USACO Guide (Section 3.1 Problem 2)

public class PlayingInACasino {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int j = 0; j < T; j ++){
            int N = scan.nextInt(), M = scan.nextInt();
            long total = 0;
            long[][] cards = new long[M][N];
            for (int a = 0; a < N; a ++){
                for (int b = 0; b < M; b ++){
                    cards[b][a] = scan.nextInt();
                }
            }
            for (int i = 0; i < M; i ++){
                total += calculate(cards[i]);
            }
            System.out.println(total);
        }
    }
    public static long calculate(long[] nums){
        Arrays.sort(nums);
        int n = nums.length;
        long cur = 0;
        for (int i = 1; i < n; i ++) {
            cur += nums[i] - nums[0];
        }
        long ans = cur;
        for (int i = 1; i < n; i ++){
            cur -= (nums[i] - nums[i - 1]) * (n - i);
            ans += cur;
        }
        return ans;
    }
}
