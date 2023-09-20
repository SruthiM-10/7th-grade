package USACOPrograms;
import java.io.*;

//2016 December Contest (Bronze) --> Also USACO Guide (Section 1.3 Problem 8)

public class BlockGame {
    public static void main (String[] args) throws IOException{
        BufferedReader scan = new BufferedReader (new FileReader ("blocks.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter ("blocks.out"));
        int N = Integer.parseInt(scan.readLine());
        int[] letters = new int[26];
        for (int l = 0; l < N; l++){
            String s = scan.readLine();
            int[] card1 = new int[26];
            int[] card2 = new int[26];
            String[] cards = s.split(" ");
            for (int i = 0; i < cards[0].length(); i++){
                int pos = cards[0].charAt(i) - 'a';
                card1[pos] ++;
            }
            for (int i = 0; i < cards[1].length(); i++){
                int pos = cards[1].charAt(i) - 'a';
                card2[pos] ++;
            }
            for (int i = 0; i < 26; i ++){
                letters[i] += Math.max(card1[i], card2[i]);
            }
        }
        for (int i = 0; i < 25; i ++){
            write.write(letters[i] + "\n");
        }
        write.write(String.valueOf(letters[25]));
        write.close();
    }
}
