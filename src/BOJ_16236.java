import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16236 {
    static int shark = 2;
    static int eatFish = 0; //먹은 물고기 수
    static int count = 0; //소요 시간
    static int[][] fishDistance; //거리와 방문 여부 체크
    static int[][] map;
    static int N;
    static Point start; //상어 위치
    static int minDist, minX, minY;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        fishDistance = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 9) {
                    start = new Point(i, j);
                    map[i][j] = 0;
                }
            }
        }

        while(true) {
            init();
            bfs(start.x, start.y);

            if (minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE) {
                count += fishDistance[minX][minY];
                eatFish++;

                if (eatFish == shark) {
                    shark++;
                    eatFish = 0;
                }

                map[minX][minY] = 0;

                start.x = minX;
                start.y = minY;
            } else {
                break;
            }
        }
        System.out.println(count);
    }

    /* 최소 거리와 그를 충족하는 좌표를 초기화한다. */
    public static void init() {
        minDist = Integer.MAX_VALUE;
        minX = Integer.MAX_VALUE;
        minY = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) {
                fishDistance[i][j] = -1;
            }
        }
    }

    /*
    * param : shark의 시작점
    * */
    public static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        fishDistance[x][y] = 0;
        q.add(new Point(x, y));

        while(!q.isEmpty()) {
            Point p = q.poll();
            x = p.x;
            y = p.y;

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                /* 범위 체크 & 방문 체크 & shark보다 큰지 */
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if(map[nx][ny] > shark || fishDistance[nx][ny] != -1 ){
                    continue;
                }

                fishDistance[nx][ny] = fishDistance[x][y] + 1;

                //먹을 수 있는 물고기
                if( map[nx][ny] >= 1 && map[nx][ny] <= 6 && map[nx][ny] < shark ) {
                    if(minDist > fishDistance[nx][ny]){
                        minX = nx;
                        minY = ny;
                        minDist = fishDistance[nx][ny];
                    }
                    else if(minDist == fishDistance[nx][ny]){
                        if(minX == nx){
                            if(minY > ny){
                                minX = nx;
                                minY = ny;
                            }
                        } else if(minX > nx){
                            minX = nx;
                            minY = ny;
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
