package USACOPrograms;
import java.io.*;

//2019 December Contest (Bronze) also USACO Guide (Section 5 Problem 5)

public class CowGymnastics {
    public static void main(String[] args) throws IOException{
        BufferedReader scan = new BufferedReader (new FileReader ("gymnastics.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter ("gymnastics.out"));
        String s = scan.readLine();
        String[] arr = s.split(" ");
        int K = Integer.parseInt(arr[0]), N = Integer.parseInt(arr[1]), pair = 0;
        int[][] sessions = new int[K][N];
        for (int i = 0; i < K; i ++){
            s = scan.readLine();
            arr = s.split(" ");
            for (int j = 0; j < N; j ++){
                sessions[i][j] = Integer.parseInt(arr[j]);
            }
        }
        boolean flag_greater, flag_smaller;
        for (int i = 1; i < N; i ++) {
            for (int j = i + 1; j <= N; j ++) { //cow identification
                flag_greater = true; flag_smaller = true;
                for (int a = 0; a < K; a++) {
                    int index_i = 0, index_j = 0;
                    for (int b = 0; b < N; b ++){  //indices
                        if (sessions[a][b] == i) index_i = b;
                        if (sessions[a][b] == j) index_j = b;
                    }
                    if (index_i > index_j)
                       flag_greater = false;
                    else
                        flag_smaller = false;
                    if (!flag_smaller && !flag_greater) break;
                }
                if (flag_smaller || flag_greater) pair ++;
            }
        }
        write.write(pair + "");
        write.close();
    }
}
