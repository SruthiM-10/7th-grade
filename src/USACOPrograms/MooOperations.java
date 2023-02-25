package USACOPrograms;
import java.util.*;

//USACO Problem 2023 Jan Contest (Bronze)

public class MooOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] arr = new int[N];

        scan.nextLine();
        for (int i = 0; i < N; i ++) {
            int ans = Searching(scan);
            arr[i] = ans;
        }
        for (int i = 0; i < N; i ++){
            System.out.println(arr[i]);
        }
    }
    public static int Searching(Scanner scan){
        String s = scan.nextLine();
        int count = -1;
        for (int i = 0; i < s.length(); i ++){
            if (s.startsWith("MOO", i) && (count > s.length() - 3 || count == -1)){ count = s.length() - 3;}
            else if (s.startsWith("MOM", i) && (count > s.length() - 2 || count == -1)){ count = s.length() - 2;}
            else if (s.startsWith("OOO", i) && (count > s.length() - 2 || count == -1)){ count = s.length() - 2;}
            else if (s.startsWith("OOM", i)&& (count > s.length() - 1 || count == -1)){ count = s.length() - 1;}
        }
        return count;
    }
}
