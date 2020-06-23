import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Stack<Tower> stack = new Stack<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int value = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty()) {
                int prev = (int) stack.peek().value;
                int idx = (int) stack.peek().idx;

                if (prev >= value) {
                    bw.write(idx + " ");
                    break;
                } else {
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                bw.write("0 ");
            }

            stack.push(new Tower(i, value));
        }

        bw.flush();
    }


    static class Tower {
        int idx;
        int value;

        public Tower(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
