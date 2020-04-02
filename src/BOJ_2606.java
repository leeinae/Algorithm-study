import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2606 {
    static int count = 0;
    LinkedList<Integer> adj[];

    BOJ_2606(int n) {
        adj = new LinkedList[n+1];

        for(int i=0; i<=n; i++ ){
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v1, int v2) {
        adj[v1].add(v2);
        adj[v2].add(v1);
    }

    void search(int v, boolean[] visited) {
        if(visited[v]) {
            return;
        }

        visited[v] = true;

        for(int i : adj[v]) {
            if ( !visited[i] ) {
                count++;
                search(i, visited);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine()); //컴퓨터 수
        int m = Integer.parseInt(br.readLine()); //연결된 네트워크(간선) 수

        BOJ_2606 g = new BOJ_2606(n);

        for(int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            g.addEdge(v1, v2);
        }

        boolean visited[] = new boolean[n+1];
        g.search(1, visited);

        System.out.println(count);
    }
}
