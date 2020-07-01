import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1941 {
    static char[][] student = new char[5][5];
    static boolean[][] visited = new boolean[5][5];
    static boolean[] comb = new boolean[25];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < 5; j++) {
                student[i][j] = input[j];
            }
        }

        dfs(-1, 0);

        System.out.println(answer);
    }

    static void dfs(int num, int count) {
        if (count == 7) {
            if (check()) {
                answer++;
            }
            return;
        }

        for (int i = num + 1; i <= 24; i++) {
            if (!comb[i]) {
                comb[i] = true;
                dfs(i, count + 1);
                comb[i] = false;
            }
        }
    }

    // s가 4개 이상이고, 인접한지 체크체크
    // boolean true: 방문할 수 있음 (방문 후 false 처리)
    static boolean check() {
        int sCount = 0;
        int start = 0;
        int count = 0;
        visited = new boolean[5][5];

        /* 이다솜파 4명 이상인지 확인 */
        for (int i = 0; i < 25; i++) {
            if (comb[i]) {
                start = i;
                visited[i / 5][i % 5] = true; // 방문 가능함을 표시

                if (student[i / 5][i % 5] == 'S') {
                    ++sCount;
                }
            }
        }

        if (sCount < 4) {
            return false;
        }

        /* 7명의 자리가 인접한지 확인 */
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(start / 5, start % 5));

        while (!q.isEmpty()) {
            Point temp = q.poll();

            if (count == 7) {
                return true;
            }
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || !visited[nx][ny]) {
                    continue;
                }

                q.add(new Point(nx, ny));
                visited[nx][ny] = false;
            }
        }

        return false;
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
