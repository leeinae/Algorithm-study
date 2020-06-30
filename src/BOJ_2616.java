import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2616 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] train = new int[n + 1];
        int[] sum = new int[n + 1];
        int[][] dp = new int[4][n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            train[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + train[i];
        }

        int max = Integer.parseInt(br.readLine());

        for (int i = 1; i < 4; i++) {
            for (int j = i * max; j <= n; j++) {
                dp[i][j] = Math.max(
                        dp[i][j - 1],
                        dp[i - 1][j - max] + (sum[j] - sum[j - max])
                );
            }
        }

        System.out.println(dp[3][n]);
    }

    // dp[1][] : 소형차 하나로 max개의 객차를 끌었을 떄 최대 손님 수
    // dp[2][] : 소형차 두 개로 max개의 객차를 끌었을 때 ..

    // j가 i*max부터 시작하는 이유 : 예를 들어 dp[2]일때 경우의 수 시작이 기관차 2대가
    // 각각 2대씩의 전차를 끌어야하니까 i * max이다. dp[3]일때 2대씩 전차 끌면 3 * 2 = 6 부터 시작

    // 점화식 : Math.max(dp[i][j-1], dp[i-1][j-max] + (s[j]- s[j-max])
    // 전차 1대 일때의 경우 + 새롭게 전차 한 대 붙임
}

