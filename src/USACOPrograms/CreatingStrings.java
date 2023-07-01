package USACOPrograms;
import java.util.*;

//USACO Guide (Section 2.2 Example 2 -- Permutations)

public class CreatingStrings {
    static String s;
    static ArrayList<String> list = new ArrayList<>();
    static int[] charCount = new int[26];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        s = scan.nextLine();
        for (int i = 0; i < s.length(); i ++){
            charCount[s.charAt(i) - 'a'] ++;
        }
        buildPermutation("");
        System.out.println(list.size());
        for (String a : list) System.out.println(a);
    }
    static void buildPermutation(String permutation){
        if (permutation.length() == s.length()){
            list.add(permutation);
            return;
        }
        for (int i = 0; i < 26; i ++){
            if (charCount[i] > 0){
                charCount[i] --;
                buildPermutation(permutation + (char)(i + 'a'));
                charCount[i] ++;
            }
        }
    }
}
