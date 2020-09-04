import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_7569 {
    static int m, n, h;
    static int[][][] board;
    static Queue<Tomato> tomato;
    static int answer = 0;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        board = new int[n][m][h];
        tomato = new LinkedList<>();

        int num = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < m; k++) {
                    num = Integer.parseInt(st.nextToken());
                    board[j][k][i] = num;

                    if (num == 1) {
                        tomato.add(new Tomato(j, k, i));
                    }
                }
            }
        }

        while (!tomato.isEmpty()) {
            Tomato t = tomato.poll();
            bfs(t);
        }

        answer = check() ? answer : -1;
        System.out.println(answer);
    }

    // 모든 토마토가 익었으면 true, 안 익었으면 false
    static boolean check() {
        boolean isAllRipeTomato = true;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (board[j][k][i] == 0) {
                        isAllRipeTomato = false;
                    }
                }
            }
        }

        return isAllRipeTomato;
    }

    static void bfs(Tomato t) {
        int x = t.x;
        int y = t.y;
        int z = t.z;

        for (int i = 0; i < 6; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int nz = z + dz[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m || nz < 0 || nz >= h) continue;

            if (board[nx][ny][nz] == 0) {
                tomato.add(new Tomato(nx, ny, nz));
                board[nx][ny][nz] = board[x][y][z] + 1;

                answer = Math.max(board[nx][ny][nz] - 1, answer);
            }
        }
    }

    static class Tomato {
        int x;
        int y;
        int z;

        public Tomato(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
