package USACOPrograms;
import java.io.*;

//2018 December Contest (Bronze) --> USACO Guide - Section 1

public class MixingMilk {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new FileReader ("mixmilk.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter ("mixmilk.out"));
        int[] c = new int[3]; int[] m = new int[3];
        for (int i = 0; i < 3; i ++){
            String s = scan.readLine();
            String[] arr = s.split(" ");
            c[i] = Integer.parseInt(arr[0]);
            m[i] = Integer.parseInt(arr[1]);
        }
        for (int i = 0; i < 100; i ++){
            int bucket1 = i % 3, bucket2 = (bucket1 + 1) % 3;
            if (c[bucket2] <= m[bucket1] + m[bucket2]){
                m[bucket1] -= c[bucket2] - m[bucket2];
                m[bucket2] = c[bucket2];
            }
            else{
                m[bucket2] = m[bucket1] + m[bucket2];
                m[bucket1] = 0;
            }
        }
        write.write(m[0] + "\n");
        write.write(m[1] + "\n");
        write.write(String.valueOf(m[2]));
        write.close();
    }
}
