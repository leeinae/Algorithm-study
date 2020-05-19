import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17144 {
    static int R;
    static int C;
    static int T;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] ccw = {3, 0, 2, 1};
    static int[] cw = {3, 1, 2, 0};
    static int[][] map;
    static int[][] cloneMap;
    static ArrayList<Point> cleaner;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R + 1][C + 1];
        cloneMap = new int[R + 1][C + 1];

        cleaner = new ArrayList<>();

        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == -1) {
                    cleaner.add(new Point(i, j, -1));
                }
            }
        }

        for (int i = 0; i < T; i++) {
            /* 1. 미세먼지 확산 */
            spread();
            copy();

            /* 2. 공기청정기 작동 */
            circulate(cleaner.get(0).x, cleaner.get(0).y, ccw);
            circulate(cleaner.get(1).x, cleaner.get(1).y, cw);
        }

        solve();
    }

    static void spread() {
        Queue<Point> q = new LinkedList<>();

        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (map[i][j] > 4) {
                    q.add(new Point(i, j, map[i][j]));
                }
            }
        }

        while (!q.isEmpty()) {
            int count = 0;
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx <= 0 || ny <= 0 || nx > R || ny > C || map[nx][ny] == -1) continue;

                count++;
                map[nx][ny] += p.dust / 5;
            }
            map[p.x][p.y] -= (p.dust / 5) * count;
        }
    }

    // 반시계 : 우 - 상 - 좌 - 하 : 3, 0, 2, 1
    // 시계 : 우 - 하 - 좌 - 상 : 3, 1, 2, 0
    static void circulate(int cx, int cy, int[] dir) {
        int x = cx;
        int y = cy + 1;
        map[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            while (true) {
                int nx = x + dx[dir[i]];
                int ny = y + dy[dir[i]];

                if (nx <= 0 || ny <= 0 || nx > R || ny > C) {
                    break;
                }

                if (nx == cx && ny == cy) {
                    break;
                }

                map[nx][ny] = cloneMap[x][y];
                x = nx;
                y = ny;
            }
        }
    }

    static void copy() {
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                cloneMap[i][j] = map[i][j];
            }
        }
    }

    static void solve() {
        int count = 0;
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (map[i][j] != -1) {
                    count += map[i][j];
                }
            }
        }
        System.out.println(count);
    }

    static class Point {
        int x;
        int y;
        int dust;

        public Point(int x, int y, int dust) {
            this.x = x;
            this.y = y;
            this.dust = dust;
        }
    }
}
