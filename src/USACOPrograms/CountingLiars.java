package USACOPrograms;
import java.util.*;

//2022 US Open Contest (Bronze), also USACO Guide (Section 5 Problem 4)

public class CountingLiars {
    static class Cows{
        String direction;
        int pi;
    }
    static class Cow implements Comparator<Cows>{
        public int compare(Cows a, Cows b){
            return a.pi - b.pi ;
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();
        Cows[] info = new Cows[N];
        for (int i = 0; i < N; i ++){
            info[i] = new Cows();
            String s = scan.nextLine();
            String[] arr = s.split(" ");
            if (arr[0].equals("G")) info[i].direction = "G";
            if (arr[0].equals("L")) info[i].direction = "L";
            info[i]. pi = Integer.parseInt(arr[1]);
        }
        Arrays.sort(info, new Cow());
        //sorting through if Bessie was at position of cow i
        //how many cows would be lying in each case and which is minimum
        int[] lying_left = new int[N];
        for (int i = 1; i < N; i ++){
            lying_left[i] += lying_left[i-1];
            if (info[i-1].direction.equals("L") && info[i - 1].pi < info[i].pi) lying_left[i]++;
        }
        int[] lying_right = new int[N];
        for (int i = N - 2; i >= 0; i --){
            lying_right[i] += lying_right[i + 1];
            if (info[i + 1].direction.equals("G") && info[i].pi < info[i+1].pi) lying_right[i] ++;
        }

        int minLiars = N;
        for (int i = 0; i < N; i ++){
            minLiars = Math.min(minLiars, lying_left[i] + lying_right[i]);
        }
        System.out.println(minLiars);
    }
}
