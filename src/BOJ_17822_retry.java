import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17822_retry {
    static int[][] circle;
    static int n;
    static int m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static boolean flag;
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        testCase = Integer.parseInt(st.nextToken());

        circle = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                circle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            rotate(x, d, k);
        }
        System.out.println(calcSum());
    }

    /*
     * x 의 배수인 원판을
     * d 방향으로
     * k 만큼 회전
     * */
    static void rotate(int x, int d, int k) {
        visited = new boolean[n][m];
        flag = true;

        for (int i = 0; i < n; i++) {
            if ((i + 1) % x == 0) {
                circle[i] = move(circle[i], d, k);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && circle[i][j] != 0) {
                    dfs(i, j);
                }
            }
        }

        cleanCircle();

        if (flag) {
            float avg = calcAvg();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (circle[i][j] == 0) {
                        continue;
                    }

                    if (circle[i][j] > avg) {
                        circle[i][j]--;
                    } else if (circle[i][j] < avg) {
                        circle[i][j]++;
                    }
                }
            }
        }
    }

    static void cleanCircle() {
        while (!q.isEmpty()) {
            Node node = q.poll();

            circle[node.x][node.y] = 0;
        }
    }

    static float calcAvg() {
        float sum = 0;
        float count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (circle[i][j] != 0) {
                    sum += circle[i][j];
                    ++count;
                }
            }
        }

        return sum / count;
    }

    static int calcSum() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (circle[i][j] != 0) {
                    sum += circle[i][j];
                }
            }
        }
        return sum;
    }

    /* 해당 방향으로 k칸 이동 */
    static int[] move(int[] arr, int d, int k) {
        int[] temp = new int[m];
        int idx;

        for (int i = 0; i < m; i++) {
            // 시계 방향
            if (d == 0) {
                idx = (i + k) % m;
            } else {
                idx = i - k < 0 ? i - k + m : i - k;
            }
            temp[idx] = arr[i];
        }

        return temp;
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (ny < 0) {
                ny = m - 1;
            } else if (ny >= m) {
                ny = 0;
            }

            if (nx < 0 || nx >= n || visited[nx][ny]) {
                continue;
            }

            if (circle[nx][ny] != 0 && circle[nx][ny] == circle[x][y]) {
                q.add(new Node(nx, ny));
                q.add(new Node(x, y));

                visited[x][y] = true;
                flag = false;
            }
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
