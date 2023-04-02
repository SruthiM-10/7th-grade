package USACOPrograms;
import java.util.*;

//USACO Problem 2023 Feb Contest Bronze

public class StampGrid {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < T; i ++){
            Stamping(scan);
            if (i != T - 1) scan.nextLine();
        }
    }
    public static void Stamping(Scanner scan){
        int N = scan.nextInt();
        scan.nextLine();
        char[][] ans = new char[N][N];
        for (int i = 0; i < N; i ++){ for (int j = 0; j < N; j ++){ ans[i][j] = '.'; } }
        char[][] grid = new char[N][N];
        for (int r = 0; r < N; r++){
            String s = scan.nextLine();
            for (int c = 0; c < N; c ++){
                grid[r][c] = s.charAt(c);
            }
        }

        int K = scan.nextInt();
        char[][] stamp = new char[K][K];
        scan.nextLine();
        for (int r = 0; r < K; r ++){
            String s = scan.nextLine();
            for (int c = 0; c < K; c ++){
                stamp[r][c] = s.charAt(c);
            }
        }

        for (int rot = 0; rot < 4; rot ++){
            for (int i = 0; i < N - K + 1; i ++){
                for (int j = 0; j < N - K + 1; j ++){
                    boolean flag = true;
                    for (int a = 0; a < K; a ++) {
                        for (int b = 0; b < K; b++) {
                            if (!(grid[i + a][j + b] == '*' || stamp[a][b] == '.')) {
                                flag = false;
                                break;
                            }
                        }
                    }
                    if (flag){
                        for (int a = 0; a < K; a ++){
                            for (int b = 0; b < K; b ++){
                                if (stamp[a][b] == '*') ans[i + a][j + b] = '*';
                            }
                        }
                    }
                }
            }
            char[][] stamp2 = new char[K][K];
            for (int a = 0; a < K; a ++){
                for (int b = 0; b < K; b ++){
                    stamp2[a][b] = stamp[b][K - 1 - a];
                }
            }
            stamp = stamp2;
        }
        if (Arrays.deepEquals(ans, grid)) System.out.println("YES");
        else System.out.println("NO");
    }
}
