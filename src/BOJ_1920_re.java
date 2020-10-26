import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class BOJ_1920_re {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashSet<Integer> hs = new HashSet<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            hs.add(sc.nextInt());
        }

        int m = sc.nextInt();
        for (int j = 0; j < m; j++) {
            bw.write(hs.contains(sc.nextInt()) ? "1" : "0");
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
