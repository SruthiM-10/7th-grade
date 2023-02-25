package USACOPrograms;
import java.util.*;

//USACO Problem 2023 Jan Contest (Bronze)

public class AirCownditioning2 {
    static class cow {
        int start;
        int end;
        int change;
    }

    static class airCow {
        int start;
        int end;
        int change;
        int cost;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(), M = scan.nextInt();
        cow[] Cows = new cow[N];
        airCow[] airCows = new airCow[M];
        for (int i = 0; i < N; i++) {
            Cows[i] = new cow();
            Cows[i].start = scan.nextInt();
            Cows[i].end = scan.nextInt();
            Cows[i].change = scan.nextInt();
        }
        for (int i = 0; i < M; i++) {
            airCows[i] = new airCow();
            airCows[i].start = scan.nextInt();
            airCows[i].end = scan.nextInt();
            airCows[i].change = scan.nextInt();
            airCows[i].cost = scan.nextInt();
        }
        int answer = Integer.MAX_VALUE;
        for (int a = 0; a < 1 << M; a++) {
            int[] stalls = new int[101];
            int totalCost = 0;
            for (int b = 0; b < M; b++) {
                if ((a & (1 << b)) != 0){
                    totalCost += airCows[b].cost;
                    for (int x = airCows[b].start; x <= airCows[b].end; x++) {
                        stalls[x] += airCows[b].change;
                    }
                }
            }
            boolean works = true;
            for (int b = 0; b < N; b++) {
                if(!works) break;
                for (int x = Cows[b].start; x <= Cows[b].end; x++) {
                    if (stalls[x] < Cows[b].change) {
                        works = false;
                        break;
                    }
                }
            }
            if (works) {
                answer = Math.min(answer, totalCost);
            }
        }
        System.out.println(answer);
    }
}
    // BOGUS SOLUTION -->>
//        int ans = Integer.MAX_VALUE, minStart = Integer.MAX_VALUE, maxEnd = Integer.MIN_VALUE, changeTot = Integer.MAX_VALUE;
//        int cost = 0;
//        boolean flag = false;
//        for (int a = 0; a < 2; a++) {
////            if (a == 0 && cost > 0) cost -= airCows[0].cost;
//            if (a == 1){
//            if (airCows[0].start < minStart) minStart = airCows[0].start;
//            if (airCows[0].end > maxEnd) maxEnd = airCows[0].end;  changeTot = Math.min(airCows[0].change, changeTot);}
//            for (int b = 0; b < 2; b++) {
////                if (b == 0 && cost > 0) cost -= airCows[1].cost;
//                if (b == 1){
//                if (airCows[1].start < minStart) minStart = airCows[1].start;
//                if (airCows[1].end > maxEnd) maxEnd = airCows[1].end;  changeTot = Math.min(airCows[1].change, changeTot);}
//                for (int c = 0; c < 2; c++) {
//                    if (c == 1){
//                    if (airCows[2].start < minStart) minStart = airCows[2].start;
//                    if (airCows[2].end > maxEnd) maxEnd = airCows[2].end; changeTot = Math.min(airCows[2].change, changeTot); }
//                    for (int d = 0; d < 2; d++) {
//                        if (d == 1){
//                        if (airCows[3].start < minStart) minStart = airCows[3].start;
//                        if (airCows[3].end > maxEnd) maxEnd = airCows[3].end; changeTot = Math.min(airCows[3].change, changeTot);}
//                        for (int e = 0; e < 2; e++) {
//                            if (M > 4 && e == 1){
//                            if (airCows[4].start < minStart) minStart = airCows[4].start;
//                            if (airCows[4].end > maxEnd) maxEnd = airCows[4].end; changeTot = Math.min(airCows[4].change, changeTot); }
//                            for (int f = 0; f < 2; f++) {
//                                if (f == 1 && M > 5){
//                                if (airCows[5].start < minStart) minStart = airCows[5].start;
//                                if (airCows[5].end > maxEnd) maxEnd = airCows[5].end; changeTot = Math.min(airCows[5].change, changeTot); }
//                                for (int g = 0; g < 2; g++) {
//                                    if (g == 1 && M > 6){
//                                    if (airCows[6].start < minStart) minStart = airCows[6].start;
//                                    if (airCows[6].end > maxEnd) maxEnd = airCows[6].end; changeTot = Math.min(airCows[6].change, changeTot);}
//                                    for (int h = 0; h < 2; h++) {
//                                        if (h == 1 && M > 7){
//                                        if (airCows[7].start < minStart) minStart = airCows[7].start;
//                                        if (airCows[7].end > maxEnd) maxEnd = airCows[7].end; changeTot = Math.min(airCows[7].change, changeTot);}
//                                        for (int i = 0; i < 2; i++) {
//                                            if (i == 1 && M > 8){
//                                            if (airCows[8].start < minStart) minStart = airCows[8].start;
//                                            if (airCows[8].end > maxEnd) maxEnd = airCows[8].end; changeTot = Math.min(airCows[8].change, changeTot); }
//                                            for (int j = 0; j < 2; j++) {
//                                                if (j == 1 && M > 9){
//                                                if (airCows[9].start < minStart) minStart = airCows[9].start;
//                                                if (airCows[9].end > maxEnd) maxEnd = airCows[9].end; changeTot = Math.min(airCows[9].change, changeTot); }
//                                                for (int x = 0; x < N; x++) {
//                                                    flag = false;
//                                                    if (minStart <= Cows[x].start && maxEnd >= Cows[x].end) {
//                                                        if (changeTot >= Cows[x].change){
//                                                            flag = true;
//                                                        }
//                                                    }
//                                                    if (!flag) break;
//                                                }
//                                                if (flag) {
//                                                    if (a == 1) cost += airCows[0].cost;
//                                                    if (b == 1) cost += airCows[1].cost;
//                                                    if (c == 1) cost += airCows[2].cost;
//                                                    if (d == 1) cost += airCows[3].cost;
//                                                    if (e == 1 && M >4) cost += airCows[4].cost;
//                                                    if (f == 1 && M >5) cost += airCows[5].cost;
//                                                    if (g == 1&& M >6) cost += airCows[6].cost;
//                                                    if (h == 1 && M > 7) cost += airCows[7].cost;
//                                                    if (i == 1 && M > 8) cost += airCows[8].cost;
//                                                    if (j == 1 && M > 9) cost += airCows[9].cost;
//                                                    ans = cost;
//                                                    cost = 0;
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        System.out.println(ans);
//    }
