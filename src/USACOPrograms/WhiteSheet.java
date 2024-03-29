package USACOPrograms;
import java.util.*;

//USACO Guide (Section 1.4 Problem 3)

public class WhiteSheet {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int x1 = scan.nextInt(), y1 = scan.nextInt(), x2 = scan.nextInt(), y2 = scan.nextInt();
        int x3 = scan.nextInt(), y3 = scan.nextInt(), x4 = scan.nextInt(), y4 = scan.nextInt();
        int x5 = scan.nextInt(), y5 = scan.nextInt(), x6 = scan.nextInt(), y6 = scan.nextInt();

        Rect A =
                new Rect(x1, y1, x2, y2);
        Rect B =
                new Rect(x3, y3, x4, y4);
        Rect C =
                new Rect(x5, y5, x6, y6);

        A = cut(A, B);
        A = cut(A, C);

        // Print NO only if the remaining cut area is 0.
        if (A.area() == 0) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
    static class Rect {
        public int x1, y1, x2, y2;
        public Rect(int a, int b, int c, int d) {
            x1 = a;
            y1 = b;
            x2 = c;
            y2 = d;
        }

        public int area() { return (x2 - x1) * (y2 - y1); }
    }

    /*
       Main Idea: If B intersects entirely in the x or y direction, cut it.
       This method cuts rectangle A based on rectangle B. (A - white sheet, B -
       black sheet) We can cut rectangle A if B covers all of x1->x2 or y1->y2.
     */
    static Rect cut(Rect A, Rect B) {

        // If B cuts A from the left side
        if (A.x1 >= B.x1 && B.x2 >= A.x1 && B.y1 <= A.y1 && B.y2 >= A.y2) {
            A.x1 = B.x2;
            A.x2 = Math.max(A.x2, B.x2);  // If B covers A entirely
        }

        // If B cuts A from the right side
        if (A.x2 >= B.x1 && B.x2 >= A.x2 && B.y1 <= A.y1 && B.y2 >= A.y2) {
            A.x2 = B.x1;
            A.x1 = Math.min(A.x1, B.x1);  // If B covers A entirely
        }

        // If B cuts A from the bottom side
        if (A.y1 >= B.y1 && B.y2 >= A.y1 && B.x1 <= A.x1 && B.x2 >= A.x2) {
            A.y1 = B.y2;
            A.y2 = Math.max(A.y2, B.y2);  // If B covers A entirely
        }

        // If B cuts A from the top side
        if (A.y2 >= B.y1 && B.y2 >= A.y2 && B.x1 <= A.x1 && B.x2 >= A.x2) {
            A.y2 = B.y1;
            A.y1 = Math.min(A.y1, B.y1);  // If B covers A entirely
        }
        return A;
    }
}
