package USACOPrograms;
import java.util.*;

//USACO Guide (Section 2.2 Example 1 -- Making subsets with Recursions & Bitmasks)

public class AppleDivision {
    static int N;
    static int[] weights;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        weights = new int[N];
        for (int i = 0; i < N; i ++) weights[i] = scan.nextInt();

        //Solution 1 (using recursion)
        System.out.println(search_1(0, 0, 0));
        //Solution 2 (using bitmasks)
        System.out.println(search_2());
    }
    public static int search_1(int index, int sum1, int sum2){
        if (index == N){
            return Math.abs(sum1 - sum2);
        }
        return Math.min(search_1(index + 1, sum1 + weights[index], sum2), search_1(index + 1, sum1, sum2 + weights[index]));
    }
    public static int search_2(){
        int ans = Integer.MAX_VALUE, sum1, sum2;
        for (int mask = 0; mask < (1 << N); mask ++){
            sum1 = 0; sum2 = 0;
            for (int i = 0; i < N; i ++){
                if ((mask & (1 << i)) > 0){
                    sum1 += weights[i];
                }
                else sum2 += weights[i];
            }
            ans = Math.min(ans, Math.abs(sum1 - sum2));
        }
        return ans;
    }
}
