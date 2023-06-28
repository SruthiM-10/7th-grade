package USACOPrograms;
import java.io.*;

//2017 December Contest (Bronze) --> Also USACO Guide (Section 1.4 Example 1)

public class BlockedBillboard {
    static class Rect {
        int x1, y1, x2, y2;
        int area() { return (y2 - y1) * (x2 - x1); }
    }
    public static int intersect (Rect a, Rect b){
        int x_overlap = Math.max(0, Math.min(a.x2, b.x2) - Math.max(a.x1, a.x2));
        int y_overlap = Math.max(0, Math.min(a.y2, b.y2) - Math.max(a.y1, b.y1));
        return x_overlap * y_overlap;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader scan = new BufferedReader(new FileReader ("billboard.in"));
        BufferedWriter write = new BufferedWriter(new FileWriter ("billboard.out"));

        Rect a = new Rect(), b = new Rect(), t = new Rect();
        String s = scan.readLine(); String[] arr = s.split(" ");
        a.x1 = Integer.parseInt(arr[0]); a.y1 = Integer.parseInt(arr[1]); a.x2 = Integer.parseInt(arr[2]); a.y2 = Integer.parseInt(arr[3]);
        s = scan.readLine(); arr = s.split(" ");
        b.x1 = Integer.parseInt(arr[0]); b.y1 = Integer.parseInt(arr[1]); b.x2 = Integer.parseInt(arr[2]); b.y2 = Integer.parseInt(arr[3]);
        s = scan.readLine(); arr = s.split(" ");
        t.x1 = Integer.parseInt(arr[0]); t.y1 = Integer.parseInt(arr[1]); t.x2 = Integer.parseInt(arr[2]); t.y2 = Integer.parseInt(arr[3]);

        int area = b.area() + a.area() - intersect(a, t) - intersect(b, t);

        write.write(String.valueOf(area));
        write.close();
    }
//Another solution using the Rectangle Class
/*
import java.awt.rectangle;
Rectangle bill1 = new Rectangle(x1, -y2, x2 - x1, y2 - y1);  // Deals with upper left corner of Rectangle --> Note! In Java, y-coordinates increase from top to bottom, not bottom to top! The origin is reflected so the lower-left point becomes the upper-left point
... do the same for the other Rectangles

long firstIntersect = getArea(bill1.intersect(truck));
long secondIntersect = getArea(bill2.intersect(truck));

write.write(getArea(bill1) + getArea(bill2) - firstIntersect - secondIntersect);
write.close();

Note! getArea is a separate function we make:
public static long getArea(Rectangle r){
    long area = r.getEmpty ? 0 : (long)r.getHeight() * (long)r.getWidth();
    return area;
}
 */
}
