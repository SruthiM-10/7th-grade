package USACOPrograms;

import java.util.*;

//USACO Problem 2023 Jan Contest (Bronze)

public class Leaders {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();
        String s = scan.nextLine();
        int[] arr = new int[N];
        for (int i = 0; i < N; i ++){ arr[i] = scan.nextInt() - 1; }

        int eG = -1, eH = -1, lG = -1, lH = -1;
        boolean flagG = true, flagH = true;
        for (int i = 0; i < N; i ++){
            if (s.charAt(i) == 'G' && flagG){ eG = i; flagG = false; }
            if (s.charAt(i) == 'H' && flagH){ eH = i; flagH = false; }
        }
        flagG = true; flagH = true;
        for (int i = N - 1; i >= 0; i --){
            if (s.charAt(i) == 'G' && flagG){ lG = i; flagG = false; }
            if (s.charAt(i) == 'H' && flagH){ lH = i; flagH = false; }
        }

        int leader_g = 0, leader_h = 0;
        if (arr[eG] >= lG && arr[eH] < lH){
            leader_g = 1;
            for (int i = eH; i < eG; i ++){
                if (s.charAt(i) == 'H' && arr[i] >= eG) leader_h ++;
            }
        }
        if (arr[eH] >= lH && arr[eG] < lG){
            leader_h = 1;
            for (int i = eG; i < eH; i ++){
                if (s.charAt(i) == 'G' && arr[i] >= eH) leader_g ++;
            }
        }
        if (arr[eG] >= lG && arr[eH] >= lH){
            leader_g = 1;
            leader_h = 1;
            if (eG > eH){
                for (int i = eH; i < eG; i ++){
                    if (s.charAt(i) == 'H' && arr[i] >= eG) leader_h ++;
                }
            }
            else{
                for (int i = eG; i < eH; i ++){
                    if (s.charAt(i) == 'G' && arr[i] >= eH) leader_g ++;
                }
            }
        }
        System.out.println(leader_h*leader_g);
    }
    public static void BogusSolution(){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(), count_G = 0, count_H = 0;
        int cowsH = 0, cowsG = 0;
        scan.nextLine();
        String s = scan.nextLine();

        boolean[] leaders = new boolean[N];
        int[] arr = new int[N];
        for (int i = 0; i < N; i ++){ arr[i] = scan.nextInt() - 1; }
        for (int i = 0; i < N; i ++){
            if (s.charAt(i) == 'G') count_G ++;
            if (s.charAt(i) == 'H') count_H ++;
        }

        for (int i = N - 1; i >= 0; i --){
            int countH = 0, countG = 0;
            boolean flag = false;
            for (int b = i; b <= arr[i]; b ++){
                if (s.charAt(i) == 'H' && s.charAt(b) == 'H') countH ++;
                if (s.charAt(i) == 'G' && s.charAt(b) == 'G') countG ++;
                if (leaders[b]){ flag = true; break; }
            }
            if (flag){
                if (s.charAt(i) == 'H') cowsH ++;
                if (s.charAt(i) == 'G') cowsG ++;
                leaders[i] = true;
            }
            else if (s.charAt(i) == 'H' && countH == count_H){ cowsH ++; leaders[i] = true;}
            else if (s.charAt(i) == 'G' && countG == count_G){ cowsG ++; leaders[i] = true;}
        }

        System.out.println(cowsH * cowsG);
    }
}
