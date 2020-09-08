import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class BOJ_2212 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sc.nextInt();
        int k = sc.nextInt();

        if (k >= n) {
            bw.write("0");
            bw.flush();
            return;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int answer = calc(arr, k);

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    static int calc(int[] arr, int k) {
        int[] diff = new int[arr.length - 1];

        for (int i = 0; i < arr.length - 1; i++) {
            diff[i] = arr[i + 1] - arr[i];
        }

        Arrays.sort(diff);

        int num = 0;
        for (int i = 0; i < arr.length - k; i++) {
            num += diff[i];
        }

        return num;
    }
}
