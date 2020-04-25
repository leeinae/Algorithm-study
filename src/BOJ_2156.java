import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;

public class BOJ_2156 {
    static int[] wine;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        wine = new int[n + 1];
        int dp[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            wine[i] = sc.nextInt();

        }

        dp[1] = wine[1];

        if (n > 1) {
            dp[2] = dp[1] + wine[2];

            for (int i = 3; i <= n; i++) {
                int cont1 = dp[i - 1];
                int cont2 = Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i] + wine[i - 1]);
                dp[i] = Math.max(cont1, cont2);
            }
        }

        System.out.println(dp[n]);
    }
}


/*
* DP문제 풀때는 점화식을 생각하자..
* 1) 0번 연속일 경우 --> dp[n] = dp[n-1]
* 2) 1번 연속으로 먹는 경우 --> dp[n] = dp[n-2] + p[n] (n>2)
* 3) 2번 연속으로 먹는 경우 --> dp[n] = dp[n-3] + p[n-1] + p[n-2] (n>3)
*/
