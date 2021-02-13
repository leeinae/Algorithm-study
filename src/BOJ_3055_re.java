import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3055_re {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int r;
    static int c;
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        visited = new boolean[r][c];

        Queue<Node> water = new LinkedList<>();
        Queue<Node> beaver = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            String str = br.readLine();

            for (int j = 0; j < c; j++) {
                if (str.charAt(j) == 'X') { // 돌
                    map[i][j] = 1;
                } else if (str.charAt(j) == '*') { // 물
                    map[i][j] = 2;
                    water.add(new Node(i, j, 2));
                } else if (str.charAt(j) == 'D') { // 비버
                    map[i][j] = -1;
                } else if (str.charAt(j) == 'S') { // 고슴도치
                    beaver.add(new Node(i, j, 3));
                } else {
                    map[i][j] = 0;
                }
            }
        }

        q.addAll(water);
        q.addAll(beaver);

        int answer = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();

            for (int s = 0; s < qSize; s++) {
                Node temp = q.poll();
                visited[temp.x][temp.y] = true;

                for (int i = 0; i < 4; i++) {
                    int nx = temp.x + dx[i];
                    int ny = temp.y + dy[i];
                    int type = temp.type;

                    if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                    if (type == 3 && map[nx][ny] == -1) {
                        System.out.println(answer + 1);
                        return;
                    }
                    if (visited[nx][ny] || map[nx][ny] != 0) continue;

                    q.add(new Node(nx, ny, type));
                    visited[nx][ny] = true;
                }
            }
            ++answer;
        }

        System.out.println("KAKTUS");
    }

    public static void print() {
        for (int[] arr : map) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("=============");
    }

    public static class Node {
        public int x;
        public int y;
        public int type;

        public Node(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}

