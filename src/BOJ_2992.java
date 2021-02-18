import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2992 {
    static int min = Integer.MAX_VALUE;
    static boolean isExist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");

        int size = str.length;
        boolean[] visited = new boolean[size];
        int[] arr = new int[size];
        int[] output = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        int t = getNumber(arr);

        perm(t, arr, output, visited, 0, size, size);
        if (isExist) {
            System.out.println(min);
        } else {
            System.out.println(0);
        }
    }

    static void perm(int origin, int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            int tmp = getNumber(output);
            if (tmp > origin && tmp < min) {
                min = tmp;
                isExist = true;
            }

            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            output[depth] = arr[i];
            perm(origin, arr, output, visited, depth + 1, n, r);
            visited[i] = false;
        }
    }

    static int getNumber(int[] arr) {
        int temp = 0;
        int size = arr.length;

        for (int i = 0; i < size; i++) {
            temp += arr[i] * Math.pow(10, size - i - 1);
        }

        return temp;
    }
}
