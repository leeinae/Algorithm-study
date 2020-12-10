import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11722 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            dp[i] = 1;
        }

        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }

            maxLen = Math.max(maxLen, dp[i]);
        }

        System.out.println(maxLen);
    }
}
