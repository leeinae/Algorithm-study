import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606_re {
    static int computer; // 컴퓨터 수
    static boolean[] visited;
    static LinkedList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        computer = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        list = new LinkedList[computer + 1];
        visited = new boolean[computer + 1];

        for (int i = 1; i <= computer; i++) {
            list[i] = new LinkedList<>();
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            list[c1].add(c2);
            list[c2].add(c1);
        }

        spread();
        check();
    }

    public static void spread() {
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int next : list[temp]) {
                if (visited[next]) continue;

                visited[next] = true;
                q.add(next);
            }
        }
    }

    public static void check() {
        int count = 0;

        for (boolean bool : visited) {
            if (bool) count++;
        }

        System.out.println(count - 1);
    }
}
