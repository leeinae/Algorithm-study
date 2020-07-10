import java.util.Scanner;

public class BOJ_9461 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[110];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        for (int i = 6; i < 101; i++) {
            dp[i] = dp[i - 5] + dp[i - 1];
        }

        for (int i = 0; i < n; i++) {
            int testCase = sc.nextInt();

            System.out.println(dp[testCase]);
        }
    }
}
