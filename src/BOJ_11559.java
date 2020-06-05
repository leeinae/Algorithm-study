import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_11559 {
    static int[][] map;
    static boolean[][] visited;
    static final int mx = 12;
    static final int my = 6;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[mx][my];
        visited = new boolean[mx][my];

        for (int i = 0; i < mx; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < my; j++) {
                char val = input[j].charAt(0);
                if (val == '.') {
                    map[i][j] = 0;
                } else if (val == 'R') {
                    map[i][j] = 1;
                } else if (val == 'G') {
                    map[i][j] = 2;
                } else if (val == 'B') {
                    map[i][j] = 3;
                } else if (val == 'Y') {
                    map[i][j] = 5;
                } else {
                    map[i][j] = 6;
                }
            }
        }

        while (true) {
            boolean flag = false;
            visited = new boolean[mx][my];

            for (int i = 0; i < mx; i++) {
                for (int j = 0; j < my; j++) {
                    if (!visited[i][j] && map[i][j] != 0) {
                        if (bfs(i, j)) {
                            flag = true;
                        }
                    }
                }
            }

            if (flag) {
                count++;
                down();
            } else {
                System.out.println(count);
                break;
            }

        }
    }

    static boolean bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        Queue<Point> route = new LinkedList<>();

        q.add(new Point(x, y));
        route.add(new Point(x, y));

        visited[x][y] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= mx || ny >= my || visited[nx][ny]) {
                    continue;
                }

                if (map[nx][ny] == map[x][y]) {
                    q.add(new Point(nx, ny));
                    route.add(new Point(nx, ny));

                    visited[nx][ny] = true;
                }
            }
        }

        if (route.size() >= 4) {
            pop(route);
            return true;
        } else {
            return false;
        }
    }

    static void pop(Queue<Point> route) {
        while (!route.isEmpty()) {
            Point temp = route.poll();
            map[temp.x][temp.y] = 0;
        }
    }

    static void down() {
        for (int i = 0; i < my; i++) {
            for (int j = mx - 1; j > 0; j--) {
                if (map[j][i] == 0) {
                    for (int k = j - 1; k >= 0; k--) {
                        if (map[k][i] != 0) {
                            map[j][i] = map[k][i];
                            map[k][i] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }

    static void print() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
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
