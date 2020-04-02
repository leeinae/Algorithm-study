import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    int V;
    LinkedList<Integer> adj[];

    public BFS(int v) {
        this.V = v;
        adj = new LinkedList[v];

        for(int i=0; i<v; i++ ) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int e) {
        adj[v].add(e);
    }

    public void bfs_search(int v, boolean check[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        check[v] = true;

        while(!q.isEmpty()) {
            int temp = q.poll();
            System.out.print(temp + " : ");

            for( int i : adj[v] ) {
                if( !check[i] ) {
                    q.add(i);
                    check[i] = true;
                }
            }
        }
    }

    public void bfs_start(int v) {
        boolean check[] = new boolean[V];
        bfs_search(v, check);
    }

    public static void main(String[] args) {
        BFS g = new BFS(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 0);
        g.addEdge(1, 4);
        g.addEdge(1, 5);
        g.addEdge(4, 1);
        g.addEdge(5, 1);
        g.addEdge(2, 0);
        g.addEdge(3, 0);

        g.bfs_start(0);
    }
}
