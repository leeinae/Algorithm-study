import java.util.Scanner;

public class BOJ_2133 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dp = new int[31];
        int n = sc.nextInt();

        dp[1] = 0;
        dp[2] = 3;

        for (int i = 4; i <= n; i += 2) {
            dp[i] += (dp[i - 2] * dp[2]) + 2;

            int temp = i;
            while (temp - 2 > 2) {
                dp[i] += dp[i - (temp - 2)] * 2;
                temp -= 2;
            }
        }

        System.out.println(dp[n]);
    }
}
