package USACOPrograms;
import java.io.*;

//2016 February Contest (Bronze) --> Also USACO Guide (Section 1.3 Problem 7)

public class CircularBarn {
    public static void main(String[] args) throws IOException{
        BufferedReader scan = new BufferedReader (new FileReader ("cbarn.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter ("cbarn.out"));
        int N = Integer.parseInt(scan.readLine());
        int[] rooms = new int[N];
        for (int i = 0; i < N; i ++){
            rooms[i] = Integer.parseInt(scan.readLine());
        }
        int ans = Integer.MAX_VALUE, dist;
        for (int door = 1; door <= N; door ++){
            dist = 0;
            for (int i = 1; i <= N; i ++){
                if (i >= door) dist += rooms[i - 1] * (i - door);
                else dist += rooms[i - 1] * (i + N - door);
            }
            if (dist < ans) ans = dist;
        }
        write.write(String.valueOf(ans));
        write.close();
    }
}
