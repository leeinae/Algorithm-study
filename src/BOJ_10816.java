import java.util.Scanner;
import java.util.Arrays;

public class BOJ_10816 {
    static int[] card;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        card = new int[n];

        for (int i = 0; i < n; i++) {
            card[i] = sc.nextInt();
        }

        Arrays.sort(card);

        int m = sc.nextInt();
        int[] num = new int[m];

        for (int i = 0; i < m; i++) {
            num[i] = sc.nextInt();

            int left = findLeft(0, n, num[i]);
            int right = findRight(0, n, num[i]);

            sb.append(right - left).append(" ");
        }

        System.out.println(sb);
    }

    static int findRight(int left, int right, int target) {
        int mid = (left + right) / 2;
        if (left >= right) {
            return mid;
        }

        if (card[mid] <= target) {
            return findRight(mid + 1, right, target);
        } else {
            return findRight(left, mid, target);
        }
    }

    static int findLeft(int left, int right, int target) {
        int mid = (left + right) / 2;

        if (left >= right) {
            return mid;
        }

        if (card[mid] >= target) {
            return findLeft(left, mid, target);
        } else {
            return findLeft(mid + 1, right, target);
        }
    }
}
