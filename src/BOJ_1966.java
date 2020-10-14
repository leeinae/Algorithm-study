import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); // 문서 수
            int m = Integer.parseInt(st.nextToken()); // 알려고하는 문서 번호

            Queue<Doc> queue = new LinkedList<>();

            int maxPriority = -1;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int temp = Integer.parseInt(st.nextToken());

                maxPriority = Math.max(maxPriority, temp);
                queue.add(new Doc(temp, i));
            }

            int count = 0;
            while (!queue.isEmpty()) {
                Doc doc = queue.poll();

                if (doc.priority >= maxPriority) {
                    // 출력 가능
                    count++;
                    maxPriority = getMax(queue);
                    if (doc.idx == m) break;
                } else {
                    queue.offer(doc);
                }

            }
            System.out.println(count);
        }
    }

    static int getMax(Queue<Doc> q) {
        int max = -1;
        for (Doc doc : q) {
            max = Math.max(doc.priority, max);
        }

        return max;
    }

    static class Doc {
        int priority;
        int idx;

        public Doc(int priority, int idx) {
            this.priority = priority;
            this.idx = idx;
        }
    }
}
