package USACOPrograms;
import java.io.*;

//2015 December Contest (Bronze) --> Also USACO Guide (Section 1.3 Problem 2)

public class SpeedingTicket {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader (new FileReader ("speeding.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter ("speeding.out"));
        String s = scan.readLine(); String[] arr = s.split(" ");
        int N = Integer.parseInt(arr[0]), M = Integer.parseInt(arr[1]);

        int[] road = new int[100]; int[] bessie = new int[100];
        int pos = 0;
        for (int i = 0; i < N; i ++){
            s = scan.readLine(); arr = s.split(" ");
            int length = Integer.parseInt(arr[0]);
            int speed_limit = Integer.parseInt(arr[1]);
            for (int a = 0; a < length; a ++){
                road[pos + a] = speed_limit;
            }
            pos += length;
        }
        pos = 0;
        for (int i = 0; i < M; i ++){
            s = scan.readLine(); arr = s.split(" ");
            int length = Integer.parseInt(arr[0]);
            int speed = Integer.parseInt(arr[1]);
            for (int a = 0; a < length; a ++){
                bessie[pos + a] = speed;
            }
            pos += length;
        }
        int max_over = 0;
        for (int i = 0; i < 100; i ++){
            max_over = Math.max(max_over, bessie[i] - road[i]);
        }
        write.write(String.valueOf(max_over));
        write.close();
    }
}