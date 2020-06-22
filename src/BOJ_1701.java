import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1701 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int max = 0;
        int n = str.length();

        for (int i = 0; i < n; i++) {
            max = Math.max(max, getMaxSubString(str.substring(i, n)));
        }

        System.out.println(max);
    }

    static int getMaxSubString(String str) {
        int n = str.length();
        int max = 0;
        int j = 0;
        int[] pi = new int[n];

        for (int i = 1; i < n; i++) {
            while (j > 0 && str.charAt(j) != str.charAt(i)) {
                j = pi[j - 1];
            }
            if (str.charAt(i) == str.charAt(j)) {
                max = Math.max(pi[i] = ++j, max);
            }
        }

        return max;
    }
}
