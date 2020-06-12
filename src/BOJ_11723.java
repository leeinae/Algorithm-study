import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        int mask = 0; //int는 4byte -> 32bit

        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String method = st.nextToken();
            int num;

            switch (method) {
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    mask |= (1 << (num -1));
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    sb.append((mask & (1 << (num - 1))) == 0 ? "0" : "1");
                    sb.append("\n");
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    mask &= ~(1 << (num - 1));
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    mask ^= (1 << (num - 1));
                    break;
                case "empty":
                    mask = 0;
                    break;
                case "all":
                    mask |= (~0);
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
