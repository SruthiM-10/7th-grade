package USACOPrograms;
import java.io.*;

// USACO 2018 January Contest (Bronze), also USACO Guide (Section 5 Problem 8)
public class Lifeguards {
    static class Lifeguard {
        int start, end;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader scan = new BufferedReader (new FileReader ("lifeguards.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter ("lifeguards.out"));

        int N = Integer.parseInt(scan.readLine()), tot_time = 0, min = 0;
        int[] time = new int[1001];
        Lifeguard[] shifts = new Lifeguard[N];
        int[] lifeguards = new int[N];
        for (int i = 0; i < N; i ++){
            String s = scan.readLine();
            String[] arr = s.split(" ");
            shifts[i] = new Lifeguard();
            shifts[i].start = Integer.parseInt(arr[0]);
            shifts[i].end = Integer.parseInt(arr[1]);
            for (int t = shifts[i].start; t < shifts[i].end; t++) {
                if (time[t] == 0) tot_time ++;
                time[t]++;
            }
        }
        for (int i = 0; i < N; i ++){
            for (int t = shifts[i].start; t < shifts[i].end; t++) {
                if (time[t] == 1) lifeguards[i] ++;
            }
            if (lifeguards[i] < lifeguards[min])
                min = i;
        }
        tot_time = tot_time - lifeguards[min];
        write.write(tot_time + "");
        write.close();
    }
}
