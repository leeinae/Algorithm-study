import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_16235 {
    static int N;
    static int M;
    static int K;
    static int[][] map;
    static int[][] nutr;
    static LinkedList<Tree> trees = new LinkedList<>();
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        nutr = new int[N+1][N+1];

        // 양분 채우기
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); //겨울에 추가되는 양분 값
                nutr[i][j] = 5; //기본 양분값
            }
        }

        // 나무 정보
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            trees.add(new Tree(x, y, n, 1));
        }

        for (int i = 0; i < K; i++) {
            spring();
            summer();
            fall();
            winter();
        }

        System.out.println(trees.size());
    }

    static void spring() {
        for (Tree t : trees) {
            if (nutr[t.x][t.y] >= t.age) {
                nutr[t.x][t.y] -= t.age;
                t.age++;
            } else {
                t.life = 0;
            }
        }
    }

    /*
    * 원래 deadTrees LinkedList 새로 만들고, trees에서 삭제하는 방식을 썼었는데 시간초과남
    * iterator 사용으로 해결 완료
    * iterator 사용 시 반복문을 순환하는 동안 컬렉션을 안전하게 사용할 수 있음.
    * */
    static void summer() {
        for (Iterator<Tree> itt = trees.iterator(); itt.hasNext();) {
            Tree t = itt.next();
            if (t.life == 0) {
                int n = t.age / 2;
                nutr[t.x][t.y] += n;

                itt.remove();
            }
        }
    }

    static void fall() {
        LinkedList<Tree> newTrees = new LinkedList<>();
        for (Tree t : trees) {
            if (t.age % 5 == 0) {
                for (int j = 0; j < 8; j++) {
                    int nx = t.x + dx[j];
                    int ny = t.y + dy[j];

                    if (nx > 0 && nx <= N && ny > 0 && ny <= N ) {
                        newTrees.add(new Tree(nx, ny, 1, 1));
                    }
                }
            }
        }
        trees.addAll(0, newTrees);
    }

    static void winter() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                nutr[i][j] += map[i][j];
            }
        }
    }

    static class Tree {
         int x;
         int y;
         int age;
         int life;

        public Tree(int x, int y, int age, int life) {
            this.x = x;
            this.y = y;
            this.age = age;
            this.life = life;
        }
    }
}
