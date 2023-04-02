package USACOPrograms;
import java.util.*;

//USACO Problem 2023 Feb Contest Bronze

public class HungryCow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long N = scan.nextLong(), T = scan.nextLong();

        long d, b;
        long end = 0, uneaten = 0;

        boolean flag = true;
        for (long i = 0; i < N; i ++){
            d = scan.nextLong(); b = scan.nextLong();
            long newEnd = d + b - 1;
            if (end == d) newEnd ++;
            if (end > d) newEnd = end + b;
            if (newEnd > end) {
                if (end < d) uneaten += d - end - 1;
            }
            end = newEnd;
//            long newEnd = d + b - 1;
//            if (newEnd >= end && T >= newEnd){ eaten += newEnd - end; end = newEnd; }
//            if (T < d + b - 1 && flag){ eaten += T - d + 1; flag = false; }
        }
        if (T > end) uneaten += T - end;
        System.out.println(T - uneaten);
    }
}
