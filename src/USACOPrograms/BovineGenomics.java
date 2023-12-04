package USACOPrograms;
import java.io.*;

//2017 US Open Contest (Bronze), also USACO Guide (Section 5 Problem 6)

public class BovineGenomics {
    public static void main(String[] args) throws IOException{
        BufferedReader scan = new BufferedReader (new FileReader("cownomics.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter ("cownomics.out"));
        String s = scan.readLine();
        String[] arr = s.split(" ");
        int N = Integer.parseInt(arr[0]), M = Integer.parseInt(arr[1]), pos = 0;
        char[][] spottedcows = new char[N][M];
        char[][] plaincows = new char[N][M];

        for (int i = 0; i < N; i ++){
            s = scan.readLine();
            for (int j = 0; j < M; j ++) {
                spottedcows[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < N; i ++){
            s = scan.readLine();
            for (int j = 0; j < M; j ++) {
                plaincows[i][j] = s.charAt(j);
            }
        }
        boolean flag;
        for (int i = 0; i < M; i ++){
            flag = true;
            for (int a = 0; a < N; a++){
                for (int b = 0; b < N; b ++) {
                    if (plaincows[b][i] == spottedcows[a][i]) {
                        flag = false; break;
                    }
                }
                if (!flag) break;
            }
            if (flag) pos ++;
        }
        write.write(pos + "");
        write.close();
    }
}
