import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2667 {

    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int[][] map;
    static int n; //지도 행 수
    static int total;  // 전체 단지 수
    static ArrayList<Integer> house = new ArrayList<>(); //단지 별 가구 수

    public static void bfs(int i, int j) {
        total++;
        int count=0;

        Queue<String> q = new LinkedList<>();
        q.add(i + "," + j);
        visited[i][j] = true;

        while(!q.isEmpty()) {
            count++;
            String[] str = q.poll().split(",");
            for (int z=0; z<4; z++) {
                int row = Integer.parseInt(str[0]);
                int col = Integer.parseInt(str[1]);
                row += dx[z];
                col += dy[z];

                if(row < 0 || row > n || col < 0 || col > n) {
                    continue;
                }

                if (!visited[row][col] && map[row][col] == 1) {
                    q.add(row + "," + col);
                    visited[row][col] = true;
                }
            }
        }
        house.add(count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1][n+1];

        map = new int[n+1][n+1];

        /* 맵 생성 */
        for (int i = 1; i <= n; i++) {
            input = br.readLine();
            for (int j = 1; j <= n; j++) {
                map[i][j] = input.charAt(j - 1) - '0';
            }
        }

        for (int i = 1; i <= n; i++) {
            for(int j=1; j<=n; j++) {
                //값이 1이고, 방문하지 않은 집
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(total);

        house.sort(null); //오름차순 정렬

        for(int i: house) {
            System.out.println(i);
        }
    }
}
