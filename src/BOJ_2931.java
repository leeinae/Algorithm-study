import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2931 {
    static int[][] map;
    static boolean[][] visited;
    static Node M, Z;
    static int r, c;
    static int[] dx = {-1, 1, 0, 0}; //0: 상, 1: 하, 2: 좌, 3: 우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        r = Integer.parseInt(str[0]);
        c = Integer.parseInt(str[1]);

        map = new int[r + 1][c + 1];
        visited = new boolean[r + 1][c + 1];

        for (int i = 1; i <= r; i++) {
            String input = br.readLine();
            for (int j = 1; j <= c; j++) {
                map[i][j] = input.charAt(j - 1);

                if (map[i][j] == 'M') {
                    M = new Node(i, j, -1);
                } else if (map[i][j] == 'Z') {
                    Z = new Node(i, j, -1);
                }
            }
        }

        Node firstM = firstBlock(M); // M에서 시작하는 가스관

        Node endM = dfs(firstM); // M에서 끊기는 지점

        solution(endM);
    }

    static void solution(Node n) {
        int x = n.x;
        int y = n.y;
        boolean[] blocks = new boolean[4];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx <= 0 || ny <= 0 || nx > r || ny > c) {
                continue;
            }

            int block = map[nx][ny];
            switch (i) {
                case 0: //상
                    if (block == '|' || block == '+' || block == '1' || block == '4') {
                        blocks[i] = true;
                    }
                    break;
                case 1: //하
                    if (block == '|' || block == '+' || block == '2' || block == '3') {
                        blocks[i] = true;
                    }
                case 2: //좌
                    if (block == '-' || block == '+' || block == '1' || block == '2') {
                        blocks[i] = true;
                    }
                    break;
                case 3: //우
                    if (block == '-' || block == '+' || block == '3' || block == '4') {
                        blocks[i] = true;
                    }
            }
        }

        char answer = getBlock(blocks);

        System.out.println(x + " " + y + " " + answer);
    }

    static char getBlock(boolean[] blocks) {
        char block = '-';

        if (blocks[0] && blocks[1] && blocks[2] && blocks[3]) {
            return '+';
        } else if (blocks[0] && blocks[1]) {
            return '|';
        } else if (blocks[2] && blocks[3]) {
            return '-';
        } else if (blocks[1] && blocks[3]) {
            return '1';
        } else if (blocks[0] && blocks[3]) {
            return '2';
        } else if (blocks[0] && blocks[2]) {
            return '3';
        } else if (blocks[1] && blocks[2]) {
            return '4';
        }

        return block;
    }

    static Node firstBlock(Node n) {
        int x = n.x;
        int y = n.y;

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx <= 0 || ny <= 0 || nx > r || ny > c) {
                continue;
            }

            if (map[nx][ny] != '.' && map[nx][ny] != 'Z' && map[nx][ny] != 'M') {
                visited[nx][ny] = true;
                return new Node(nx, ny, getDir(map[nx][ny], i));
            }
        }

        return null;
    }

    static Node dfs(Node n) {
        int nx = n.x + dx[n.dir];
        int ny = n.y + dy[n.dir];

        if (map[nx][ny] == '.') {
            return new Node(nx, ny, n.dir);
        } else {
            visited[nx][ny] = true;
            return dfs(new Node(nx, ny, getDir(map[nx][ny], n.dir)));
        }
    }

    static int getDir(int block, int prevDir) {
        switch (block) {
            case '1':
                if (prevDir == 0) {
                    return 3;
                }
                if (prevDir == 2) {
                    return 1;
                }
                break;
            case '2':
                if (prevDir == 1) {
                    return 3;
                }
                if (prevDir == 2) {
                    return 0;
                }
                break;
            case '3':
                if (prevDir == 1) {
                    return 2;
                }
                if (prevDir == 3) {
                    return 0;
                }
                break;
            case '4':
                if (prevDir == 3) {
                    return 1;
                }
                if (prevDir == 0) {
                    return 2;
                }
                break;
        }

        return prevDir;
    }

    static class Node {
        int x;
        int y;
        int dir;

        public Node(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", dir=" + dir +
                    '}';
        }
    }
}
