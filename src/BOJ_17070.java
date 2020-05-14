import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070 {
    static int n;
    static int[][] map;
    static int[][][] dp;
    static int[] dx = {0, 1, 1}; //가, 세, 대
    static int[] dy = {1, 0, 1};
    static int count;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];
        dp = new int[n+1][n+1][3];

        for (int i = 1; i <= n; i++) {
             st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        count = dfs(1, 2, 0);
        System.out.println(count);
    }

    // 가로 0
    // 세로 1
    // 대각선 2
    static int dfs(int x, int y, int dir) {
        if (x > n || y > n || map[x][y] == 1) {
            return 0;
        }

        if (dir == 2 && (map[x][y - 1] == 1 || map[x - 1][y] == 1)) {
            return 0;
        }

        if (dp[x][y][dir] != -1) {
            return dp[x][y][dir];
        }

        if (x == n && y == n) {
            return 1;
        }

        int sum =0;
        for (int i = 0; i < 3; i++) {
            if ((dir == 0 && i == 1) || (dir == 1 && i == 0)) {
                continue;
            }

            int nx = x + dx[i];
            int ny = y + dy[i];

            sum += dfs(nx, ny, i);
        }

        return dp[x][y][dir] = sum;
    }
}
