import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ_2933 {
    static char[][] map;
    static boolean[][] visited;
    static Queue<Point> q = new LinkedList<>();
    static int r;
    static int c;
    static int n; // 던지는 횟수
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r + 1][c + 1];

        for (int i = 1; i <= r; i++) {
            String[] input = br.readLine().split("");
            for (int j = 1; j <= c; j++) {
                map[i][j] = input[j - 1].charAt(0);
            }
        }

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int idx = 1; // 1이면 왼->오, -1이면 오->왼
        for (int i = 1; i <= n; i++) {
            throwStick(r - Integer.parseInt(st.nextToken()) + 1, idx);
            down();

            idx *= -1;
        }

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                bw.write(map[i][j]);
            }
            bw.newLine();
        }
        bw.flush();
    }

    static void throwStick(int h, int idx) {
        int start;
        int temp;

        if (idx > 0) {
            start = 1;
        } else {
            start = c;
        }

        temp = start;
        for (int i = 1; i <= c; i++) {
            if (map[h][temp] == 'x') {
                map[h][temp] = '.';
                break;
            }

            temp += idx;
        }
    }

    static void down() {
        visited = new boolean[r + 1][c + 1];
        ArrayList<Point> cluster = new ArrayList<>();

        /* 바닥에 있는 클러스터 체크 */
        for (int i = 1; i <= c; i++) {
            if (map[r][i] == '.' || visited[r][i]) {
                continue;
            }

            q.add(new Point(r, i));
            visited[r][i] = true;

            while (!q.isEmpty()) {
                Point p = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];

                    if (nx >= 1 && ny >= 1 && nx <= r && ny <= c) {
                        if (map[nx][ny] == 'x' && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            q.add(new Point(nx, ny));
                        }
                    }
                }
            }
        }

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (!visited[i][j] && map[i][j] == 'x') {
                    cluster.add(new Point(i, j));
                    map[i][j] = '.';
                }
            }
        }

        if (cluster.isEmpty()) {
            return;
        }

        boolean flag = true;
        while (flag) {
            for (Point p : cluster) {
                int x = p.x + 1;
                int y = p.y;

                /* 아래로 내려갈 수 없는 경우 flag = false */
                if (x < 1 || y < 1 || x > r || y > c || map[x][y] == 'x') {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                for (Point p : cluster) {
                    p.x++;
                }
            }
        }

        for (Point p : cluster) {
            map[p.x][p.y] = 'x';
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
