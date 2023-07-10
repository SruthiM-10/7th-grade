package USACOPrograms;
import java.io.*;

//2019 December Contest (Bronze) --> Also USACO Guide (Section 3.2 Problem 2)

public class WhereAmI {
    public static void main(String[] args) throws IOException{
        BufferedReader scan = new BufferedReader (new FileReader ("whereami.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter ("whereami.out"));
        int N = Integer.parseInt(scan.readLine()), K;
        String s = scan.readLine();
        for (int k = 1; k <= N; k ++){
            boolean good = true;
            for (int a = 0; a <= N - k; a++){
                String substring = s.substring(a, a + k);
                for (int b = 0; b <= N - k; b ++){
                    if (b != a) {
                        String sub2 = s.substring(b, b + k);
                        if (sub2.equals(substring)) { good = false; break; }
                    }
                }
                if (!good){ break; }
            }
            if (good){
                K = k;
                write.write(String.valueOf(K));
                write.close();
                break;
            }
        }
    }
}
