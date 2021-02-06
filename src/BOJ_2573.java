import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2573 {
    static int[][] iceberg;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        iceberg = new int[n][m];
        visited = new boolean[n][m];
        boolean isMelt = true;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                iceberg[i][j] = Integer.parseInt(st.nextToken());

                if (iceberg[i][j] != 0) isMelt = false;
            }
        }

        while (!isMelt) {
            answer++;

            // 빙산 녹이기
            iceberg = meltedIceburg();
            visited = new boolean[n][m];
            isMelt = true;


            // 분리된 빙산 수 체크
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (iceberg[i][j] != 0 && !visited[i][j]) {
                        dfs(i, j);
                        count++;
                    }

                    if (iceberg[i][j] != 0) isMelt = false;
                }
            }

            if (isMelt) {
                System.out.println(0);
                return;
            }

            if (count >= 2) {
                System.out.println(answer);
                break;
            }
        }
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= iceberg.length || ny >= iceberg[0].length) continue;
            if (visited[nx][ny] || iceberg[nx][ny] == 0 ) continue;

            dfs(nx, ny);
        }
    }

    public static int[][] meltedIceburg() {
        int[][] temp = new int[iceberg.length][iceberg[0].length];

        for (int i = 0; i < iceberg.length; i++) {
            for (int j = 0; j < iceberg[0].length; j++) {
                if (iceberg[i][j] == 0) continue;

                int count = 0;
                for (int z = 0; z < 4; z++) {
                    int nx = i + dx[z];
                    int ny = j + dy[z];

                    if (nx < 0 || ny < 0 || nx >= temp.length || ny >= temp[0].length) continue;
                    if (iceberg[nx][ny] == 0) count++;
                }

                temp[i][j] = Math.max(iceberg[i][j] - count, 0);
            }
        }


        return temp;
    }
}
