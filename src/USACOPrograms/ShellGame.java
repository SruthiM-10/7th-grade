package USACOPrograms;
import java.io.*;

//2019 January Contest (Bronze) --> Also USACO Guide

public class ShellGame {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new FileReader("shell.in"));
        BufferedWriter write = new BufferedWriter(new FileWriter("shell.out"));

        int N = Integer.parseInt(scan.readLine()), p1 = 0, p2 = 0, p3 = 0;
        int[] cups = new int [] {1, 2, 3};

        for (int i = 0; i < N; i ++){
            String[] arr = scan.readLine().split(" ");
            int a = Integer.parseInt(arr[0]) - 1;
            int b = Integer.parseInt(arr[1]) - 1;
            int g = Integer.parseInt(arr[2]) - 1;
            int temp = cups[a];
            cups[a] = cups[b]; cups[b] = temp;
            if (cups[g] == 1) p1 ++;
            if (cups[g] == 2) p2 ++;
            if (cups[g] == 3) p3 ++;
        }
        int max = Math.max(p1, p2); max = Math.max(max, p3);
        write.write(String.valueOf(max));
        write.close();
    }
}
