import java.util.Scanner;

public class BOJ_11055 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            dp[i] = arr[i];
        }

        int max = dp[0];
        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j] + arr[i], dp[i]);
                }
            }
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}
