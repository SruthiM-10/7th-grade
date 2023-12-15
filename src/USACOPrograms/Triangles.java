package USACOPrograms;
import java.io.*;
import java.util.*;

//USACO 2020 February Contest also USACO Guide (Section 5 Problem 7)

public class Triangles {
    public static void main(String[] args) throws IOException{
        BufferedReader scan = new BufferedReader (new FileReader ("triangles.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter ("triangles.out"));
        int N = Integer.parseInt(scan.readLine());
        int area = 0;
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        for (int i = 0; i < N; i ++){
            String s = scan.readLine();
            String[] arr = s.split(" ");
            int x1 = Integer.parseInt(arr[0]) + 10*10*10*10, y1 = Integer.parseInt(arr[1]) + 10*10*10*10;
            x.add(x1); y.add(y1);
        }
        for (int i = 0; i < x.size(); i ++){
            for (int a = i + 1; a < x.size(); a ++){
                if (x.get(a).equals(x.get(i))){
                    for (int j = 0; j < y.size(); j ++){
                        if (y.get(j).equals(y.get(a)) && !x.get(j).equals(x.get(a))){
                            int leg1 = Math.abs(x.get(a) - x.get(j));
                            int leg2 = Math.abs(y.get(a) - y.get(i));
                            area = Math.max(area, leg1*leg2);
                        }
                        else if (y.get(j).equals(y.get(i)) && !x.get(j).equals(x.get(i))){
                            int leg1 = Math.abs(x.get(i) - x.get(j));
                            int leg2 = Math.abs(y.get(i) - y.get(a));
                            area = Math.max(area, leg1*leg2);
                        }
                    }
                }
            }
        }
        write.write(area + "");
        write.close();
    }
}
