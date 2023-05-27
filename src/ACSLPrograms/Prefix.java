package ACSLPrograms;
import java.util.*;

//Contest 4 2018-19 (Practice)

public class Prefix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 5; i ++){
            System.out.println (prefix_evaluation(scan));
        }
    }
    public static String prefix_evaluation(Scanner scan){
        String s = scan.nextLine();
        String[] a = s.split(" ");
        ArrayList <String> arr = new ArrayList<>(Arrays.asList(a));
        int value;
        for (int x = arr.size() - 1; x >= 0; x --){
            if (arr.get(x).equals("*")){
                value = Integer.parseInt(arr.get(x + 1)) * Integer.parseInt(arr.get(x + 2));
                arr.remove(x); arr. remove(x); arr.remove(x);
                arr.add(x, "" + value);
            }
            if (arr.get(x).equals("/")){
                value = Integer.parseInt(arr.get(x + 1)) / Integer.parseInt(arr.get(x + 2));
                arr.remove(x); arr. remove(x); arr.remove(x);
                arr.add(x, "" + value);
            }
            if (arr.get(x).equals("+")){
                value = Integer.parseInt(arr.get(x + 1)) + Integer.parseInt(arr.get(x + 2));
                arr.remove(x); arr. remove(x); arr.remove(x);
                arr.add(x, "" + value);
            }
            if (arr.get(x).equals("-")){
                value = Integer.parseInt(arr.get(x + 1)) - Integer.parseInt(arr.get(x + 2));
                arr.remove(x); arr. remove(x); arr.remove(x);
                arr.add(x, "" + value);

            }if (arr.get(x).equals("@")){
                if (Integer.parseInt(arr.get(x + 1)) > 0) value = Integer.parseInt(arr.get(x + 2));
                else value = Integer.parseInt(arr.get(x + 3));
                arr.remove(x); arr. remove(x); arr.remove(x); arr.remove(x);
                arr.add(x, "" + value);
            }
        }
        return arr.get(0);
    }
}
