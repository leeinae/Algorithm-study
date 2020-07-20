import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13458 {
    static int n, b, c;
    static int[] room;

    public static void main(String[] args) throws IOException {
        init();
        long answer = calc();

        System.out.println(answer + n);
    }

    static long calc() {
        long answer = 0;

        for (int student : room) {
            int num = student - b; // 총 감독이 감시할 수 있는 응시자 제외

            if (num > 0) {
                long cNum = (num / c);
                cNum += (num % c) == 0 ? 0 : 1;

                answer += cNum;
            }
        }

        return answer;
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        room = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            room[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
    }
}
