package ACSLPrograms;
import java.util.*;

/*
Contest 1 2022-2023
Given 3 positive integers, n, b, and s, generate the next n integers in base b starting with s in the given base.
It is guaranteed that s is a valid number in base b and that b is between 2 and 9 inclusive.
Find the base ten sum of all the digits of the numbers generated.

Example: n = 15, b = 8, s = 2
The base 8 numbers generated:
            2,3,4,5,6,7,10,11,12,13,14,15,16,17,20
The sum of all the digits is 65.

Note--> the starting digit will not be more than 16 digits long and all inputs will be integer values.
 */
public class NextBase{
    public static int findDigitSum(int num, int base, int start) {
        int[] arr = new int[num];
        int sum = 0;
        int start_10 = Integer.parseInt(Integer.toString(Integer.parseInt(start + "", base), 10));
        for (int i = 0; i < num; i ++){
            arr[i] = start_10 + i;
            String x = arr[i] + "";
            arr[i] = Integer.parseInt(Integer.toString(Integer.parseInt(x, 10), base));
            int temp = arr[i];
            while (temp > 0){
                sum += temp%10;
                temp /= 10;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt(), base = scan.nextInt(), start = scan.nextInt();
        int sum = findDigitSum(num, base, start);
        System.out.println(sum);
    }
}
