import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2589 {
    static char[][] map;
    static int[][] dist;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new char[n][m]; // 전체 지도
        dist = new int[n][m]; // 거리 저장
        visited = new boolean[n][m]; // 방문 체크

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'L') {
                    // 각 육지를 기준으로 거리를 탐색한다.
                    // 각 경우마다 거리를 새롭게 구해야해서 visited 배열 전체를 false 처리해준다.
                    visited = new boolean[n][m];
                    bfs(i, j);
                }
            }
        }

        System.out.println(max);
    }

    static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        dist = new int[n][m];

        q.add(new Point(x, y));
        visited[x][y] = true;
        dist[x][y] = 0;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) {
                    continue;
                }

                if (map[nx][ny] == 'W') {
                    continue;
                }

                q.add(new Point(nx, ny));
                visited[nx][ny] = true;
                dist[nx][ny] = dist[p.x][p.y] + 1;
                max = Math.max(dist[nx][ny], max);
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}
