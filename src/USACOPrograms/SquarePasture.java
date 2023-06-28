package USACOPrograms;
import java.io.*;

//2016 December Contest (Bronze) -> Also USACO Guide (Section 1.4 Problem 1)

public class SquarePasture {
    static class Rect{
        int x1, y1, x2, y2;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader scan = new BufferedReader (new FileReader ("square.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter ("square.out"));

        Rect[] fences = new Rect[2];
        String s = scan.readLine(); String[] arr = s.split(" ");
        fences[0] = new Rect();
        fences[0].x1 = Integer.parseInt(arr[0]); fences[0].y1 = Integer.parseInt(arr[1]); fences[0].x2 = Integer.parseInt(arr[2]); fences[0].y2 = Integer.parseInt(arr[3]);

        s = scan.readLine(); arr = s.split(" ");
        fences[1] = new Rect();
        fences[1].x1 = Integer.parseInt(arr[0]); fences[1].y1 = Integer.parseInt(arr[1]); fences[1].x2 = Integer.parseInt(arr[2]); fences[1].y2 = Integer.parseInt(arr[3]);

        int width = Math.max(fences[0].x2, fences[1].x2) - Math.min(fences[0].x1, fences[1].x1);
        int height = Math.max(fences[0].y2, fences[1].y2) - Math.min(fences[0].y1, fences[1].y1);
        int area = Math.max(width, height) * Math.max(width,height);
        write.write(String.valueOf(area));
        write.close();
    }
}
