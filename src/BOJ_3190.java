import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class BOJ_3190 {
    static int n;
    static char[][] map;
    static Stack<Point> snake = new Stack<>();
    static int count = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Integer> times;
    static Queue<Character> dirs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine()); // 보드의 크기
        int k = Integer.parseInt(br.readLine()); // 사과의 개수

        map = new char[n + 2][n + 2];

        Point s = new Point(1, 1, 0);
        snake.push(s); // 머리
        map[1][1] = '*';

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 'A';
        }

        for (int i = 0; i < n + 2; i++) {
            map[0][i] = map[n+1][i] = map[i][0] = map[i][n+1] = '#';
        }

        int d = Integer.parseInt(br.readLine()); // 회전 수
        times = new LinkedList<>();
        dirs = new LinkedList<>();

        for (int i = 0; i < d; i++) {
            st = new StringTokenizer(br.readLine());

            times.add(Integer.parseInt(st.nextToken()));
            dirs.add(st.nextToken().charAt(0));
        }

        run();
        System.out.println(count);
    }

    static void run() {
        while (true) {
            Point head = snake.peek();
            int dir = head.dir;
            int nx = head.x + dx[dir];
            int ny = head.y + dy[dir];

            count++;
            if (isEdge(nx, ny) || isSnake(nx, ny)) {
                break;
            }

            snake.push(new Point(nx, ny, dir));

            // 사과 X
            if (map[nx][ny] != 'A') {
                Point tail = snake.remove(0); // 꼬리 삭제
                map[tail.x][tail.y] = ' ';
            }

            map[nx][ny] = '*';

            // 회전
            if (!times.isEmpty() && count == times.peek()) {
                times.remove();

                char c = dirs.poll();
                int nd = (c == 'L') ? (dir + 3) % 4 : (dir + 1) % 4;

                Point temp = snake.pop();
                temp.dir = nd;

                snake.push(temp);
            }
        }
    }

    static boolean isEdge(int x, int y) {
        if (map[x][y] == '#') {
            return true;
        }

        return false;
    }

    static boolean isSnake(int x, int y) {
        if (map[x][y] == '*') {
            return true;
        }

        return false;
    }

    static class Point{
        int x; int y;
        int dir;

        public Point(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}
