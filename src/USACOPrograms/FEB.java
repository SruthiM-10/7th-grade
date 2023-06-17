package USACOPrograms;
import java.util.*;

//USACO Problem 2023 March (US Open) Contest Bronze

public class FEB {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();
        String s = scan.nextLine();

        int min_sum = 0, max_sum = 0;
        int index = 0, endIndex = 0, countF = 0;


        if (s.charAt(index) == 'F'){
            while (index < N && s.charAt(index) == 'F'){ index ++; countF ++; }
            if (index == N) max_sum += N - 1;
            else max_sum += countF;
        }
        while (index < N){  //index can never start on an F due to the previous loop
            endIndex = index + 1;

            while (endIndex < N && s.charAt(endIndex) == 'F'){ endIndex ++;} //until endIndex isn't an F
            if (endIndex == N) break;
            int numF = endIndex - index - 1;

            if (s.charAt(endIndex) == s.charAt(index)){   //Applies if numF is 0 as well! Then, you are just doing mundane linear comparison.
                if (numF % 2 == 0) min_sum += 1;
                max_sum += numF + 1;
            }
            else {
                if (numF % 2 != 0) min_sum += 1;
                max_sum += numF;
            }
            index = endIndex;
        }

        int countF_end = 0;
        if (endIndex == N){
            endIndex --;
            while (endIndex >= 0 && s.charAt(endIndex) == 'F'){ endIndex --; countF_end ++; } //If last character is F
            if (endIndex != 0) max_sum += countF_end;
        }


        if (countF_end == 0 && countF == 0) {
            System.out.println((max_sum - min_sum)/2 + 1);
            for (int i = min_sum; i <= max_sum; i += 2) {
                System.out.println(i);
            }
        }
        else{ //The starting and end F's can allow you to have the sums that the middle F's were not able to have (even if there is only one starting/ending F
            System.out.println((max_sum - min_sum) + 1);
            for (int i = min_sum; i <= max_sum; i ++){
                System.out.println(i);
            }
        }
    }
    public static void BogusSolution() { //made an arraylist to store possible values instead of looking for patterns then just finding min/max values
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();
        String s = scan.nextLine();
        char[] str = new char[s.length()];
        for (int i = 0; i < s.length(); i ++){
            str[i] = s.charAt(i);
        }
        ArrayList<Integer> sum_poss = new ArrayList<>();
        int sum_const = 0;
        for (int i = 0; i < N - 1; i ++){
            if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i) != 'F'){ sum_const ++;}
        }
        sum_poss.add(sum_const);
        int j = 0;
        for (int i = 0; i < N; i ++){
            if (str[i] == 'F'){
                int cons = sum_poss.get(j);
                int size = sum_poss.size();
                if (i == 0){
                    sum_poss.add(sum_poss.get(j) + 1);
                    int end = i;
                    while (end + 1 < N && str[end + 1] == 'F') {
                        end++;
                    }
                    if (str[i + 1] == 'F'){
                        for (int a = 0; a <= end - i + 2; a++) {
                            if ((end - i + 1) % 2 == 0 && a % 2 == 0) {
                                sum_poss.add(cons + a);
                            } else if ((end - i + 1) % 2 != 0 && a % 2 != 0) {
                                sum_poss.add(cons + a);
                            }
                        }
                        i ++;
                    }
                }
                else if (i == N - 1){
                    sum_poss.add(sum_poss.get(j) + 1);
                }
                else if (i < N - 1){
                    if (str[i - 1] == str[i + 1] && str[i - 1] != 'F') sum_poss.add(sum_poss.get(j) + 2);
                    else if (str[i - 1] != str[i + 1] && str[i - 1] != 'F'){
                        for (int a = 0; a < size; a ++){
                            sum_poss.set(a, sum_poss.get(a) + 1);
                        }
                    }
                    else if (str[i + 1] == 'F'){
                        int end = i;
                        while (end + 1 < N && str[end + 1] == 'F') {
                            end++;
                        }
                        if (str[end + 1] != str[i - 1]) {
                            for (int a = 0; a <= end - i + 2; a++) {
                                if ((end - i + 1) % 2 == 0 && a % 2 == 0) {
                                    sum_poss.add(cons + a);
                                } else if ((end - i + 1) % 2 != 0 && a % 2 != 0) {
                                    sum_poss.add(cons + a);
                                }
                            }
                            i = end + 1;
                        }
                        else if (str[end + 1] == str[i - 1]) {
                            for (int a = 0; a <= end - i + 2; a++) {
                                if ((end - i + 1) % 2 != 0 && a % 2 == 0) {
                                    sum_poss.add(cons + a);
                                } else if ((end - i + 1) % 2 == 0 && a % 2 != 0) {
                                    sum_poss.add(cons + a);
                                }
                            }
                            i = end + 1;
                        }
                    }
                }
            }
        }

        Collections.sort(sum_poss);
        Set<Integer> poss = new HashSet<>(sum_poss);

        System.out.println(poss.size());

        for (Integer a: poss){
            if (a != 0) System.out.println(a);
        }
    }
}
