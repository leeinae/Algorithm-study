import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2636 {
    static int n;
    static int m;
    static int[][] cheese;
    static boolean[][] visited;
    static int cheeseNum = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cheese = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
                if (cheese[i][j] == 1) cheeseNum++;
            }
        }

        int count = 0;
        int tempCheese = 0;
        while (isExistCheese()) {
            visited = new boolean[n][m];
            tempCheese = cheeseNum;
            dfs(0, 0);

            count++;
            meltCheese();
        }

        System.out.println(count);
        System.out.println(tempCheese);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (visited[nx][ny]) continue;

            visited[nx][ny] = true;
            if (cheese[nx][ny] == 1) {
                cheese[nx][ny] = 2;
            } else {
                dfs(nx, ny);
            }
        }
    }

    public static void meltCheese() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (cheese[i][j] == 2) {
                    cheese[i][j] = 0;
                    cheeseNum--;
                }
            }
        }
    }

    public static boolean isExistCheese() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (cheese[i][j] == 1) return true;
            }
        }

        return false;
    }
}