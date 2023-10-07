package USACOPrograms;
import java.awt.*;
import java.util.*;
import java.io.*;

//2016 January Contest (Bronze) -- Also USACO Guide (Section 1.3 Problem 10)

public class MowingTheField {
    public static void main(String[] args) throws IOException{
        BufferedReader scan = new BufferedReader (new FileReader ("mowing.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter ("mowing.out"));

        int N = Integer.parseInt(scan.readLine());
        HashMap<Point, Integer> field = new HashMap<>();
        int pos_x = 0, pos_y = 0, maxRegrow = Integer.MAX_VALUE, time = 0;
        Point point = new Point(pos_x, pos_y);

        for (int i = 0; i < N; i ++){
            String s = scan.readLine();
            String[] arr = s.split(" ");
            String direction = arr[0], steps = arr[1];
            for (int a = 0; a < Integer.parseInt(steps); a++){
                if (direction.equals("E")) { point = new Point(pos_x + 1, pos_y); pos_x += 1;}
                if (direction.equals("W")) { point = new Point(pos_x - 1, pos_y); pos_x -= 1;}
                if (direction.equals("N")) { point = new Point(pos_x, pos_y + 1); pos_y += 1;}
                if (direction.equals("S")) { point = new Point(pos_x, pos_y - 1); pos_y -= 1; }
                time ++;
                if (field.containsKey(point)) maxRegrow = Math.min(maxRegrow, time - field.get(point));
                field.put(point, time);
            }
        }
        if(maxRegrow == Integer.MAX_VALUE) maxRegrow = -1;
        write.write(Integer.toString(maxRegrow));
        write.close();
    }
}
