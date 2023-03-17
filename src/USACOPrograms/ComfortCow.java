package USACOPrograms;
import java.util.*;

//2021 Feb Contest (Bronze)

public class ComfortCow {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String[][] arr = new String[1001][1001];

        int N = scan.nextInt(), comfortCow = 0;
        for (int i = 0; i < N; i ++){
            int c = scan.nextInt(), r = scan.nextInt();
            r = 1000 - r;
            arr[r][c] = "0";
            if (r + 1 < 1001 && arr[r + 1][c] != null) {
                arr[r][c] = Integer.parseInt(arr[r][c]) + 1 + "";
                arr[r + 1][c] = Integer.parseInt(arr[r + 1][c]) + 1 + "";
                if (arr[r + 1][c].equals("3")) comfortCow ++;
                else if (arr[r + 1][c].equals("4")) comfortCow --;
            }
            if (r - 1 >= 0 && arr[r - 1][c] != null){
                arr[r][c] = Integer.parseInt(arr[r][c]) + 1 + "";
                arr[r - 1][c] = Integer.parseInt(arr[r - 1][c]) + 1 + "";
                if (arr[r - 1][c].equals("3")) comfortCow ++;
                else if (arr[r - 1][c].equals("4")) comfortCow --;
            }
            if (c + 1 < 1001 && arr[r][c + 1] != null){
                arr[r][c] = Integer.parseInt(arr[r][c]) + 1 + "";
                arr[r][c + 1] = Integer.parseInt(arr[r][c + 1]) + 1 + "";
                if (arr[r][c + 1].equals("3")) comfortCow ++;
                else if (arr[r][c + 1].equals("4")) comfortCow --;
            }
            if (c - 1 >= 0 && arr[r][c - 1] != null){
                arr[r][c] = Integer.parseInt(arr[r][c]) + 1 + "";
                arr[r][c - 1] = Integer.parseInt(arr[r][c - 1]) + 1 + "";
                if (arr[r][c - 1].equals("3")) comfortCow ++;
                else if (arr[r][c - 1].equals("4")) comfortCow --;
            }
            if (arr[r][c].equals("3")) comfortCow ++;
            System.out.println(comfortCow);
        }
    }
}
