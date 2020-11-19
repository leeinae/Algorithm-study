import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11399_re {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int peopleCount = sc.nextInt();
        int[] person = new int[peopleCount];

        for (int i = 0; i < peopleCount; i++) {
            person[i] = sc.nextInt();
        }

        Arrays.sort(person);

        int answer = 0;
        for (int i = 0; i < peopleCount; i++) {
            answer += person[i] * (peopleCount - i);
        }

        System.out.println(answer);
    }
}
