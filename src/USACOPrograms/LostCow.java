package USACOPrograms;
import java.io.*;

//2017 US Open Contest (Bronze) --> Also USACO Guide (Section 1.3 Problem 3)
//Note! My solution has excess time complexity due to the for loops in the while loop.
//This could have been fixed by just seeing Farmer John's starting position and intended ending position after each iteration, and checking whether Bessie's position was in between.

public class LostCow {
    public static void main(String[] args) throws IOException{
        BufferedReader scan = new BufferedReader(new FileReader ("lostcow.in"));
        BufferedWriter write = new BufferedWriter(new FileWriter("lostcow.out"));
        String s = scan.readLine(); String[] arr = s.split(" ");
        int x = Integer.parseInt(arr[0]), y = Integer.parseInt(arr[1]);
        int dist = 0, pos = x, factor = 1;
        while (true){
            boolean flag = false;
            if (x + factor > pos) {
                for (; pos < x + factor; pos++) {
                    dist++;
                    if (pos == y) { flag = true;break; }
                }
            }
            else{
                for (; pos > x + factor; pos--) {
                    dist++;
                    if (pos == y) { flag = true;break; }
                }
            }
            factor *= -2;
            if (flag) break;
        }
        if (dist > 0) dist --;
        write.write(String.valueOf(dist));
        write.close();
    }
}
