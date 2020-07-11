import java.util.Scanner;

public class BOJ_9465 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        while (testCase-- > 0) {
            int n = sc.nextInt();

            int[][] dp = new int[n][3];
            int[][] arr = new int[2][n];

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            dp[0][1] = arr[0][0];
            dp[0][2] = arr[1][0];
            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][2]);
                dp[i][1] = Math.max(dp[i - 1][2], dp[i - 1][0]) + arr[0][i];
                dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][0]) + arr[1][i];
            }

            int answer = Math.max(Math.max(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);

            System.out.println(answer);
        }
    }
}
