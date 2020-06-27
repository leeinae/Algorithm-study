import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_Retry {
    static int N; //map 크기
    static int[][] map;
    static int[][] distance;
    static Point shark_point;
    static int shark_size = 2;
    static int eatFish = 0;
    static int count = 0;
    static int min_x, min_y, min_dist;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        distance = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark_point = new Point(i, j);
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            init();
            bfs(shark_point.x, shark_point.y);

            if (min_x != Integer.MAX_VALUE && min_y != Integer.MAX_VALUE) {
                count += distance[min_x][min_y];
                eatFish++;

                if (eatFish == shark_size) {
                    shark_size++;
                    eatFish = 0;
                }

                shark_point.x = min_x;
                shark_point.y = min_y;

                map[min_x][min_y] = 0;
            } else {
                break;
            }
        }
        System.out.println(count);
    }

    static void init() {
        min_x = Integer.MAX_VALUE;
        min_y = Integer.MAX_VALUE;
        min_dist = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                distance[i][j] = -1;
            }
        }
    }

    static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        distance[x][y] = 0;
        q.add(new Point(x, y));

        while (!q.isEmpty()) {
            Point p = q.poll();
            x = p.x;
            y = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if (distance[nx][ny] != -1 || map[nx][ny] > shark_size) {
                    continue;
                }

                distance[nx][ny] = distance[x][y] + 1;

                if (map[nx][ny] < shark_size && map[nx][ny] > 0 && map[nx][ny] < 7) {
                    if (distance[nx][ny] < min_dist) {
                        min_dist = distance[nx][ny];
                        min_x = nx;
                        min_y = ny;
                    } else if (distance[nx][ny] == min_dist) {
                        if (min_x == nx) {
                            if (min_y > ny) {
                                min_x = nx;
                                min_y = ny;
                            }
                        } else if (min_x > nx) {
                            min_x = nx;
                            min_y = ny;
                        }
                    }
                }
                q.add(new Point(nx, ny));
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
