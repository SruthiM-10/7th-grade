package USACOPrograms;
import java.util.*;

//2021 Feb Contest (Bronze)

public class YearOfTheCow {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();

        ArrayList<String> calendar = new ArrayList<>(
                Arrays.asList("Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat"));
        HashMap<String, Integer> cows = new HashMap<>();
        cows.put("Bessie", 0);

        for (int i = 0; i < N; i ++){
            String[] arr = new String[]{scan.next(), scan.next(), scan.next(), scan.next(), scan.next(), scan.next(), scan.next(), scan.next()};
            int x = cows.get(arr[7]);
            int newIndex = calendar.indexOf(arr[4]), oldIndex = (x % 12 + 12) % 12;

            if (arr[3].equals("next")){
                if (newIndex <= oldIndex) x += 12 + newIndex - oldIndex;
                else x += newIndex - oldIndex;
            }
            else{
                if (oldIndex <= newIndex) x -= 12 + oldIndex - newIndex;
                else x -= oldIndex - newIndex;
             }
            cows.put(arr[0], x);
        }
        System.out.println(Math.abs(cows.get("Elsie")));
    }
}
