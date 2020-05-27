import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2352 {
    static int[] port;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        port = new int[n];

        for (int i = 0; i < n; i++) {
            port[i] = sc.nextInt();
        }

        System.out.println(connect(n));

    }

    static int connect(int n) {
        int[] list = new int[n];

        list[0] = port[0];
        int len = 1;

        for (int i = 1; i < n; i++) {
            if (list[0] > port[i]) {
                list[0] = port[i];
            } else if (list[len - 1] < port[i]) {
                list[len] = port[i];
                len++;
            } else {
                int idx = Arrays.binarySearch(list, 0, len, port[i]);
                // 음수 리턴 : 그 수가 들어갈 수 있는 적절한 위치 idx(음수) 반환
                idx = (idx < 0) ? -idx - 1 : idx;
                list[idx] = port[i];
            }
        }
        return len;
    }
}
