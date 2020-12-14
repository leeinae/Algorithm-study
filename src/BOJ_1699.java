import java.util.Scanner;

public class BOJ_1699 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;

            for (int j = 1; j <= i / 2; j++) {
                if (i == j * j) {
                    dp[i] = 1;
                    break;
                }

                dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
            }
        }

        System.out.println(dp[n]);
    }
}
