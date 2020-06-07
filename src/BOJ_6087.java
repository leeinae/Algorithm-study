import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_6087 {
    static char[][] map;
    static int[][] visited;
    static ArrayList<Point> laser;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int W;
    static int H;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        visited = new int[H][W];
        laser = new ArrayList<>();

        for (int i = 0; i < H; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < W; j++) {
                visited[i][j] = Integer.MAX_VALUE; // 최대로 초기화

                char val = input[j].charAt(0);
                map[i][j] = val;

                if (val == 'C') {
                    laser.add(new Point(i, j, -1, 0));
                }
            }
        }

        bfs();
    }

    static void bfs() {
        Queue<Point> q = new LinkedList<>();

        Point c1 = laser.get(0); // 출발 레이저
        Point c2 = laser.get(1); // 도착 레이저

        q.add(c1);
        visited[c1.x][c1.y] = 0;

        while (!q.isEmpty()) {
            Point p = q.poll();

            int x = p.x; //현재 좌표
            int y = p.y;
            int dir = p.dir;
            int count = p.count;

            if (x == c2.x && y == c2.y) {
                answer = Math.min(count, answer);
            }

            // 0 : 북, 1 : 남, 2 : 서, 3: 동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i]; //다음 좌표
                int ny = y + dy[i];
                int nd = i;

                if (nx < 0 || ny < 0 || nx >= H || ny >= W || map[nx][ny] == '*') {
                    continue;
                }

                // 이전 좌표의 방향과 현재 좌표의 방향 비교
                int temp = count;
                if (dir != nd && dir != -1) {
                    temp++;
                }

                if (visited[nx][ny] < temp) {
                    continue;
                }

                visited[nx][ny] = temp;
                q.add(new Point(nx, ny, nd, temp));
            }
        }
        System.out.println(answer);
    }

    static class Point {
        int x;
        int y;
        int dir;
        int count;

        public Point(int x, int y, int dir, int count) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.count = count;
        }
    }
}
