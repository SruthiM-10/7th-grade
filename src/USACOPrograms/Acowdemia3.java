package USACOPrograms;
import java.util.*;
/*
Bessie is a busy computer science graduate student. However, even graduate students need friends.
As a result, Farmer John has opened a pasture with the explicit purpose of helping Bessie and other cows form lasting friendships.
Farmer John's pasture can be regarded as a large 2D grid of square "cells" (picture a huge chess board). Each cell is labeled with:
    C if the cell contains a cow.
    G if the cell contains grass.
    . if the cell contains neither a cow nor grass.

For two distinct cows to become friends, the cows must choose to meet at a grass-covered square that is directly horizontally or vertically adjacent to both of them.
During the process, they eat the grass in the grass-covered square, so future pairs of cows cannot use that square as a meeting point.
The same cow may become friends with more than one other cow, but no pair of cows may meet and become friends more than once.

Farmer John is hoping that numerous pairs of cows will meet and become friends over time.
Please determine the maximum number of new friendships between distinct pairs of cows that can possibly be created by the end of this experience.

INPUT FORMAT (input arrives from the terminal / stdin):
The first line contains N and M (N,M≤1000).
The next N lines each contain a string of M characters, describing the pasture.

OUTPUT FORMAT (print output to the terminal / stdout):
Count the maximum number of pairs of cows that can become friends by the end of the experience.

SAMPLE INPUT:
4 5
.CGGC
.CGCG
CGCG.
.CC.C
SAMPLE OUTPUT:
4

Explanation:
If we label the cow in row i and column j with coordinates (i,j), then in this example there are cows at (1,2), (1,5), (2,2), (2,4), (3,1), (3,3), (4,2), (4,3), and (4,5).
One way for four pairs of cows to become friends is as follows:
    The cows at (2,2) and (3,3) eat the grass at (3,2).
    The cows at (2,2) and (2,4) eat the grass at (2,3).
    The cows at (2,4) and (3,3) eat the grass at (3,4).
    The cows at (2,4) and (1,5) eat the grass at (2,5).

Problem credits: Benjamin Qi
 */
public class Acowdemia3 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        scan.nextLine();

        char[][] pasture = new char[n + 2][m + 2];
        for (int y = 1; y <= n; y++) {
            pasture[y] = ('.' + scan.nextLine() + '.').toCharArray();
        }
        int answer = 0;
        for (int r = 1; r <= n; r++) {                       // when cows are vertically/horizontally adjacent
            for (int c = 1; c <= m; c++) {
                if (pasture[r][c] == 'G' && ((pasture[r][c - 1] == 'C' && pasture[r][c + 1] == 'C') || (pasture[r - 1][c] == 'C' && pasture[r + 1][c] == 'C'))) {
                    pasture[r][c] = '.';
                    answer++;
                }
            }
        }
        for (int r = 1; r <= n; r++) {                         //cows meeting when diagonally adjacent (two cows could never meet again because this is scanning all cows diagonally adjacent BELOW the cow
            for (int c = 1; c <= m; c++) {
                if (pasture[r][c] == 'C') {
                    if (pasture[r + 1][c - 1] == 'C') {
                        if (pasture[r][c - 1] == 'G') {
                            pasture[r][c - 1] = '.';
                            answer++;
                        } else if (pasture[r + 1][c] == 'G') {
                            pasture[r + 1][c] = '.';
                            answer++;
                        }
                    }
                    if (pasture[r + 1][c + 1] == 'C') {
                        if (pasture[r][c + 1] == 'G') {
                            pasture[r][c + 1] = '.';
                            answer++;
                        } else if (pasture[r + 1][c] == 'G') {
                            pasture[r + 1][c] = '.';
                            answer++;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}


        // BOGUS SOLUTIONS
// 1. If cows could only meet if they were diagonally adjacent.
//        grass[] arr = new grass[N * M];
//
//        for (int a = 0; a < j; a ++){                     // (looping through all the grass blocks)
//            int r = arr[a].r, c = arr[a].c;
//            if (r - 1 >= 0 && c + 1 < M && field[r][c + 1] == 'C' && field[r - 1][c] == 'C' && cow_cow[r][c][0] != 1) {
//                cow_cow[r - 1][c + 1][2] = 3;
//                counter ++;
//            }
//            else if (r - 1 >= 0 && c - 1 >= 0 && field[r][c - 1] == 'C' && field[r - 1][c] == 'C' && cow_cow[r][c][1] != 2) {
//                cow_cow[r - 1][c - 1][3] = 4;
//                counter ++;
//            }
//            else if (r + 1 < N && c - 1 >= 0 && field[r][c - 1] == 'C' && field[r + 1][c] == 'C' && cow_cow[r][c][2] != 3) {
//                cow_cow[r + 1][c - 1][0] = 1;
//                counter ++;
//            }
//            else if (r + 1 < N && c + 1 < M && field[r][c + 1] == 'C' && field[r + 1][c] == 'C' && cow_cow[r][c][3] != 4) {
//                cow_cow[r + 1][c + 1][1] = 2;
//                counter ++;
//            }
//
//        }

//  2. If cows could only meet if they were vertically adjacent or on the same row.
//        for (int i = 0; i < j; i ++){
//            int a = arr[i].r, b = arr[i].c;
//           if (a - 1 >= 0 && a + 1 < N && field[a - 1][b] == 'C' && field[a + 1][b] == 'C') {
//               counter ++;
//               grass1[a] --;
//           }
//        }
//        for (int i = 0; i < N; i ++){
//            sum = cows[i]*(cows[i] - 1)/2;
//            counter += Math.min(sum, grass1[i]);
//        }
//        System.out.println(counter);
