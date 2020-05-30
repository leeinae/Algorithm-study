import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_16234 {
    static int n;
    static int l;
    static int r;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        while (true) {
            visited = new boolean[n][n];
            if (!check()) {
                count++;
            } else {
                break;
            }
        }

        System.out.println(count);
    }

    /*
     * 아직 다 탐색하지 않음 : false
     * 다 탐색 : true
     * */
    static boolean check() {
        boolean flag = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    ArrayList<Point> area = new ArrayList<>();
                    area.add(new Point(i, j));
                    int sum = dfs(i, j, area, 0);

                    if (area.size() > 1) {
                        move(area, sum);
                        flag = false;
                    }
                }
            }
        }
        return flag;
    }

    static void move(ArrayList<Point> area, int sum) {
        int avg = sum / area.size();

        for (Point p : area) {
            map[p.x][p.y] = avg;
        }
    }

    static int dfs(int x, int y, ArrayList<Point> area, int sum) {
        visited[x][y] = true;
        sum = map[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny]) {
                continue;
            }

            int diff = Math.abs(map[x][y] - map[nx][ny]);
            if (diff >= l && diff <= r) {
                area.add(new Point(nx, ny));
                sum += dfs(nx, ny, area, sum);
            }
        }

        return sum;
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
