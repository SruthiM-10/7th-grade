package USACOPrograms;
import java.io.*;

//2016 US Open Contest -- Also USACO Guide (Section 2.1 Problem 2)
//There are two solutions, you can either use arraylists (to be able to remove elements and "getIndexOf") or primitive arrays. I am using the latter.

public class DiamondCollector {
    public static void main (String[] args) throws IOException{
        BufferedReader scan = new BufferedReader (new FileReader ("diamond.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter("diamond.out"));

        String s = scan.readLine(); String[] arr = s.split(" ");
        int N = Integer.parseInt(arr[0]), K = Integer.parseInt(arr[1]);

        int[] diamonds = new int[N];
        for (int i = 0; i < N; i ++){ diamonds[i] = Integer.parseInt(scan.readLine());}

        int ans = 0, count;
        for (int min = 0; min < N; min++){
            count = 0;
            for (int b = 0; b < N; b ++){
                if(diamonds[b] - diamonds[min] <= K && diamonds[b] - diamonds[min] >= 0) count ++;
            }
            if (count > ans) ans = count;
        }
        write.write(String.valueOf(ans));
        write.close();
    }
}
