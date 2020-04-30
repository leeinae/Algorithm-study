import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17822 {
    static int N, M, T;
    static int[][] board;
    static boolean sameNumberFlag = false;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //원판 수
        M = Integer.parseInt(st.nextToken()); //원판에 적인 정수의 수
        T = Integer.parseInt(st.nextToken()); //회전 수

        board = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); //배수
            int d = Integer.parseInt(st.nextToken()); //방향 (0: 시계, 1:반시계)
            int k = Integer.parseInt(st.nextToken()); //회전 칸

            //회전 수가 4 이상일 때
            if (k >= 4) {
                k = k - ((k/4) * 4);
            }

            //무조건 시계방향으로 전환. 회전 칸 1->3 / 3->1
            if (d == 1) {
                if (k == 3) {
                    k = 1;
                } else if (k == 1) {
                    k = 3;
                }
            }

            for (int j = 1; j <= N; j++) {
                if (j % x == 0) {
                    //j+1을 회전한다. d 방향으로 k칸.
                    rotate(j, k);
                }
            }
            check();
        }

        System.out.println(sumBoard());
    }

    //j는 회전할 행
    static void rotate(int j, int k) {
        int[] temp = new int[M+1];

        for (int i = 1; i <= M; i++) {
            int idx;

            if (i + k > M) {
                idx = (i + k) % M;
            } else {
                idx = i + k;
            }

            temp[idx] = board[j][i];
        }
        board[j] = temp;
    }

    static void check() {
        boolean numFlag = false; //수를 지운 적 없으면 false;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sameNumberFlag = false; //같은 수가 없으면 false;
                if (board[i][j] != 0) {
                    //인접한 거 탐색 & 같은 수 지우기 (dfs)
                    dfs(i, j, board[i][j]);
                }

                if (sameNumberFlag) {
                    board[i][j] = 0;
                    numFlag = true;
                }
            }
        }

        if (!numFlag) {
            calculateBoard();
        }
    }

    static void dfs(int x, int y, int num) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = (y + dy[i]) % M;

            if (ny == 0) {
                ny = M;
            }

            if (nx <= 0 || nx > N || ny <= 0 || ny > M) {
                continue;
            }

            if (board[nx][ny] == num) {
                sameNumberFlag = true;
                board[nx][ny] = 0;
                dfs(nx, ny, num);
            }
        }
    }

    static void calculateBoard() {
        double sum =0;
        int totalNum =0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (board[i][j] != 0) {
                    sum += board[i][j];
                    totalNum++;
                }
            }
        }

        if (totalNum == 0) {
            return;
        }

        double avg = sum / totalNum;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (board[i][j] != 0) {
                    if (board[i][j] < avg) {
                        board[i][j]++;
                    } else if (board[i][j] > avg) {
                        board[i][j]--;
                    }
                }
            }
        }
    }

    static int sumBoard() {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sum += board[i][j];
            }
        }
        return sum;
    }

}
