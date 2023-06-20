package USACOPrograms;
import java.io.*;

//2017 December Contest (Bronze) --> Also USACO Guide (Section 1.3 Problem 4)

public class BovineShuffle {
    public static void main (String[] args) throws IOException{
        BufferedReader scan = new BufferedReader(new FileReader ("shuffle.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter ("shuffle.out"));

        int N = Integer.parseInt(scan.readLine());
        String s = scan.readLine(); String[] arr = s.split(" ");
        int[] final_pos = new int[N];
        for (int i = 0; i < N; i ++){final_pos[i] = Integer.parseInt(arr[i]); }
        s = scan.readLine(); arr = s.split(" ");
        int[] final_ID = new int[N];
        for (int i = 0; i < N; i ++){final_ID[i] = Integer.parseInt(arr[i]); }

        int[] initial_ID = new int[N];
        for (int a = 0; a < 3; a++) {
            for (int i = 0; i < N; i++) {
                initial_ID[i] = final_ID[final_pos[i] - 1];
            }
            final_ID = initial_ID;
            if (a != 2) initial_ID = new int[N];
        }
        for (int i = 0; i < N; i ++){
            write.write(initial_ID[i] + "\n");
        }
        write.close();
    }
}
