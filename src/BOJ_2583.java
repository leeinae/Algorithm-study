import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BOJ_2583 {
    static int m, n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count;
    static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        result = new ArrayList<>();

        map = new int[m + 1][n + 1];
        visited = new boolean[m + 1][n + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            paint(x1, y1, x2, y2);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    count = 0;
                    dfs(i, j);
                    result.add(count);
                }
            }
        }

        result.sort(null);
        System.out.println(result.size());
        for(int i: result) {
            System.out.print(i + " ");
        }
    }

    static void dfs(int x, int y) {
        count++;
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx > 0 && nx <= m && ny > 0 && ny <= n) {
                if (!visited[nx][ny] && map[nx][ny] == 0) {
                    dfs(nx, ny);
                }
            }
        }
    }

    static void paint(int x1, int y1, int x2, int y2) {
        int w = x2 - x1;
        int h = y2 - y1;

        for (int i = x1 + 1; i <= x1 + w; i++) {
            for (int j = y1 + 1; j <= y1 + h; j++) {
                map[j][i] = -1;
            }
        }
    }
}
