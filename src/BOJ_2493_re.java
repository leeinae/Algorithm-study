import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493_re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        Stack<Tower> stack = new Stack<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= num; i++) {
            int value = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty()) {
                int prev = stack.peek().value;
                int idx = stack.peek().idx;

                if (value <= prev) {
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
        bw.close();
    }

    static class Tower {
        private int idx;
        private int value;

        public Tower(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
