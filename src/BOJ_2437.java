import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2437 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }

        Arrays.sort(weight);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (weight[i] <= answer + 1) {
                // 잴 수 있음
                answer += weight[i];
                continue;
            }
            break;
        }

        System.out.println(answer + 1);
    }
}
