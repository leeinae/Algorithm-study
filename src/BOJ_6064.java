import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class BOJ_6064 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCate = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCate; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int count = x % (m + 1);
            int tempY = x;

            for (int j = 0; j < n; j++) {
                int ty = tempY % n == 0 ? n : tempY % n;
                if (ty == y) {
                    break;
                }

                tempY = ty + m;
                count += m;
            }

            if (count > lcm(m, n)) {
                bw.write(-1 + "\n");
            } else {
                bw.write(count + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    /* 최소 공배수 */
    static int lcm(int x, int y) {
        return x * y / gcd(x, y);
    }

    /* 최대 공약수*/
    static int gcd(int x, int y) {
        while (y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        return x;
    }

    // 시간 초과
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int testCate = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < testCate; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int m = Integer.parseInt(st.nextToken());
//            int n = Integer.parseInt(st.nextToken());
//            int x = Integer.parseInt(st.nextToken());
//            int y = Integer.parseInt(st.nextToken());
//
//            boolean isExist = false;
//
//            for (int j = 0; j < m * n; j++) {
//                if (j % m == x && j % n == y) {
//                    isExist = true;
//                    bw.write(j + "\n");
//                }
//
//                if (isExist) {
//                    break;
//                }
//            }
//            if (!isExist) {
//                bw.write(-1 + "\n");
//            }
//        }
//
//        bw.flush();
//        bw.close();
//    }
}
