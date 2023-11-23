package USACOPrograms;
import java.util.*;

//USACO Guide Section 1.4 (Problem 4)

public class TwoTables {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int i = 0; i < T; i ++){
            int distance = Integer.MAX_VALUE;
            int W = scan.nextInt(), H = scan.nextInt();
            int x1 = scan.nextInt(), y1 = scan.nextInt(),x2 = scan.nextInt(), y2 = scan.nextInt();
            int table_w = scan.nextInt(), table_h = scan.nextInt();
            if (table_w + x2 - x1 <= W) {
                int overlap_left = Math.max(0, table_w - x1);
                int overlap_right = Math.max(0, x2 - (W - table_w));
                distance = Math.min(overlap_right, overlap_left);
            }
            if(table_h + y2 - y1 <= H){
                int overlap_top = Math.max(0, y2 - (H - table_h));
                int overlap_bottom = Math.max(0, table_h - y1);
                distance = Math.min(Math.min(overlap_bottom, overlap_top), distance);
            }
            System.out.println(distance == Integer.MAX_VALUE ? -1 : distance);
        }
    }
}
