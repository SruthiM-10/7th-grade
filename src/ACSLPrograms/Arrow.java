package ACSLPrograms;
import java.util.*;

//Contest 4 2022-23

public class Arrow {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();
        String targets = scan.nextLine();
        System.out.println(arrowForMostTargets(N, targets));
    }
    public static String arrowForMostTargets(int size, String targets) {
            String ans = "";

            ArrayList<String> arr = new ArrayList<String>(Arrays.asList(targets.split(" ")));
            String[][] grid = new String[size][size];
            for (int i = 0; i < arr.size(); i ++){
                int r = arr.get(i).charAt(0) - '0', c = arr.get(i).charAt(1) - '0';
                grid[r][c] = "x";
            }

            String[][] adjacent = new String[arr.size()][8];
            for (int i = 0; i < arr.size(); i ++){
                int r = arr.get(i).charAt(0) - '0', c = arr.get(i).charAt(1) - '0';
                if (c - 1 > 0 && grid[r][c-1] == "x") adjacent[i][0] = ((r) + "") + ((c - 1) + "");
                if (r - 1 > 0 && grid[r - 1][c] == "x") adjacent[i][1] = ((r - 1) + "") + ((c) + "");
                if (c + 1 < size - 1 && grid[r][c + 1] == "x") adjacent[i][2] = (r + "") + ((c + 1) + "");
                if (r + 1 < size - 1 && grid[r + 1][c] == "x") adjacent[i][3] = ((r + 1) + "") + (c + "");
                if (r - 1 > 0 && c - 1 > 0 && grid[r - 1][c - 1] == "x")
                    adjacent[i][4] = ((r - 1) + "") + ((c - 1) + "");
                if (r - 1 > 0  && c + 1 < size - 1 && grid[r - 1][c + 1] == "x")
                    adjacent[i][5] = ((r - 1) + "") + ((c + 1) + "");
                if (r + 1 < size - 1 && c + 1 < size - 1 && grid[r + 1][c + 1] == "x")
                    adjacent[i][6] = ((r + 1) + "") + ((c + 1) + "");
                if (r + 1 < size - 1 && c - 1 > 0 && grid[r + 1][c - 1] == "x")
                    adjacent[i][7] = ((r + 1) + "") + ((c - 1) + "");
            }

            int count = 0;
            for (int r = 1; r < size - 1; r ++){//chosen row of target (same for arrow)
                int c;                           //A arrow
                int count2 = 0;
                ArrayList<Character> arr2 = new ArrayList<>();
                for (int i = 0; i < arr.size(); i ++){
                    if ((arr.get(i).charAt(0) - '0') == r){ arr2.add(arr.get(i).charAt(1)); }
                }
                Collections.sort(arr2);
                if (arr2.size() > 0){
                    c = arr2.get(arr2.size() - 1) - '0';
                    String ans2 = r + "" + (size - 1) + "" + "A";
                    count2 ++;
                    int index = arr.indexOf((r + "") + (c + ""));
                    while (adjacent[index][0] != null){
                        count2 ++;
                        try { index = arr.indexOf(adjacent[index][0]);}
                        catch (Exception e) { break; }
                    }
                    if (count2 > count){
                        ans = ans2;
                        count = count2;
                    }
                    else if (count2 == count){
                        if (ans2.compareTo(ans) < 0) ans = ans2;
                    }
                }
                //C Arrow
                count2 = 0;
                arr2 = new ArrayList<>();
                for (int i = 0; i < arr.size(); i ++){
                    if ((arr.get(i).charAt(0) - '0') == r){ arr2.add(arr.get(i).charAt(1)); }
                }
                Collections.sort(arr2);
                if (arr2.size() > 0){
                    c = arr2.get(0) - '0';
                    String ans2 = r + "" + 0 + "" + "C";
                    count2 ++;
                    int index = arr.indexOf((r + "") + (c + ""));
                    while (adjacent[index][2] != null){
                        count2 ++;
                        try { index = arr.indexOf(adjacent[index][2]);}
                        catch (Exception e) { break; }
                    }
                    if (count2 > count){
                        ans = ans2;
                        count = count2;
                    }
                    else if (count2 == count){
                        if (ans2.compareTo(ans) < 0) ans = ans2;
                    }
                }
            }
            for (int c = 1; c < size - 1; c ++){ //chosen column of target
                int r;                         //B arrow
                int count2 = 0;
                ArrayList<Character> arr2 = new ArrayList<>();
                for (int i = 0; i < arr.size(); i ++){
                    if ((arr.get(i).charAt(1) - '0') == c){ arr2.add(arr.get(i).charAt(0));}
                }
                Collections.sort(arr2);
                if (arr2.size() > 0){
                    r = arr2.get(arr2.size() - 1) - '0';
                    String ans2 = (size - 1) + "" + c + "" + "B";
                    count2 ++;
                    int index = arr.indexOf((r + "") + (c + ""));
                    while (adjacent[index][1] != null){
                        count2 ++;
                        try { index = arr.indexOf(adjacent[index][1]);}
                        catch (Exception e) { break; }
                    }
                    if (count2 > count){
                        ans = ans2;
                        count = count2;
                    }
                    else if (count2 == count){
                        if (ans2.compareTo(ans) < 0) ans = ans2;
                    }
                }
                //D Arrow
                count2 = 0;
                arr2 = new ArrayList<>();
                for (int i = 0; i < arr.size(); i ++){
                    if ((arr.get(i).charAt(1) - '0') == c) arr2.add(arr.get(i).charAt(0));
                }
                Collections.sort(arr2);
                if (arr2.size() > 0){
                    r = arr2.get(0) - '0';
                    String ans2 = 0 + "" + c + "" + "D";
                    count2 ++;
                    int index = arr.indexOf((r + "") + (c + ""));
                    while (adjacent[index][3] != null){
                        count2 ++;
                        try { index = arr.indexOf(adjacent[index][3]);}
                        catch (Exception e) { break; }
                    }
                    if (count2 > count){
                        ans = ans2;
                        count = count2;
                    }
                    else if (count2 == count){
                        if (ans2.compareTo(ans) < 0) ans = ans2;
                    }
                }
            }
            for (int c = 0; c < size; c ++){ //chosen column of arrow
                if (c < size - 2){                 //F Arrow Part 1
                    int r_tar;
                    int count2 = 0;
                    ArrayList<Integer> arr2 = new ArrayList<>();
                    for (int i = 0; i < arr.size(); i ++){
                        float slope = (float)((arr.get(i).charAt(0) - '0') - (size - 1))/((arr.get(i).charAt(1) - '0') - c);
                        if (slope == -1){ arr2.add(arr.get(i).charAt(0) - '0');}
                    }
                    Collections.sort(arr2);
                    if (arr2.size() > 0){
                        r_tar = arr2.get(arr2.size() - 1);
                        String ans2 = (size - 1) + "" + c + "" + "F";
                        count2 ++;
                        int c_arr = c;
                        c = c_arr - (r_tar - (size - 1));
                        int index = arr.indexOf((r_tar + "") + (c + ""));

                        while (adjacent[index][5] != null){
                            count2 ++;
                            try { index = arr.indexOf(adjacent[index][5]);}
                            catch (Exception ArrayIndexOutOfBoundsException) { break; }
                        }
                        if (count2 > count){
                            ans = ans2;
                            count = count2;
                        }
                        else if (count2 == count){
                            if (ans2.compareTo(ans) < 0) ans = ans2;
                        }
                        c = c_arr;
                        //G Arrow Part1
                        count2 = 0;
                        arr2 = new ArrayList<>();
                        for (int i = 0; i < arr.size(); i ++){
                            float slope = (float)(arr.get(i).charAt(0) - '0')/((arr.get(i).charAt(1) - '0') - c);
                            if (slope == 1){ arr2.add(arr.get(i).charAt(0) - '0');}
                        }
                        Collections.sort(arr2);
                        if (arr2.size() > 0){
                            r_tar = arr2.get(0);
                            ans2 = 0 + "" + c + "" + "G";
                            count2 ++;
                            c_arr = c;
                            c = c_arr + (r_tar - 0);
                            index = arr.indexOf((r_tar + "") + (c + ""));

                            while (adjacent[index][6] != null){
                                count2 ++;
                                try { index = arr.indexOf(adjacent[index][6]);}
                                catch (Exception ArrayIndexOutOfBoundsException) { break; }
                            }
                            if (count2 > count){
                                ans = ans2;
                                count = count2;
                            }
                            else if (count2 == count){
                                if (ans2.compareTo(ans) < 0) ans = ans2;
                            }
                            c = c_arr;
                        }
                    }
                }
                if (c > 0){
                    int r_tar;       //E Arrow Part 1
                    int count2 = 0;
                    ArrayList<Integer> arr2 = new ArrayList<>();
                    for (int i = 0; i < arr.size(); i ++){
                        float slope = (float)((arr.get(i).charAt(0) - '0') - (size - 1))/((arr.get(i).charAt(1) - '0') - c);
                        if (slope == 1){ arr2.add(arr.get(i).charAt(0) - '0');}
                    }
                    Collections.sort(arr2);
                    if (arr2.size() > 0){
                        r_tar = arr2.get(arr2.size() - 1);
                        String ans2 = (size - 1) + "" + c + "" + "E";
                        count2 ++;
                        int c_arr = c;
                        c = c_arr + (r_tar - (size - 1));
                        int index = arr.indexOf((r_tar + "") + (c + ""));

                        while (adjacent[index][4] != null){
                            count2 ++;
                            try { index = arr.indexOf(adjacent[index][4]);}
                            catch (Exception ArrayIndexOutOfBoundsException) { break; }
                        }
                        if (count2 > count){
                            ans = ans2;
                            count = count2;
                        }
                        else if (count2 == count){
                            if (ans2.compareTo(ans) < 0) ans = ans2;
                        }
                        c = c_arr;
                    }
                    //H Arrow Part 1
                    count2 = 0;
                    arr2 = new ArrayList<>();
                    for (int i = 0; i < arr.size(); i ++){
                        float slope = (float)((arr.get(i).charAt(0) - '0') - 0)/((arr.get(i).charAt(1) - '0') - c);
                        if (slope == -1){ arr2.add(arr.get(i).charAt(0) - '0');}
                    }
                    Collections.sort(arr2);
                    if (arr2.size() > 0){
                        r_tar = arr2.get(0);
                        String ans2 = 0 + "" + c + "" + "H";
                        count2 ++;
                        int c_arr = c;
                        c = c - (r_tar - 0);
                        int index = arr.indexOf((r_tar + "") + (c + ""));

                        while (adjacent[index][7] != null){
                            count2 ++;
                            try { index = arr.indexOf(adjacent[index][7]);}
                            catch (Exception ArrayIndexOutOfBoundsException) { break; }
                        }
                        if (count2 > count){
                            ans = ans2;
                            count = count2;
                        }
                        else if (count2 == count){
                            if (ans2.compareTo(ans) < 0) ans = ans2;
                        }
                        c = c_arr;
                    }
                }
            }
            for (int r = 0; r < size; r ++){ //chosen row of arrow
                if (r > 0){                 //F Arrow Part 2
                    int r_tar, c_tar;
                    int count2 = 0;
                    ArrayList<Integer> arr2 = new ArrayList<>();
                    for (int i = 0; i < arr.size(); i ++){
                        float slope = (float)((arr.get(i).charAt(0) - '0') - r)/((arr.get(i).charAt(1) - '0') - 0);
                        if (slope == -1){ arr2.add(arr.get(i).charAt(1) - '0');}
                    }
                    Collections.sort(arr2);
                    if (arr2.size() > 0){
                        c_tar = arr2.get(0);
                        String ans2 = r + "" + 0 + "" + "F";
                        count2 ++;
                        r_tar = r - (c_tar - 0);
                        int index = arr.indexOf((r_tar + "") + (c_tar + ""));

                        while (adjacent[index][5] != null){
                            count2 ++;
                            try { index = arr.indexOf(adjacent[index][5]);}
                            catch (Exception ArrayIndexOutOfBoundsException) { break; }
                        }
                        if (count2 > count){
                            ans = ans2;
                            count = count2;
                        }
                        else if (count2 == count){
                            if (ans2.compareTo(ans) < 0) ans = ans2;
                        }
                        count2 = 0;
                        arr2 = new ArrayList<>();
                        for (int i = 0; i < arr.size(); i ++){
                            float slope = (float)((arr.get(i).charAt(0) - '0') - r)/((arr.get(i).charAt(1) - '0') - (size - 1));
                            if (slope == 1){ arr2.add(arr.get(i).charAt(1) - '0');}
                        }
                        Collections.sort(arr2);
                        if (arr2.size() > 0){
                            c_tar = arr2.get(arr2.size() - 1);
                            ans2 = r + "" + (size - 1) + "" + "E";
                            count2 ++;
                            r_tar = r + (c_tar - (size - 1));
                            index = arr.indexOf((r_tar + "") + (c_tar + ""));

                            while (adjacent[index][4] != null){
                                count2 ++;
                                try { index = arr.indexOf(adjacent[index][4]);}
                                catch (Exception ArrayIndexOutOfBoundsException) { break; }
                            }
                            if (count2 > count){
                                ans = ans2;
                                count = count2;
                            }
                            else if (count2 == count){
                                if (ans2.compareTo(ans) < 0) ans = ans2;
                            }
                        }
                    }
                }
                if (r < size - 1){
                    int r_tar, c_tar; //G Arrow Part 2
                    int count2 = 0;
                    ArrayList<Integer> arr2 = new ArrayList<>();
                    for (int i = 0; i < arr.size(); i ++){
                        float slope = (float)((arr.get(i).charAt(0) - '0') - r)/((arr.get(i).charAt(1) - '0') - 0);
                        if (slope == 1){ arr2.add(arr.get(i).charAt(1) - '0');}
                    }
                    Collections.sort(arr2);
                    if (arr2.size() > 0){
                        c_tar = arr2.get(0);
                        String ans2 = r + "" + 0 + "" + "G";
                        count2 ++;
                        r_tar = r + (c_tar - 0);
                        int index = arr.indexOf((r_tar + "") + (c_tar + ""));

                        while (adjacent[index][6] != null){
                            count2 ++;
                            try { index = arr.indexOf(adjacent[index][6]);}
                            catch (Exception ArrayIndexOutOfBoundsException) { break; }
                        }
                        if (count2 > count){
                            ans = ans2;
                            count = count2;
                        }
                        else if (count2 == count){
                            if (ans2.compareTo(ans) < 0) ans = ans2;
                        }
                    }
                    //H Arrow Part 2
                    count2 = 0;
                    arr2 = new ArrayList<>();
                    for (int i = 0; i < arr.size(); i ++){
                        float slope = (float)((arr.get(i).charAt(0) - '0') - r)/((arr.get(i).charAt(1) - '0') - (size - 1));
                        if (slope == -1){ arr2.add(arr.get(i).charAt(1) - '0');}
                    }
                    Collections.sort(arr2);
                    if (arr2.size() > 0){
                        c_tar = arr2.get(arr2.size() - 1);
                        String ans2 = r + "" + (size - 1) + "" + "H";
                        count2 ++;
                        r_tar = r - (c_tar - (size - 1));
                        int index = arr.indexOf((r_tar + "") + (c_tar + ""));

                        while (adjacent[index][7] != null){
                            count2 ++;
                            try { index = arr.indexOf(adjacent[index][7]);}
                            catch (Exception ArrayIndexOutOfBoundsException) { break; }
                        }
                        if (count2 > count){
                            ans = ans2;
                            count = count2;
                        }
                        else if (count2 == count){
                            if (ans2.compareTo(ans) < 0) ans = ans2;
                        }
                    }
                }
            }
            return ans;
        }
}
