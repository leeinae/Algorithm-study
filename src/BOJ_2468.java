import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2468 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];

        int max = -1, min = 101;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                max = Math.max(max, map[i][j]);
                min = Math.min(min, map[i][j]);
            }
        }

        int maxArea = 1;
        for (int i = min; i <= max; i++) {
            visited = new boolean[n + 1][n + 1];
            rain(i);
            maxArea = Math.max(check(), maxArea);
        }

        System.out.println(maxArea);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 1 || ny < 1 || nx > n || ny > n) {
                continue;
            }

            if (!visited[nx][ny]) {
                dfs(nx, ny);
            }

        }
    }

    static int check() {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        return count;
    }

    static void rain(int num) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] <= num) {
                    visited[i][j] = true;
                }
            }
        }
    }
}
