import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_17143 {
    static int r;
    static int c;
    static int shark_num;
    static int total_size = 0;
    static Shark[][] map;
    static ArrayList<Shark> sharks = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        shark_num = Integer.parseInt(st.nextToken());

        if (shark_num == 0) {
            System.out.println(0);
            return;
        }

        map = new Shark[r + 1][c + 1];

        for (int i = 0; i < shark_num; i++) {
            String input = br.readLine();
            st = new StringTokenizer(input);

            int r = Integer.parseInt(st.nextToken()); //x
            int c = Integer.parseInt(st.nextToken()); //y
            int s = Integer.parseInt(st.nextToken()); //속력
            int d = Integer.parseInt(st.nextToken()); //방향
            int z = Integer.parseInt(st.nextToken()); //크기

            Shark shark = new Shark(r, c, z, s, d);
            map[r][c] = shark;
            sharks.add(shark);
        }

        for (int i = 1; i <= c; i++) {
            getShark(i);
            moveShark();
            eatShark();
        }

        System.out.println(total_size);
    }

    static void getShark(int col) {
        Shark temp = null;
        for (int i = 1; i <= r; i++) {
            if (map[i][col] != null) {
                temp = map[i][col];
                break;
            }
        }

        if (temp != null) {
            map[temp.x][temp.y] = null;
            total_size += temp.size;
            sharks.remove(temp);
        }
    }


    static void moveShark() {
        for (int i = 0; i < sharks.size(); i++) {
            Shark shark = sharks.get(i);
            map[shark.x][shark.y] = null;
            shark.go();
        }
    }

    static void eatShark() {
        for (int i = sharks.size() - 1; i >= 0; i--) {
            Shark s = sharks.get(i);
            if (map[s.x][s.y] == null) {
                map[s.x][s.y] = s;
            } else {
                if (map[s.x][s.y].size > s.size) {
                    sharks.remove(s);
                } else {
                    sharks.remove(map[s.x][s.y]);
                    map[s.x][s.y] = s;
                }
            }
        }
    }

    static class Shark {
        int x;
        int y;
        int size;
        int speed;
        int direction;

        public Shark(int x, int y, int size, int speed, int direction) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.speed = speed;
            this.direction = direction;
        }

        public void go() {
            for (int i = 0; i < speed; i++) {
                switch (this.direction) {
                    case 1: // 위
                        if (x == 1) {
                            x++;
                            this.direction = 2;
                        } else {
                            x--;
                        }
                        break;
                    case 2: //아래:
                        if (x == r) {
                            x--;
                            this.direction = 1;
                        } else {
                            x++;
                        }
                        break;
                    case 3: //오른쪽
                        if (y == c) {
                            y--;
                            this.direction = 4;
                        } else {
                            y++;
                        }
                        break;
                    case 4: //왼쪽:
                        if (y == 1) {
                            y++;
                            this.direction = 3;
                        } else {
                            y--;
                        }
                        break;
                }
            }
        }
    }
}
