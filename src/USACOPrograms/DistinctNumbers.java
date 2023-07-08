package USACOPrograms;
import java.util.*;

//USACO Guide (Section 3.1 Problem 1)

public class DistinctNumbers {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(), count = 1;
        int[] values = new int[N];
        for (int i = 0; i < N; i ++){
            values[i] = scan.nextInt();
        }
        Arrays.sort(values);
        for (int i = 1; i < N; i ++){
            if (values[i] != values[i - 1]) count ++;
        }
        System.out.println(count);
    }
}
