import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_3197 {
    static int r;
    static int c;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Point> swan;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        visited = new boolean[r][c];

        swan = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                char c = input[j].charAt(0);
                if (c == 'L') {
                    map[i][j] = 0;
                    swan.add(new Point(i, j));
                } else if (c == 'X') {
                    map[i][j] = -1;
                }
            }
        }

        melt();

        int left = 0;
        int right = max;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (check(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }

    static void melt() {
        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 0) {
                    q.add(new Point(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= r || ny >= c || map[nx][ny] > -1) {
                    continue;
                }

                q.add(new Point(nx, ny));
                map[nx][ny] = map[p.x][p.y] + 1;

                max = Math.max(max, map[nx][ny]);
            }
        }
    }

    /*
     * @return true : 두 마리가 만나기 가능
     * */
    static boolean check(int day) {
        Point s1 = swan.get(0);
        Point s2 = swan.get(1);

        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[r][c];

        q.add(s1);
        visited[s1.x][s2.y] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.x == s2.x && p.y == s2.y) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                    continue;
                }
                if (map[nx][ny] > day || visited[nx][ny]) {
                    continue;
                }

                q.add(new Point(nx, ny));
                visited[nx][ny] = true;

            }
        }
        return false;
    }

    static void print() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
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


