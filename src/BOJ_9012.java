import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class BOJ_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            char[] str = br.readLine().toCharArray();
            bw.write(checkValid(str) ? "YES" : "NO");
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    public static Boolean checkValid(char[] str) {
        Stack stack = new Stack();
        int idx = 0;

        if (str[0] == ')') {
            return false;
        }

        while (str.length > idx) {
            if (str[idx] == '(') {
                stack.push(str[idx]);
            } else if (stack.isEmpty() && str[idx] == ')') {
                return false;
            } else {
                stack.pop();
            }

            idx++;
        }

        return stack.isEmpty();
    }
}

