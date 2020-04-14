import java.io.*;

public class BOJ_10989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[10001];

        for(int i=0; i<N; i++) {
            numbers[Integer.parseInt(br.readLine())] ++;
        }

        for (int i = 1; i <= 10000; i++) {
            if (numbers[i] > 0) {
                for(int j=0; j < numbers[i]; j++) {
                    bw.write(i + "\n");
                }
            }
        }

        br.close();
        bw.close();
    }
}
