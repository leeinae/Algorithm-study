import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ_1717 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n + 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int method;
        int a;
        int b;
        for (int i = 0; i < m; i++) {
            method = sc.nextInt();
            a = sc.nextInt();
            b = sc.nextInt();

            if (method == 0) {
                // 부모 합치기
                unionParent(arr, a, b);

            } else {
                // 같은 집합인지 확인
                if (find(arr, a, b)) {
                    bw.write("YES");
                } else {
                    bw.write("NO");
                }
                bw.newLine();
            }
        }

        bw.flush();
    }

    static int getParent(int[] arr, int num) {
        if (arr[num] == num) {
            return num;
        } else {
            arr[num] = getParent(arr, arr[num]);
            return arr[num];
        }
    }

    static void unionParent(int[] arr, int a, int b) {
        a = getParent(arr, a);
        b = getParent(arr, b);

        if (a < b) {
            arr[b] = a;
        } else {
            arr[a] = b;
        }
    }

    static boolean find(int arr[], int a, int b) {
        a = getParent(arr, a);
        b = getParent(arr, b);

        if (a == b) {
            return true;
        } else {
            return false;
        }
    }
}
