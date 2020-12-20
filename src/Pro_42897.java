public class Pro_42897 {
    public int solution(int[] money) {
        int answer = 0;
        int[] dp = new int[money.length];

        // 첫 번째 집 포함
        dp[0] = money[0];
        dp[1] = Math.max(money[0], money[1]);
        for (int i = 2; i < money.length - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
        }

        answer = dp[money.length - 2];

        // 첫 번째 집 미포함
        dp[0] = 0;
        dp[1] = money[1];
        for (int i = 2; i < money.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
        }

        answer = Math.max(answer, dp[money.length - 1]);
        return answer;
    }
}
