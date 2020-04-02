import java.util.Iterator;
import java.util.LinkedList;

public class DFS {
    int V; // 노드의 수
    LinkedList<Integer> adj[]; //인접 리스트

    DFS(int v) {
        this.V = v;
        adj = new LinkedList[v];

        /* 인접 리스트 초기화 */
        for(int i=0; i<v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /* 노드 연결 */
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void checkVisited(int v, boolean visited[]) {
        visited[v] = true; //방문
        System.out.println(v +" 방문");

        Iterator<Integer> i = adj[v].listIterator(); //방문 노드와 인접한 노드
        while(i.hasNext()) {
            int n = i.next();
            // 인접 노드 중에 방문 안했으면 방문하기
            if(visited[n] == false) {
                checkVisited(n, visited);
            }
        }
    }

    public void DFS_start(int v) {
        boolean visited[] = new boolean[V]; //false

        checkVisited(v, visited);
    }

    public void DFS_all() {
        boolean[] visited = new boolean[V];

        for(int i=0; i<V; i++) {
            if ( visited[i] == false ) {
                checkVisited(i, visited);
            }
        }
    }

    public static void main(String[] args) {
        DFS g = new DFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.DFS_start(2);
        g.DFS_all();
    }
}
