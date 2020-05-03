import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
    static int[][] board;
    static int M;
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                max= Math.max(max, board[i][j]);
            }
        }

        if (check()) {
            System.out.println(max - 1);
        } else {
            System.out.println(-1);
        }
    }

    static void bfs() {
        Queue q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (board[i][j] == 1) {
                    q.add(new Tomato(i, j));
                }
            }
        }


        int nx, ny;
        while (!q.isEmpty()) {
            Tomato t = (Tomato) q.poll();

            int x = t.x;
            int y = t.y;

            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];

                if(nx <= 0 || nx > N || ny <= 0 || ny > M) continue;

                if (board[nx][ny] == 0) {
                    board[nx][ny] = board[x][y]+1;
                    q.add(new Tomato(nx, ny));
                }
            }
        }
    }

    static boolean check() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static class Tomato {
        int x;
        int y;

        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
