package ACSLPrograms;

import java.util.*;

//Contest 3 2022-23

public class TreeCreation {
    static class compA implements Comparator<LetVal>{
        public int compare (LetVal a, LetVal b){
            return a.value - b.value;
        }
    }
    static class LetVal{
        String letter;
        int value;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String ans = listByValue(input);
        System.out.println(ans);
    }
    public static String listByValue(String input) {
        ArrayList<String> letters = new ArrayList<>();
        ArrayList<Integer> values = new ArrayList<>();

        String[] arr = input.split("");

        for (int i = 0; i < input.length(); i ++){
            int len = letters.size();
            for (int a = 0; a < len; a ++){
                if (a == 0){
                    if (arr[i].compareTo(letters.get(a)) > 0){
                        if (len == 1 || arr[i].compareTo(letters.get(a+1)) <= 0){
                            if (len != 1)
                                values.add(a + 1, 1 + Math.max(values.get(a), values.get(a + 1)));
                            if (len == 1) values.add(a + 1, values.get(a) + 1);
                            letters.add(a + 1, arr[i]);
                            break; }
                    }
                    else{
                        values.add(a, 1 + values.get(a));
                        letters.add(a, arr[i]);
                        break;
                    }
                }
                else if (a == len - 1){
                    letters.add(a + 1, arr[i]);
                    values.add(a + 1, values.get(a) + 1);
                    break;
                }
                else if (letters.get(a).compareTo(arr[i]) < 0 &&
                        arr[i].compareTo(letters.get(a + 1)) <= 0){
                    letters.add(a + 1, arr[i]);
                    values.add(a + 1, 1 + Math.max(values.get(a),
                            values.get(a + 1)));
                    break;
                }
            }
            if (len == 0){
                letters.add(arr[i]);
                values.add(0);
            }
        }
        LetVal[] parallel_arr = new LetVal[input.length()];
        for (int i = 0; i < input.length(); i ++){
            parallel_arr[i] = new LetVal();
            parallel_arr[i].letter = letters.get(i);
            parallel_arr[i].value = values.get(i);
        }
        Arrays.sort(parallel_arr, new compA());
        String ans = "";
        for (int i = 0; i < input.length(); i ++){
            ans += parallel_arr[i].letter;
        }
        return ans;
    }
}
