import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BOJ_2178 {
    static int[][] map;
    static int N;
    static int M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split("");

            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        bfs(1, 1);
        System.out.println(map[N][M]);
    }

    static void bfs(int x, int y) {
        boolean visited[][] = new boolean[N+1][M+1];
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node n = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];

                if (nx <= 0 || nx > N || ny <= 0 || ny > M)
                {
                    continue;
                }

                if (!visited[nx][ny] && map[nx][ny] != 0) {
                    q.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                    map[nx][ny] = map[n.x][n.y] + 1;
                }
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
