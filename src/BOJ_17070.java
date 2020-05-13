import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070 {
    static int n;
    static int[][] map;
    static int[] dx = {0, 1, 1}; //가, 세, 대
    static int[] dy = {1, 0, 1};
    static int count = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
             st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(new Pipe(1,2, 0));

        System.out.println(count);
    }

    static void solution(Pipe pipe) {
        if (pipe.x == n && pipe.y == n) {
            count++;
            return;
        }

        for (int i = 0; i < 3; i++) {
            if ((pipe.dir == 0 && i == 1) || (pipe.dir == 1 && i == 0)) {
                //가로일때는 가로, 대각선으로만 이동 가능
                continue;
            }

            int nx = pipe.x + dx[i];
            int ny = pipe.y + dy[i];

            if (nx > n || ny > n || map[nx][ny] == 1) {
                continue;
            }

            if (i == 2 && (map[pipe.x][pipe.y + 1] == 1 || map[pipe.x + 1][pipe.y] == 1)) {
                continue;
            }

            solution(new Pipe(nx, ny, i));
        }

    }

    // 가로 0
    // 세로 1
    // 대각선 2
    static class Pipe {
        int x;
        int y;
        int dir;

        public Pipe(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}
