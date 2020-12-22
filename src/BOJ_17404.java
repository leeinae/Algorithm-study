import java.util.Scanner;

public class BOJ_17404 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int answer = Integer.MAX_VALUE;
        int[][] house = new int[n][3];
        int[][] dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                house[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 3; i++) { // rgb
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    dp[0][i] = house[0][i];
                    continue;
                }
                dp[0][j] = 1001 * 1000;
            }

            for (int k = 1; k < n; k++) {
                dp[k][0] = Math.min(dp[k - 1][1], dp[k - 1][2]) + house[k][0];
                dp[k][1] = Math.min(dp[k - 1][0], dp[k - 1][2]) + house[k][1];
                dp[k][2] = Math.min(dp[k - 1][0], dp[k - 1][1]) + house[k][2];
            }

            for (int k = 0; k < 3; k++) {
                if (i == k) continue;
                answer = Math.min(answer, dp[n - 1][k]);
            }
        }

        System.out.println(answer);
    }
}
