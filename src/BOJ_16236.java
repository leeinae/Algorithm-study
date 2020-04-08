import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16236 {
    static int shark = 2;
    static int eatFish = 0; //먹은 물고기 수
    static int totalFish = 0; //map에 있는 물고기 수
    static int count = 0; //소요 시간
    static ArrayList<Point> fishList = new ArrayList<>();
    static int N;
    static int[][] map;
    static Point start;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(1 <= map[i][j] && map[i][j] <= 6) {
                    fishList.add(new Point(i, j));
                    totalFish++;
                } else if(map[i][j] == 9) {
                    start = new Point(i, j);
                }
            }
        }
        fishSort();

//        while (totalFish != 0) {
//            bfs(start.x, start.y);
//        }
//        System.out.println("종료");
    }

    public static void move() {
        for(Point p : fishList) {
            bfs(p.x, p.y);
        }
    }

    public static void fishSort() {
        Collections.sort(fishList);
    }

    //이때의 좌표는 도착 x, y
    public static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));

        while(!q.isEmpty()) {
            Point p = q.poll();

            for(int i=0; i<4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] > shark) {
                    continue;
                }

                if(map[nx][ny] == 0) {
                    count++;
                    q.add(new Point(nx, ny));
                } else{
                    System.out.println("물고기 먹음");
                    eatFish++;
                    totalFish--;
                    map[nx][ny] = 0;
                }
            }
        }
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public int compareTo(Point p) {
            if(this.x < p.getX()) {
                return -1;
            } else if ( this.x == p.getX() ) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}
