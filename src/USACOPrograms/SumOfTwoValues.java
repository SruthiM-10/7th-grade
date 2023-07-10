package USACOPrograms;
import java.util.*;

//USACO Guide (Section 3.2 Problem 1)

public class SumOfTwoValues {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(), X = scan.nextInt();
        ArrayList<Integer> values = new ArrayList<>();
        for (int i = 0; i < N; i ++){
            values.add(scan.nextInt());
        }
        boolean flag = true;
        int index = 0;
        for (int i = 0; i < N; i ++) {
            if (values.contains(X - values.get(i))) {
                flag = false;
                index = i;
                break;
            }
        }
        if (flag) System.out.println("IMPOSSIBLE");
        else System.out.println((index + 1) + " " + (values.indexOf(X - values.get(index)) + 1));
    }
}
