package USACOPrograms;
import java.io.*;

//2018 December Contest (Bronze) --> Also USACO Guide (Section 1.3 Problem 5)

public class BucketList {
    public static void main (String[] args) throws IOException{
        BufferedReader scan = new BufferedReader (new FileReader ("blist.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter ("blist.out"));

        int N = Integer.parseInt(scan.readLine());
        int[] time = new int[1000];
        int tot_buckets = 0;
        for (int i = 0; i < N; i ++){
            String s = scan.readLine();
            String[] arr = s.split(" ");
            int start = Integer.parseInt(arr[0]) - 1, end = Integer.parseInt(arr[1]) - 1, buckets_i = Integer.parseInt(arr[2]);
            for (; start<end; start ++){
                time[start] += buckets_i;
                if (time[start] > tot_buckets) tot_buckets = time[start];
            }
        }
        write.write(String.valueOf(tot_buckets));
        write.close();
    }
}
