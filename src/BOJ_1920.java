import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        // 첫 번째 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            int result = binarySearch(A, num);
            bw.write(result+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int binarySearch(int[] A, int num) {
        int min = 0;
        int max = A.length-1;

        while (min <= max) {
            int mid = (min + max) / 2;
            if (num == A[mid]) {
                return 1;
            }

            if (num > A[mid]) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return 0;
    }
}
