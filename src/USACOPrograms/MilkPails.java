package USACOPrograms;
import java.io.*;

//2016 February Contest (Bronze) - Also USACO Guide (Section 2.1 Problem 1)

public class MilkPails {
    public static void main(String[] args) throws IOException{
        BufferedReader scan = new BufferedReader (new FileReader("pails.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter("pails.out"));

        String s = scan.readLine(); String[] arr = s.split(" ");
        int X = Integer.parseInt(arr[0]), Y = Integer.parseInt(arr[1]), M = Integer.parseInt(arr[2]);
        int milk = 0, count = 0;

        while(true){
            int milk_y = M - count * X;
            if (milk_y < 0){ write.write(String.valueOf(milk)); break;}
            else{
                if (milk_y > Y) milk_y = milk_y - milk_y % Y;
                else milk_y = 0;
                milk = Math.max(milk, count * X + milk_y);
            }
            count ++;
        }
        write.close();
    }
}
