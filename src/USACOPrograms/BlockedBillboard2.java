package USACOPrograms;
import java.io.*;

//2018 January Contest (Bronze) --> Also USACO Guide (Section 1.4 Problem 2)

public class BlockedBillboard2 {
    static class Rect{
        int x1, y1, x2, y2;
        public int getArea(){
            return (x2 - x1) * (y2 - y1);
        }
    }
    public static boolean covered(int x, int y, Rect bill){
        if(x >= bill.x1 && x <= bill.x2 && y >= bill.y1 && y <= bill.y2)
            return true;
        else return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new FileReader("billboard.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter("billboard.out"));

        String s = scan.readLine(); String[] arr = s.split(" ");
        Rect lawn = new Rect();
        lawn.x1 = Integer.parseInt(arr[0]); lawn.y1 = Integer.parseInt((arr[1])); lawn.x2 = Integer.parseInt((arr[2])); lawn.y2 = Integer.parseInt((arr[3]));

        s = scan.readLine(); arr = s.split(" ");
        Rect bill = new Rect();
        bill.x1 = Integer.parseInt(arr[0]); bill.y1 = Integer.parseInt((arr[1])); bill.x2 = Integer.parseInt((arr[2])); bill.y2 = Integer.parseInt((arr[3]));

        //base it on how many corners are covered
        int corner_num = 0;
        if(covered(lawn.x1, lawn.y1, bill)) corner_num ++;
        if(covered(lawn.x1, lawn.y2, bill)) corner_num ++;
        if(covered(lawn.x2, lawn.y1, bill)) corner_num ++;
        if(covered(lawn.x2, lawn.y2, bill)) corner_num ++;

        if (corner_num < 2) write.write(String.valueOf(lawn.getArea()));
        else if (corner_num == 4) write.write("0");
        else{ //find area of intersection and subtracting from total area of the lawn billboard
            int length = Math.min(lawn.x2, bill.x2) - Math.max(lawn.x1, bill.x1);
            int width = Math.min (lawn.y2, bill.y2) - Math.max(lawn.y1, bill.y1);
            int notCoveredArea = lawn.getArea() - length*width;
            write.write(String.valueOf(notCoveredArea));
        }
        write.close();
    }
}
