import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11047 {
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] money = new int[N];

        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        for (int i = N-1; i >= 0; i--) {
            if(money[i] <= K) {
                count += K / money[i];
                K = K % money[i];
            }
        }
        System.out.println(count);
    }
}
