package USACOPrograms;
import java.io.*;

//2020 February Contest (Bronze) --> Also USACO Guide (Section 4.2 Example 1)

public class MadScientist {
    public static void main(String[] args) throws IOException{
        BufferedReader scan = new BufferedReader (new FileReader ("breedflip.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter ("breedflip.out"));
        int N = Integer.parseInt(scan.readLine()), count = 0;
        String A = scan.readLine(), B = scan.readLine();
        boolean batch = false;
        for (int i = 0; i < N; i ++){
            if (B.charAt(i) != A.charAt(i)){
                if (!batch){ batch = true; count ++; }
            }
            else{
                if (batch){ batch = false; }
            }
        }
        write.write(String.valueOf(count));
        write.close();
    }
}
