import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < num.length(); i++) {
            numbers.add(num.charAt(i)-'0');
        }

        Collections.sort(numbers);

        for (int i=numbers.size()-1; i >=0; i--) {
            System.out.print(numbers.get(i));
        }
    }
}
