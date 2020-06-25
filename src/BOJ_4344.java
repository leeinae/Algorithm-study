import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            double avg = getAvg(arr);

            bw.write(String.format("%.3f", getPercent(avg, arr)) + "%");
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    static double getAvg(int[] arr) {
        double sum = 0;

        for (int n : arr) {
            sum += n;
        }

        return sum / (arr.length);
    }

    static double getPercent(double avg, int[] arr) {
        double count = 0;

        for (int score : arr) {
            if (score > avg) {
                count++;
            }
        }

        return (count / arr.length) * 100;
    }
}
