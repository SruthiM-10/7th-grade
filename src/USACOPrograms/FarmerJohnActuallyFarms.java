package USACOPrograms;
import java.util.*;

//USACO 2023 December Contest

public class FarmerJohnActuallyFarms {
    static class Plants{
        long height, growth;
        int taller;
    }
    static class rank implements Comparator <Plants>{
        public int compare (Plants a, Plants b){
            return b.taller - a.taller;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int i = 0; i < T; i ++){
            int N = scan.nextInt();
            long mindays = 0;
            double limit = Double.MAX_VALUE;
            ArrayList<Plants> plants = new ArrayList<>();
            for (int x = 0; x < N; x ++){
                plants.add(new Plants());
                plants.get(x).height = scan.nextLong();
            }
            for (int x = 0; x < N; x ++){
                plants.get(x).growth = scan.nextLong();
            }
            for (int x = 0; x < N; x ++){
                plants.get(x).taller = scan.nextInt();
            }
            Collections.sort(plants, new rank());
            for (int x = N - 1; x > 0; x --){
                long y1 = plants.get(x - 1).height - plants.get(x).height;
                long y2 = plants.get(x).growth - plants.get(x - 1).growth;
                if (plants.get(x - 1).growth < plants.get(x).growth) {
                    if (plants.get(x - 1).height >= plants.get(x).height) {
                        mindays = (long) Math.max(mindays, Math.ceil((double) (y1 + 1) / y2));
                        if (mindays >= limit){ mindays = -1; break; }
                    }
                }
                else if (plants.get(x - 1).growth > plants.get(x).growth){
                    if (plants.get(x - 1).height < plants.get(x).height) {
                        limit = (double) y1/y2;
                        if (mindays >= limit){ mindays = -1; break; }
                    }
                    else{ mindays = -1; break; }
                }
                else if (plants.get(x - 1).height >= plants.get(x).height){
                    mindays = -1; break;
                }
            }
            System.out.println(mindays);
        }
    }
}
