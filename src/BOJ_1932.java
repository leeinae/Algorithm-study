import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932 {
    static int[][] triangle;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 삼각형 길이
        triangle = new int[N+1][N+1]; //삼각형 각 노드
        int max = 0;

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());

                triangle[i][j] = Math.max(triangle[i][j] + triangle[i-1][j], triangle[i][j] + triangle[i-1][j-1]);
                max = Math.max(triangle[i][j], max);
            }
        }

        System.out.println(max);
    }


}
