public class Pro_42898 {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n + 1][m + 1];

        for (int[] arr : puddles) {
            dp[arr[1]][arr[0]] = -1;
        }

        dp[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == -1) continue;

                int top = dp[i - 1][j] == -1 ? 0 : dp[i - 1][j];
                int left = dp[i][j - 1] == -1 ? 0 : dp[i][j - 1];

                dp[i][j] += (top + left) % 1000000007;
            }
        }

        answer = dp[n][m];
        return answer;
    }
}
