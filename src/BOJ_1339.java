import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1339 {
    static int[] word;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        word = new int[26];

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            int pos = (int) Math.pow(10, input.length - 1);

            for (int j = 0; j < input.length; j++) {
                word[input[j] - 'A'] += pos;

                pos /= 10;
            }
        }

        Arrays.sort(word);

        calc();
    }

    // 백트래킹 실패.. 
//    static void comb(int count) {
//        if (stack.size() == alphaList.size()) {
//            calc();
//            return;
//        }
//
//        for (int i = count; i > 9 - alphaList.size(); i--) {
//            stack.push(i);
//            comb(i - 1);
//            stack.pop();
//        }
//    }

    static void calc() {
        int num = 9;
        int answer = 0;
        for (int i = word.length - 1; i >= 0; i--) {
            if (num == 0) {
                break;
            }

            answer += word[i] * num--;
        }
        System.out.println(answer);
    }
}
