import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1260 {
    LinkedList<Integer> adjList[];
    static int V;

    public BOJ_1260(int n, int m, int v) {
        adjList = new LinkedList[n+1];
        this.V = v;

        for(int i=1; i<=n; i++) {
            adjList[i] = new LinkedList<>();
        }

        for(int i=0; i<m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            addEdge(v1, v2);
        }

        //정점 번호가 작은 것부터 방문하기위해 정렬
        for(int i=1; i<n; i++) {
            Collections.sort(adjList[i]);
        }
    }

    public void addEdge(int v1, int v2) {
        //노드와 노드를 연결한다 (간선은 양방향)
        adjList[v1].add(v2);
        adjList[v2].add(v1);
    }

    public void DFS(int v, boolean[] visited) {
        if( visited[v] ) {
            return;
        }

        visited[v] = true; //방문함
        System.out.print(v + " ");

        for( int i : adjList[v] ) {
            if( !visited[i] ) {
                DFS(i, visited);
            }
        }
    }

    public void BFS(int v, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();

        //시작 정점을 Queue에 넣고, 방문 처리
        q.add(v);
        visited[v] = true;

        while (!q.isEmpty()) {
            int next = q.poll();
            System.out.print(next + " ");

            for( int i : adjList[next] ) {
                if( !visited[i] ) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        sc.init();
        int n = sc.nextInt(); //정점의 개수
        int m = sc.nextInt(); //간선의 개수
        int v = sc.nextInt(); //탐색 시작 정점

        BOJ_1260 g = new BOJ_1260(n, m, v);
        boolean visited[] = new boolean[n+1];

        g.DFS(V, visited);

        //BFS 시작을 위해 visited 배열 false로 세팅
        Arrays.fill(visited, false);
        System.out.println();

        g.BFS(V, visited);
    }

    static class sc {
         private static BufferedReader br;
         private static StringTokenizer st;

         static void init() {
             br = new BufferedReader(new InputStreamReader(System.in));
             st = new StringTokenizer("");
         }

         static String readLine() {
             try {
                 return br.readLine();
             } catch (IOException e) {
                 e.printStackTrace();
             }
             return null;
         }

         static String next() {
             while(!st.hasMoreTokens()) {
                 try {
                     st = new StringTokenizer(br.readLine());
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
             return st.nextToken();
         }

         static int nextInt() {
             return Integer.parseInt(next());
         }
    }
}
