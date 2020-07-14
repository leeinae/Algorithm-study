import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class BOJ_1620 {
    static Map<String, Integer> docA; //key: 알파벳
    static Map<Integer, String> docB; //key: 숫자

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        docA  = new HashMap<>();
        docB  = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String str = br.readLine();

            docA.put(str, i);
            docB.put(i, str);
        }

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            int c = str.charAt(0) - 'A';

            if (c >= 0 && c <= 65) {
                bw.write(docA.get(str).toString());
                bw.newLine();
            } else {
                //숫자
                int num = Integer.parseInt(str);
                bw.write(docB.get(num));
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }
}
