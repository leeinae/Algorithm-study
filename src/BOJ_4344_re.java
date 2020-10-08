import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4344_re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());

            int studentsNum = Integer.parseInt(st.nextToken());
            int[] students = new int[studentsNum];
            for (int i = 0; i < studentsNum; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }

            double avg = getAvg(students);

            bw.write(String.format("%.3f", getPercent(students, avg)) + "%");
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    public static double getPercent(int[] students, double avg) {
        double count = 0;

        for (int score : students) {
            count = avg < score ? count + 1 : count;
        }

        return count == 0 ? 0 : (count / students.length) * 100;
    }

    public static double getAvg(int[] students) {
        double avg = 0;

        for (int score : students) {
            avg += score;
        }

        return avg / students.length;
    }
}
