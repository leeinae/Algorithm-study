import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14502 {
    static int M, N;
    static int[][] map;
    static int[][] mapClone;
    static ArrayList<Point> virus = new ArrayList<>();
    static int maxNum = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로

        map = new int[N][M];
        mapClone = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if( map[i][j] == 2 ) {
                    virus.add(new Point(i, j));
                }
            }
        }

        setWall(0, 0,  0);
        System.out.println(maxNum);
    }

    public static void setWall(int x, int y, int depth) {
        if (depth == 3) {
            //벽을 세운 상태를 copy 해야하기 때문에 clone 안하고 복사합니다
           copyMap();

            for(Point p : virus) {
                dfs(p.x, p.y);
            }

            maxNum = Math.max(maxNum, getArea());
            return;
        }

        for(int i= x; i < N; i++) {
            for(int j=0; j<M; j++) {
                if( i == x && j < y ) {
                    continue;
                }
                System.out.println(i+"," +j);
                if(map[i][j] == 0) {
                    map[i][j] =1;
                    setWall(i, j+1,  depth + 1);
                    map[i][j] =0;
                }
            }

        }
    }

    public static void copyMap() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                mapClone[i][j] = map[i][j];
            }
        }
    }

    public static int getArea() {
        int count =0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (mapClone[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (mapClone[nx][ny] == 0) {
                    mapClone[nx][ny] = 2;
                    dfs(nx, ny);
                }
            }
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


