import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2667_re {
    static int[][] board;
    static boolean[][] visited;
    static int n;
    static ArrayList<Integer> answer = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(str[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }

        answer.sort(null);
        System.out.println(answer.size());
        for (int num :answer) {
            System.out.println(num);
        }
    }

    static void bfs(int x, int y) {
        int count = 1;
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny] || board[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                q.add(new Node(nx, ny));

                count++;
            }
        }

        answer.add(count);
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

