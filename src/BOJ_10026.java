import java.io.*;
import java.util.Arrays;

public class BOJ_10026 {
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < n; j++) {
                switch (str.charAt(j)) {
                    case 'R':
                        board[i][j] = 0;
                        break;
                    case 'G':
                        board[i][j] = 1;
                        break;
                    case 'B':
                        board[i][j] = 2;
                        break;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, board[i][j], true);
                    count++;
                }
            }
        }

        bw.write(count + " ");

        count = 0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, board[i][j], false);
                    count++;
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    public static void dfs(int x, int y, int type, boolean isColor) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= board.length || ny >= board.length) continue;
            if (visited[nx][ny]) continue;

            if (isColor) {
                if (type != board[nx][ny]) continue;
            } else {
                // 색약
                if ((type == 2) && (board[nx][ny] == 0 || board[nx][ny] == 1)) continue;
                if ((type == 0 || type == 1) && (board[nx][ny] == 2)) continue;
            }

            dfs(nx, ny, type, isColor);
        }
    }
}
