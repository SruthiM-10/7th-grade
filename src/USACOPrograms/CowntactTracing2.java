package USACOPrograms;
import java.util.*;

//USACO 2023 December Contest

public class CowntactTracing2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(), count = 0, start, end, days = Integer.MAX_VALUE;
        int answer = 0;
        ArrayList<Integer> groups = new ArrayList<>();
        scan.nextLine();
        String s = scan.nextLine();
        for (int i = 0; i < N; i ++){
            if(s.charAt(i) == '1')
                count ++;
            else{
                if (count > 0) groups.add(count);
                count = 0;
            }
        }
        if (count > 0) groups.add(count);
        if (s.charAt(0) == '1'){
            start = 1;
            days = groups.get(0) - 1;
        } else start = 0;
        if (s.charAt(N-1) == '1'){
            end = 1;
            days = Math.min(days, groups.get(groups.size() - 1) - 1);
        } else end = 0;
        for (int i = start; i < groups.size() - end; i ++){
            if (groups.get(i) % 2 == 0) days = Math.min(days, (groups.get(i) - 2)/2);
            else days = Math.min(days, (groups.get(i) - 1)/2);
        }
        for (int i = 0; i < groups.size(); i ++){
            answer += Math.ceil((double) groups.get(i)/(2*days + 1));
        }
        System.out.println(answer);
    }
}
