import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BOJ_15683 {
    static int n;
    static int m;
    static int[][] map;
    static int count;
    static ArrayList<Node> cctv;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        count = n * m;

        map = new int[n][m];
        cctv = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cctv.add(new Node(i, j, map[i][j]));
                }
            }
        }

        search(0, map);
        System.out.println(count);
    }

    static void search(int cctvIdx, int[][] prev) {
        int[][] visited = new int[n][m];

        if (cctvIdx == cctv.size()) {
            // 사각지대 계산
            int temp = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (prev[i][j] == 0) {
                        temp++;
                    }
                }
            }

            if (temp < count) {
                count = temp;
            }
        } else {
            Node node = cctv.get(cctvIdx);
            int x = node.x;
            int y = node.y;
            int type = node.type;

            switch (type) {
                case 1:
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < n; j++) {
                            visited[j] = Arrays.copyOf(prev[j], m);
                        }
                        calc(visited, y, x, i);
                        search(cctvIdx++, visited);
                    }
                    break;
                case 2:
                    for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < n; j++) {
                            visited[j] = Arrays.copyOf(prev[j], m);
                        }
                        calc(visited, y, x, i);
                        calc(visited, y, x, i + 2);
                        search(cctvIdx++, visited);
                    }
                    break;
                case 3:
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < n; j++) {
                            visited[j] = Arrays.copyOf(prev[j], m);
                        }
                        calc(visited, y, x, i);
                        calc(visited, y, x, (i + 1) % 4);
                        search(cctvIdx++, visited);
                    }
                    break;
                case 4:
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < n; j++) {
                            visited[j] = Arrays.copyOf(prev[j], m);
                        }
                        calc(visited, y, x, (i + 1) % 4);
                        calc(visited, y, x, (i + 2) % 4);
                        search(cctvIdx++, visited);
                    }
                    break;
                case 5:
                    for (int j = 0; j < n; j++) {
                        visited[j] = Arrays.copyOf(prev[j], m);
                    }
                    calc(visited, y, x, 0);
                    calc(visited, y, x, 1);
                    calc(visited, y, x, 2);
                    calc(visited, y, x, 3);
                    search(cctvIdx++, visited);
                    break;
            }
        }
    }

    static void calc(int[][] visited, int i, int j, int dir) {
        switch (dir) {
            case 0:
                for (int k = j; k >= 0; k--) {
                    if (map[i][k] == 6) {
                        break;
                    }
                    visited[i][k] = 7;
                }
                break;
            case 1:
                for (int k = i; k >= 0; k--) {
                    if (map[i][k] == 6) {
                        break;
                    }
                    visited[i][k] = 7;
                }
                break;
            case 2:
                for (int k = j; k < m; k++) {
                    if (map[i][k] == 6) {
                        break;
                    }
                    visited[i][k] = 7;
                }
                break;
            case 3:
                for (int k = i; k < n; k++) {
                    if (map[k][j] == 6) {
                        break;
                    }
                    visited[k][j] = 7;
                }
                break;
        }
    }

    static class Node {
        int x;
        int y;
        int type;

        public Node(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}

