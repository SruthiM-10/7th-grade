package USACOPrograms;
import java.util.*;

//2021 Feb Contest (Bronze)

public class ClockwiseFence {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < N; i ++){
            String ans = Orientation(scan);
            System.out.println(ans);
        }
    }
    public static String Orientation(Scanner scan){
        String s = scan.nextLine();
        String ans = "";
        int degree = 0;
        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); i ++){
            if (prev == 'W'){
                if (s.charAt(i) == 'S') degree += -90;
                if (s.charAt(i) == 'N') degree += 90;
            }
            if (prev == 'E'){
                if (s.charAt(i) == 'N') degree += -90;
                if (s.charAt(i) == 'S') degree += 90;
            }
            if (prev == 'N'){
                if (s.charAt(i) == 'W') degree += -90;
                if (s.charAt(i) == 'E') degree += 90;
            }
            if (prev == 'S') {
                if (s.charAt(i) == 'E') degree += -90;
                if (s.charAt(i) == 'W') degree += 90;
            }
            prev = s.charAt(i);
        }
        //Calculating final turn between the last character and the first one (it's a closed loop after all)
        if (prev == 'W'){
            if (s.charAt(0) == 'S') degree += -90;
            if (s.charAt(0) == 'N') degree += 90;
        }
        if (prev == 'E'){
            if (s.charAt(0) == 'N') degree += -90;
            if (s.charAt(0) == 'S') degree += 90;
        }
        if (prev == 'N'){
            if (s.charAt(0) == 'W') degree += -90;
            if (s.charAt(0) == 'E') degree += 90;
        }
        if (prev == 'S') {
            if (s.charAt(0) == 'E') degree += -90;
            if (s.charAt(0) == 'W') degree += 90;
        }

        if (degree == 360) ans = "CW";
        else if (degree == -360) ans = "CCW";
        return ans;
    }
}
