import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {
    static int S;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int count = Integer.MAX_VALUE;

        while (start <= end) {
            if (sum >= S) {
                count = Math.min(end - start, count);
                sum -= arr[start++];
            } else if (end == arr.length) {
                break;
            } else {
                sum += arr[end++];
            }
        }

        System.out.println(count == Integer.MAX_VALUE ? 0 : count);
    }
}
