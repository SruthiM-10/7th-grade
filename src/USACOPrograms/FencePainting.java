package USACOPrograms;
import java.io.*;

//2015 December Contest (Bronze) --> Also USACO Guide (Section 1.4 Example 1)

public class FencePainting {
    public static void main(String[] args) throws IOException{
        BufferedReader scan = new BufferedReader (new FileReader("paint.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter ("paint.out"));

        String s = scan.readLine(); String[] arr = s.split(" ");
        int a = Integer.parseInt(arr[0]), b = Integer.parseInt(arr[1]);
        s = scan.readLine(); arr = s.split(" ");
        int c = Integer.parseInt(arr[0]), d = Integer.parseInt(arr[1]);

        if (a < c){
            if (b < d) {
                if (b > c) write.write(String.valueOf(d - a));
                else write.write(String.valueOf(d - a - (c - b)));
            }
            else write.write(String.valueOf(b - a));
        }
        else {
            if (b < d) write.write(String.valueOf(d - c));
            else {
                if (a < d) write.write(String.valueOf(b - c));
                else write.write(String.valueOf(b - c - (a - d)));
            }
        }
        write.close();
    }
    //Faster solution
    /*
    int total =  (b - a) + (d - c);
    int intersection = Math.max(Math.min(b, d) - Math.max(a,c), 0);
       - Note! The idea is that each value in the intersection is greater than BOTH a & c and less than BOTH b & d.
    write.write(String.valueOf(total - intersection));
     */
}
