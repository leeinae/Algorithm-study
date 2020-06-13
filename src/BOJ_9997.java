import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9997 {
    static int[] words;
    static int n;
    static int answer;
    static final int ALPHA = (1 << 26) - 1;
    //0000 0100 0000 0000 0000 0000 0000 0000
    //0000 0011 1111 1111 1111 1111 1111 1111

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        words = new int[n];

        System.out.println(ALPHA);
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");

            for (int j = 0; j < input.length; j++) {
                //abc ==> 0111
                words[i] |= 1 << input[j].charAt(0) - 'a';
            }
        }

        dfs(-1, 0);

        System.out.println(answer);
    }

    static void dfs(int count, int mask) {
        if (count == n - 1) {
            if (mask == ALPHA) {
                answer++;
            }
        } else {
            dfs(count + 1, mask | words[count+1]);
            dfs(count + 1, mask);
        }
    }
}
