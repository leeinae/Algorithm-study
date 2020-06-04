import java.util.Scanner;

public class BOJ_3678 {
    static int[][] board;
    static int[] numbers;
    static int[] frequency = {0, 1, 0, 0, 0, 0}; // 자원의 사용 빈도
    static int[] dx = {-2, -1, 1, 2, 1, -1};
    static int[] dy = {0, -1, -1, 0, 1, 1};
    static int sx = 200, sy = 100;
    static int count = 1, level = 1; // lev : 육각형의 길이
    static boolean[] resource; // 자원의 사용 가능 여부

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        board = new int[401][201];
        numbers = new int[10001]; //n번째 타일의 값을 저장

        board[sx][sy] = 1;
        numbers[1] = 1;

        setting();

        for (int i = 0; i < tc; i++) {
            int n = sc.nextInt();
            System.out.println(numbers[n]);
        }
    }

    static void check() {
        resource = new boolean[6];

        // 인접한 보드의 값을 구하고, 현재 칸에 넣을 수 있는 값 구하기
        for (int i = 0; i < 6; i++) {
            int nx = sx + dx[i];
            int ny = sy + dy[i];
            int num = board[nx][ny];

            if (num != 0) {
                resource[num] = true; // 인접함
            }
        }

        int idx = 0;
        int maxIdx = 10000;
        for (int i = 1; i < 6; i++) {
            if (!resource[i]) { // 인접하지 않은 자원
                if (frequency[i] < maxIdx) {
                    maxIdx = frequency[i];
                    idx = i;
                }
            }
        }

        board[sx][sy] = idx;
        frequency[idx]++;
        numbers[++count] = idx;
    }

    static void setting() {
        while (level < 61) {
            /* ↗방향으로 시작 */
            sx--;
            sy++; //
            check();

            if (count == 10000) {
                return;
            }

            /* 상 방향 n-1번 수행 */
            for (int i = 0; i < level - 1; i++) {
                sx += dx[0];
                sy += dy[0];
                check();

                if (count == 10000) {
                    return;
                }
            }

            /* 나머지 방향 n번씩 수행*/
            for (int i = 1; i <= 5; i++) {
                for (int j = 0; j < level; j++) {
                    sx += dx[i];
                    sy += dy[i];
                    check();

                    if (count == 10000) {
                        return;
                    }
                }
            }
            level++;
        }
    }
}
