package ACSLPrograms;

import java.lang.*;
import java.util.*;

//Contest 2 (Junior) 2022-23

public class BinaryNum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int p = findLastBinary(s);
        System.out.println(p);
    }
    public static int findLastBinary(String s) {
        String concS = "";
        for (int i = 0; i < s.length(); i ++){
            concS += String.format("%08d", Integer.parseInt(Integer.toBinaryString(s.charAt(i))));
        }
        boolean flag = true;
        int p = -1;
        do{
            p ++;
            int length = (Integer.toString(p, 2)).length();
            for (int i = 0; i < concS.length(); i ++){
                if ((i + length < concS.length()) && (concS.substring(i, i + length)
                        .equals(Integer.toString(p,2))))
                    break;
                else if (i == concS.length() - 1)
                    flag = false;
            }
        }while(flag);

        int ans = p - 1;
        if (p == 0) ans = 0;
        return ans;
    }
}
