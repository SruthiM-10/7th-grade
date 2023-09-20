package USACOPrograms;
import java.io.*;

//2019 February Contest (Bronze) --> Also USACO Guide (Section 1.3 Problem 6)

public class MeasuringTraffic {
    static final int LARGE = (int)Math.pow(10, 9);
    static class Highway{
        String type;
        int lower, upper;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader scan = new BufferedReader (new FileReader ("traffic.in"));
        BufferedWriter write = new BufferedWriter (new FileWriter ("traffic.out"));
        int N = Integer.parseInt(scan.readLine());
        Highway[] section = new Highway[N];
        for (int i = 0; i < N; i ++){
            section[i] = new Highway();
            String s = scan.readLine(); String[] arr = s.split(" ");
            section[i].type = arr[0];
            section[i].lower = Integer.parseInt(arr[1]); section[i].upper = Integer.parseInt(arr[2]);
        }
        int final_lower = -LARGE, final_upper = LARGE;
        boolean flag = true;
        for (int i = 0; i < N; i ++){
            if (section[i].type.equals("on") && !flag){
                final_lower += section[i].lower; final_upper += section[i].upper;
            }
            if (section[i].type.equals("off") && !flag){
                final_lower -= section[i].upper; final_upper -= section[i].lower;
                final_lower = Math.max(0, final_lower);
            }
            if(section[i].type.equals("none")) {
                if (flag) flag = false;
                if (section[i].lower > final_lower) final_lower = section[i].lower;
                if (section[i].upper < final_upper) final_upper = section[i].upper;
            }
        }

        int initial_lower = -LARGE, initial_upper = LARGE;
        for (int i = N - 1; i >= 0; i --){
            if (section[i].type.equals("off")){
                initial_lower += section[i].lower; initial_upper += section[i].upper;
            }
            if (section[i].type.equals("on")){
                initial_lower -= section[i].upper; initial_upper -= section[i].lower;
                initial_lower = Math.max(0, initial_lower);
            }
            if(section[i].type.equals("none")){
                if (section[i].lower > initial_lower) initial_lower = section[i].lower;
                if (section[i].upper < initial_upper) initial_upper = section[i].upper;
            }
        }
        write.write(initial_lower + " " + initial_upper + "\n");
        write.write(final_lower + " " + final_upper);
        write.close();
    }
}
