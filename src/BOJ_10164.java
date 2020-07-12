import java.util.Scanner;

public class BOJ_10164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int answer = 0;

        if (k == 0) {
            answer = getRoute(n - 1, m - 1);
        } else {
            // O로 표시된 지점 좌표
            int x = (k - 1) / m;
            int y = (k - 1) % m;

            int firstRoute = getRoute(x, y);
            int secondeRoute = getRoute(n - x - 1, m - y - 1);

            answer = firstRoute * secondeRoute;
        }

        System.out.println(answer);
    }

    static int getRoute(int x, int y) {
        ++x;
        ++y;

        int[] dx = {0, 1};
        int[] dy = {1, 0};
        int[][] dp = new int[x][y];

        dp[0][0] = 1;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int z = 0; z < 2; z++) {
                    int nx = i + dx[z];
                    int ny = j + dy[z];

                    if (nx >= x || ny >= y) {
                        continue;
                    }
                    
                    dp[nx][ny] += dp[i][j];
                }
            }
        }

        return dp[x - 1][y - 1];
    }
}
