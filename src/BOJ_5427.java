import java.io.*;
import java.util.*;

public class BOJ_5427 {
    static int answer = 0;
    static int[][] building;
    static boolean[][] visited;
    static Queue<Node> fires = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            building = new int[h][w];
            visited = new boolean[h][w];
            answer = Integer.MAX_VALUE;

            fires = new LinkedList<>();
            Node sg = null;

            // 빈 공간 0
            // 벽 1
            // 불 -1
            for (int i = 0; i < h; i++) {
                String[] str = br.readLine().split("");

                for (int j = 0; j < w; j++) {
                    switch (str[j]) {
                        case "#": // 벽
                            building[i][j] = 1;
                            break;
                        case "@": // 상근
                            sg = new Node(i, j, 0);
                            break;
                        case "*": // 불
                            building[i][j] = -1;
                            visited[i][j] = true;
                            fires.add(new Node(i, j, 0));
                            break;
                    }
                }
            }

            bfs(sg);

            if (answer == Integer.MAX_VALUE) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(answer);
            }
        }
    }

    public static void bfs(Node sg) {
        Queue<Node> q = new LinkedList<>();

        visited[sg.x][sg.y] = true;
        q.add(sg);

        while (!q.isEmpty()) {
            // 불
            int fireSize = fires.size();
            for (int i = 0; i < fireSize; i++) {
                Node tempFire = fires.poll();

                for (int j = 0; j < 4; j++) {
                    int fx = tempFire.x + dx[j];
                    int fy = tempFire.y + dy[j];

                    if (!isRange(fx, fy) || visited[fx][fy]) continue;
                    if (building[fx][fy] == -1 || building[fx][fy] == 1) continue;

                    visited[fx][fy] = true;
                    building[fx][fy] = -1;

                    fires.add(new Node(fx, fy, 0));
                }
            }

            // 상근
            int sgSize = q.size();
            for (int i = 0; i < sgSize; i++) {
                Node tempSg = q.poll();
                int count = tempSg.count;

                for (int j = 0; j < 4; j++) {
                    int nx = tempSg.x + dx[j];
                    int ny = tempSg.y + dy[j];

                    if (!isRange(nx, ny)) {
                        answer = Math.min(answer, tempSg.count + 1);
                        continue;
                    }

                    if (visited[nx][ny] || building[nx][ny] == 1 || building[nx][ny] == -1) continue;

                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny, count + 1));
                }
            }
        }
    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < building.length && y < building[0].length;
    }
}

class Node {
    int x;
    int y;
    int count;

    public Node(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}