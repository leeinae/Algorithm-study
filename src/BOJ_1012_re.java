import java.io.*;
import java.util.*;

public class BOJ_1012_re {
    static int[][] map;
    static int n, m, k;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[m][n];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            int count = 0;
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    if (map[x][y] == 1) {
                        bfs(x, y);
                        count++;
                    }
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
        br.close();
    }

    public static void bfs(int i, int j) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(i, j));
        map[i][j] = 0;

        while (!q.isEmpty()) {
            Node temp = q.poll();

            for (int z = 0; z < 4; z++) {
                int x = temp.x + dx[z];
                int y = temp.y + dy[z];

                if (x >= 0 && x < m && y >= 0 && y < n && map[x][y] == 1) {
                    q.add(new Node(x, y));
                    map[x][y] = 0;
                }
            }
        }
    }

    static class Node {
        int x; int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}