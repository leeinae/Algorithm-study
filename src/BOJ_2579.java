import java.util.Scanner;

public class BOJ_2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stairs = new int[301];
        int[] dp = new int[301];

        for (int i = 1; i <= n; i++) {
            stairs[i] = sc.nextInt();
        }

        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 3] + stairs[i - 1] + stairs[i], dp[i - 2] + stairs[i]);
        }

        System.out.println(dp[n]);
    }
}
