package USACOPrograms;
import java.io.*;
import java.util.*;

//2019 February Contest (Bronze) --> Also USACO Guide (Section 4.1 Problem 1)

public class SleepyCowHerding {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader (new FileReader ("herding.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter ("herding.out"));

        ArrayList<Long> line = new ArrayList<>();
        String s = scan.readLine(); String[] arr = s.split(" ");
        for (int i = 0; i < 3; i ++) line.add(Long.parseLong(arr[i]));
        Collections.sort(line);
        long min = line.get(0), mid = line.get(1), max = line.get(2);

        //min_count
        int min_count = 0;
        if (max - mid == 1){
            if (mid - min == 2) min_count = 1;
            else if (mid - min > 2) min_count = 2;
        }
        else if (max - mid == 2) min_count = 1;
        else{
            if (mid - min == 2) min_count = 1;
            else min_count = 2;
        }
        //max_count
        long max_count;
        if (mid - min > max - mid)
            max_count = mid - min - 1;
        else
            max_count = max - mid - 1;
        write.write(min_count + "\n");
        write.write(String.valueOf(max_count));
        write.close();
    }
}
