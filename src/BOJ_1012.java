import java.io.*;
import java.util.*;

public class BOJ_1012 {
    static int[][] map;
    static int N, M, K;
    static int[] dx = {-1, 1, 0, 0}; //위, 아래, 왼, 오
    static int[] dy = {0, 0, -1, 1};

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); //가로
            N = Integer.parseInt(st.nextToken()); //세로
            K = Integer.parseInt(st.nextToken()); //배추 수

            map = new int[M][N];

            /* 배추 심기 */
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            int count = 0;
            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (map[x][y] ==1 ) {
                        bfs(x, y);
                        count++;
                    }
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
        br.close();
    }

    /*
    * 따로 방문 체크를 안하고, 방문한 배추는 0으로 바꿔줬다
    * */
    private static void bfs (int i, int j) {
        Queue<String> q = new LinkedList<>();
        q.add(i +","+j);
        map[i][j] = 0;

        while (!q.isEmpty()) {
            String[] loc = q.poll().split(",");

            for(int z=0; z<4; z++) {
                int x = Integer.parseInt(loc[0]) + dx[z];
                int y = Integer.parseInt(loc[1]) + dy[z];
                if(x>=0 && x<M && y>=0 && y<N && map[x][y] == 1) {
                    q.add(x+","+y);
                    map[x][y] = 0;
                }
            }
        }
    }
}