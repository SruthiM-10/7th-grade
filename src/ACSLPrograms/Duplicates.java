package ACSLPrograms;
import java.util.*;

//Contest 4 2017-18 (practice - Junior)

public class Duplicates {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(), counter = 0;
        String s = scan.nextLine();
        s = s.toUpperCase();

        ArrayList<Character> arr = new ArrayList<> ();
        char orig_val;
        arr.add('\u0000');
        for (int i = 1; i < s.length(); i ++){
            if (arr.size() >= N + 1) orig_val = arr.get(N);
            else orig_val = 0;

            if ((int) s.charAt(i) > 90 || (int) s.charAt(i) < 65) continue;

            for (int min = 0; min < arr.size(); min ++) {
                if (arr.get(min) >= s.charAt(i)) {
                    arr.add(min, s.charAt(i));
                    break;
                }
                else if (min == arr.size() - 1){
                    arr.add(s.charAt(i));
                    break;
                }
            }
            if (arr.size() >= N + 1 && orig_val != arr.get(N)) counter ++;
        }

        System.out.println(counter);
    }
}
