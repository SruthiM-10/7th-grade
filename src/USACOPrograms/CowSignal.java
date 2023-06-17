package USACOPrograms;
import java.io.*;

//2016 December Contest (Bronze) --> Also USACO Guide (Section 1.3 Problem1)

public class CowSignal {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader (new FileReader ("cowsignal.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter ("cowsignal.out"));
        String[] arr = scan.readLine().split(" ");
        int M = Integer.parseInt(arr[0]), N = Integer.parseInt(arr[1]), K = Integer.parseInt(arr[2]);
        char[][] signal = new char[M][N];
        for (int i = 0; i < M; i ++){
            String s = scan.readLine();
            for (int j = 0; j < N; j ++){
                signal[i][j] = s.charAt(j);
            }
        }
        for (int r = 0; r < M; r++){
            for (int k1 = 0; k1 < K; k1 ++) {
                for (int c = 0; c < N; c++) {
                    for (int k2 = 0; k2 < K; k2++) {
                        write.write(String.valueOf(signal[r][c]));
                    }
                }
                write.write("\n");
            }
        }
        write.close();
    }
}
