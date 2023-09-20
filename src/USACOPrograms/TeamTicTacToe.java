package USACOPrograms;
import java.io.*;

//2018 US Open Contest (Bronze) --> Also USACO Guide (Section 1.3 Problem 9)

public class TeamTicTacToe {
    public static void main(String[] args) throws IOException{
        BufferedReader scan = new BufferedReader (new FileReader ("tttt.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter ("tttt.out"));

        char[][] grid = new char[3][3];
        boolean[][] cows = new boolean[26][26];
        boolean[] cow = new boolean[26];

        for(int i = 0; i < 3; i ++){
            String s = scan.readLine();
            for (int j = 0; j < 3; j ++){
                grid[i][j] = s.charAt(j);
            }
        }

        int victory = 0, teams = 0;

        //rows
        for (int i = 0; i < 3; i ++){
            int[] alphabet = new int[26];
            for (int j = 0; j < 3; j ++){
                int pos = grid[i][j] - 'A';
                alphabet[pos] ++;
            }
            for (int a = 0; a < 26; a ++){
                if (alphabet[a] == 3 && !cow[a]) {
                    victory++;
                    cow[a] = true;
                    break;
                }
                if (alphabet[a] == 2) {
                    for (int b = 0; b < 3; b ++){
                        if (grid[i][b] != (a + 'A') && !cows[a][grid[i][b] - 'A']) {
                            teams++;
                            cows[a][grid[i][b] - 'A'] = true;
                            cows[grid[i][b] - 'A'][a] = true;
                            break;
                        }
                    }
                }
            }
        }

        //columns
        for (int i = 0; i < 3; i ++){
            int[] alphabet = new int[26];
            for (int j = 0; j < 3; j ++){
                int pos = grid[j][i] - 'A';
                alphabet[pos] ++;
            }
            for (int a = 0; a < 26; a ++){
                if (alphabet[a] == 3 && !cow[a]) {
                    victory++;
                    cow[a] = true;
                    break;
                }
                if (alphabet[a] == 2) {
                    for (int b = 0; b < 3; b ++){
                        if (grid[b][i] != (a + 'A') && !cows[a][grid[i][b] - 'A']) {
                            teams++;
                            cows[a][grid[i][b] - 'A'] = true;
                            cows[grid[i][b] - 'A'][a] = true;
                            break;
                        }
                    }
                }
            }
        }

        //diagonal1
        int[] alphabet = new int[26];
        for (int i = 0; i < 3; i ++) {
            int pos = grid[i][i] - 'A';
            alphabet[pos]++;
        }
        for (int a = 0; a < 26; a ++){
            if (alphabet[a] == 3 && !cow[a]) {
                victory++;
                cow[a] = true;
                break;
            }
            if (alphabet[a] == 2) {
                for (int b = 0; b < 3; b ++){
                    if (grid[b][b] != (a + 'A') && !cows[a][grid[b][b] - 'A']) {
                        teams++;
                        cows[a][grid[b][b] - 'A'] = true;
                        cows[grid[b][b] - 'A'][a] = true;
                        break;
                    }
                }
            }
        }
        //diagonal2
        alphabet = new int[26];
        for (int i = 0; i < 3; i ++) {
            int pos = grid[i][2 - i] - 'A';
            alphabet[pos]++;
        }
        for (int a = 0; a < 26; a ++){
            if (alphabet[a] == 3 && !cow[a]) {
                victory++;
                cow[a] = true;
                break;
            }
            if (alphabet[a] == 2) {
                for (int b = 0; b < 3; b ++){
                    if (grid[b][2 - b] != (a + 'A') && !cows[a][grid[b][2 - b] - 'A']) {
                        teams++;
                        cows[a][grid[b][2 - b] - 'A'] = true;
                        cows[grid[b][2 - b] - 'A'][a] = true;
                        break;
                    }
                }
            }
        }

        write.write(victory + "\n");
        write.write(String.valueOf(teams));
        write.close();
    }
}
