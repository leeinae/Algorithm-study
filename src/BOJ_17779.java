import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17779 {
    static int N;
    static int[][] map;
    static int[][] flagMap;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int minAns = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                for (int d1 = 1; d1 <= N; d1++) {
                    for (int d2 = 1; d2 <= N; d2++) {
                        if ((x + d1 + d2) <= N
                                && (y - d1) >= 1
                                && (y - d1) < y
                                && (y + d2) > y
                                && (y + d2) <= N) {
                            flagMap = new int[N+1][N+1];
//                            System.out.println(x +", "+ y +"," + d1 + "<"+ d2);

                            setArea(x, y, d1, d2);
                            border(x, y, d1, d2);
                            count();
//                            print();
//                            System.out.println("-------------");
                        }
                    }
                }
            }
        }

        System.out.println(minAns);
    }

    static void border(int x, int y, int d1, int d2) {
        for (int i = 0; i <= d1; i++) {
            flagMap[x+i][y-i] = 5;
        }

        for (int i = 0; i <= d2; i++) {
            flagMap[x+i][y+i] = 5;
        }

        for (int i = 0; i <= d2; i++) {
            flagMap[x+d1+i][y-d1+i] = 5;
        }

        for (int i = 0; i <= d1; i++) {
            flagMap[x+d2+i][y+d2-i] = 5;
        }

        for (int i = 0; i < d1; i++) {
            section5(x + i + 1, y - i);
        }

        for (int i = 0; i < d2; i++) {
            section5(x + i + 1, y + i);
        }
    }

    //bfs
    static void section5(int x, int y) {
        flagMap[x][y] = 5;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 1 && nx <= N && ny >= 1 && ny <= N && flagMap[nx][ny] != 5) {
                section5(nx, ny);
            }
        }
    }

    static void setArea(int x, int y, int d1, int d2) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i < x + d1 && j <= y) {
                    flagMap[i][j] = 1;
                } else if (i <= x + d2 && j > y) {
                    flagMap[i][j] = 2;
                } else if (x + d1 <= i && j < y - d1 + d2) {
                    flagMap[i][j] = 3;
                } else if (x + d2 < i && y - d1 + d2 <= j) {
                    flagMap[i][j] = 4;
                } else {
                    flagMap[i][j] = 5;
                }
            }
        }
    }

    static void count() {
        int[] count = new int[6];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                count[flagMap[i][j]] += map[i][j];
            }
        }

        for (int i = 1; i <= 5; i++) {
            if (min > count[i]) {
                min = count[i];
            }
            if (max < count[i]) {
                max = count[i];
            }
        }
        minAns = Math.min(minAns, max - min);
    }

    static void print() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(flagMap[i][j] + " ");
            }
            System.out.println();
        }
    }
}
