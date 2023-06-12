package ACSLPrograms;
import java.util.*;

//Finals (Junior) 2022-23 Problem 1

public class changedPositions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String customers = scan.nextLine();
        List<String> arr = Arrays.asList(customers.split(" "));
        int change = 0, length = arr.size();
        for (int i = 1; i < length; i ++){
            List<String> arr1 = new ArrayList<>();
            List<String> arr2 = new ArrayList<>();
            for (int a = 0; a < arr.size(); a ++){
                if (Integer.parseInt(arr.get(a)) == i){
                    arr2 = arr.subList( a + 1, arr.size());
                    break;
                }
                else {
                    arr1.add(0, arr.get(a));
                }
            }
            List<String> arr3 = new ArrayList<>();
            arr3.addAll(arr1);
            arr3.addAll(arr2);
            arr1.add(0, i + "");
            for (int a = 0; a < arr1.size(); a ++){
                if (!(arr1.get(a).equals(arr.get(a) + ""))) change ++;
            }
            arr = arr3;
        }
        System.out.println(change);
    }
}
