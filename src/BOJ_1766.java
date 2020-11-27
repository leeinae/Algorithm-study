import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class BOJ_1766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] degree = new int[n + 1];
        LinkedList<Integer>[] list = new LinkedList[n + 1];
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            list[i] = new LinkedList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());

            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            list[p1].add(p2);
            degree[p2]++;
        }

        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            bw.write(curr + " ");

            for (int i = 0; i < list[curr].size(); i++) {
                int next = list[curr].get(i);
                degree[next]--;

                if (degree[next] == 0) {
                    q.add(next);
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
