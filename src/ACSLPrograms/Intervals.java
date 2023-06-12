package ACSLPrograms;
import java.util.*;

//Finals (Junior) 2022-23

public class Intervals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String intervals1 = scan.nextLine(), intervals2 = scan.nextLine(), intervals3 = scan.nextLine();
        int[] arr1 = new int[199];
        int[] arr2 = new int[199];
        int[] arr3 = new int[199];
        String[] interval1 = intervals1.split(" ");
        int start = 0, end = 0;
        for (String s : interval1) {
            String[] arr = s.split(",");
            if (s.charAt(0) == '[') start = Integer.parseInt(arr[0].substring(1));
            if (s.charAt(0) == '(') start = Integer.parseInt(arr[0].substring(1)) + 1;
            int length = s.length();
            if (s.charAt(length - 1) == ']') end = Integer.parseInt(arr[1].substring(0, arr[1].length() - 1));
            if (s.charAt(length - 1) == ')') end = Integer.parseInt(arr[1].substring(0, arr[1].length() - 1)) - 1;

            for (int a = start; a <= end; a++) {
                arr1[a + 99] += 1;
            }
        }
        String[] interval2 = intervals2.split(" ");
        for (String s2 : interval2) {
            String[] arr = s2.split(",");
            if (s2.charAt(0) == '[') start = Integer.parseInt(arr[0].substring(1));
            if (s2.charAt(0) == '(') start = Integer.parseInt(arr[0].substring(1)) + 1;
            int length = s2.length();
            if (s2.charAt(length - 1) == ']') end = Integer.parseInt(arr[1].substring(0, arr[1].length() - 1));
            if (s2.charAt(length - 1) == ')') end = Integer.parseInt(arr[1].substring(0, arr[1].length() - 1)) - 1;

            for (int a = start; a <= end; a++) {
                arr2[a + 99] += 1;
            }
        }
        if (!intervals3.equals("null")) {
            String[] interval3 = intervals3.split(" ");
            for (String s3 : interval3) {
                String[] arr = s3.split(",");
                if (s3.charAt(0) == '[') start = Integer.parseInt(arr[0].substring(1));
                if (s3.charAt(0) == '(') start = Integer.parseInt(arr[0].substring(1)) + 1;
                int length = s3.length();
                if (s3.charAt(length - 1) == ']') end = Integer.parseInt(arr[1].substring(0, arr[1].length() - 1));
                if (s3.charAt(length - 1) == ')') end = Integer.parseInt(arr[1].substring(0, arr[1].length() - 1)) - 1;

                for (int a = start; a <= end; a++) {
                    arr3[a + 99] += 1;
                }
            }
        }
        if(intervals3.equals("null")){
            int sum = 0;
            for (int i = 0; i < 199; i ++){
                if ((arr1[i] > 0 && arr2[i] == 0) || (arr1[i] == 0 && arr2[i] > 0))
                    sum += i - 99;
            }
            System.out.println(sum);
        }
        else{
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < 199; i ++){
                if ((arr1[i] > 0 && arr2[i] > 0 && arr3[i] == 0)
                    || (arr1[i] == 0 && arr2[i] > 0 && arr3[i] > 0)
                    || (arr1[i] > 0 && arr2[i] == 0 && arr3[i] > 0)) sum2 += i;
                if ((arr1[i] > 0 && arr2[i] == 0 && arr3[i] == 0)
                        || (arr1[i] == 0 && arr2[i] > 0 && arr3[i] == 0)
                        || (arr1[i] == 0 && arr2[i] == 0 && arr3[i] > 0)) sum1 += i;
            }
            System.out.println(sum1 + "\n" + sum2);
        }
    }
}
