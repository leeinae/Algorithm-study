import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3055 {
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Point D;
    static Point S;
    static ArrayList<Point> water;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        water = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                if (input[j].equals("D")) {
                    map[i][j] = -3;
                    D = new Point(i, j, -3);
                } else if (input[j].equals("S")) {
                    map[i][j] = 1;
                    S = new Point(i, j, 1);
                } else if (input[j].equals("X")) {
                    map[i][j] = -1;
                } else if (input[j].equals("*")) {
                    map[i][j] = -2;
                    water.add(new Point(i, j, -2));
                }
            }
        }
        bfs();

        if (map[D.x][D.y] == -3) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(map[D.x][D.y]-1);
        }
    }

    // 고슴 1
    // 돌 -1
    // 물 -2
    // 비버 -3
    static void bfs() {
        Queue<Point> q = new LinkedList<>();

        //물 먼저 Queue에
        for (int i = 0; i < water.size(); i++) {
            q.add(water.get(i));
        }

        //고슴도치
        q.add(S);

        while (!q.isEmpty()) {
            Point temp = q.poll();
            int tempInfo = temp.info;
            int x = temp.x;
            int y = temp.y;

            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                    if (tempInfo == 1) {
                        //고슴도치 
                        if (map[nx][ny] == 0) { // 다음 칸이 빈 칸일때
                            map[nx][ny] = map[x][y] + 1;
                            q.add(new Point(nx, ny, 1));
                        } else if (map[nx][ny] == -3) { //다음 칸이 도착일 때
                            map[nx][ny] = map[x][y] + 1;
                            break;
                        }
                    } else {
                        //물
                        if (map[nx][ny] == 0) {
                            map[nx][ny] = -2;
                            q.add(new Point(nx, ny, -2));
                        }
                    }
                }
            }
        }
    }

    static class Point {
        int x; int y;
        int info;

        public Point(int x, int y, int info) {
            this.x = x;
            this.y = y;
            this.info = info;
        }
    }
}
