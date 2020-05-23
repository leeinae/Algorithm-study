import java.util.Scanner;

public class BOJ_1654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");

        int k = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        long max = 0;

        long[] line = new long[k];
        for (int i = 0; i < k; i++) {
            line[i] = sc.nextInt();
            max = Math.max(max, line[i]);
        }

        solve(line, n, max);
    }

    static void solve(long[] line, int n, long max) {
        long left = 1;
        long right = max;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (check(line, mid, n)) {
                left = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }

    static boolean check(long[] line, long mid, int n) {
        int count = 0;
        for (int i = 0; i < line.length; i++) {
            count += line[i] / mid;
        }

        return count >= n;
    }
}
