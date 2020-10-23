import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3085 {
    static int answer = Integer.MIN_VALUE;
    static char[][] map;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                swap(i, j, i, j + 1);
                check();
                swap(i, j, i, j + 1);
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n - 1; i++) {
                swap(i, j, i + 1, j);
                check();
                swap(i, j, i + 1, j);
            }
        }

        System.out.println(answer);
    }

    static void swap(int i, int j, int k, int l) {
        char temp = map[i][j];
        map[i][j] = map[k][l];
        map[k][l] = temp;
    }

    static void check() {
        for (int i = 0; i < n; i++) {
            int candy = 1;
            for (int j = 0; j < n - 1; j++) {
                if (map[i][j] == map[i][j + 1]) {
                    candy++;
                } else {
                    answer = Math.max(answer, candy);
                    candy = 1;
                }
            }
            answer = Math.max(answer, candy);
        }

        for (int j = 0; j < n; j++) {
            int candy = 1;
            for (int i = 0; i < n - 1; i++) {
                if (map[i][j] == map[i + 1][j]) {
                    candy++;
                } else {
                    answer = Math.max(answer, candy);
                    candy = 1;
                }
            }
            answer = Math.max(answer, candy);
        }
    }
}
