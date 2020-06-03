import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2146 {
    static int[][] map; // 테두리 값 저장
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int min = Integer.MAX_VALUE;
    static int idx = 2;
    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0 || !isEdge(i, j)) {
                    continue;
                }

                // 섬이고, 가장자리인 좌표

                visited = new boolean[n][n];

                int count = 0;
                int land = map[i][j];

                visited[i][j] = true;
                q.add(new Point(i, j));

                loop:
                while (!q.isEmpty()) {
                    int s = q.size();
                    for (int z = 0; z < s; z++) {
                        Point p = q.poll();

                        if (map[p.x][p.y] != land && map[p.x][p.y] > 0) {
                            q.clear();
                            break loop;
                        }

                        for (int w = 0; w < 4; w++) {
                            int nx = p.x + dx[w];
                            int ny = p.y + dy[w];

                            if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] == land) {
                                continue;
                            }

                            visited[nx][ny] = true;
                            q.add(new Point(nx, ny));
                        }
                    }
                    count++;
                }
                min = Math.min(min, count - 1);
            }
        }

        System.out.println(min);
    }

    static boolean isEdge(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || ny >= n || nx >= n) {
                continue;
            }

            if (map[nx][ny] != 0) {
                continue;
            }

            return true;
        }
        return false;
    }

    static void bfs() {
        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    map[i][j] = idx;
                    q.add(new Point(i, j));

                    while (!q.isEmpty()) {
                        Point p = q.poll();

                        for (int z = 0; z < 4; z++) {
                            int nx = p.x + dx[z];
                            int ny = p.y + dy[z];

                            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                                continue;
                            }

                            if (map[nx][ny] == 1) {
                                map[nx][ny] = idx;
                                q.add(new Point(nx, ny));
                            }
                        }
                    }
                    idx++;
                }
            }
        }

    }

    static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    static class Point {
        int x;
        int y;
        int idx;

        public Point(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
