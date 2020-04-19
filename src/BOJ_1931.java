import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1931 {
    static int max = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        ArrayList<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetings.add(new Meeting(start, end));
        }

        Collections.sort(meetings);

        int end =0;
        int count =0;
        for(Meeting m : meetings) {
            if (end <= m.start) {
                count++;
                end = m.end;
            }
        }
        System.out.println(count);
    }

    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if(this.end > o.end) {
                return 1;
            } else if (this.end == o.end) {
                if(this.start > o.start) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }
    }

// 시간 초과..
//    static int max = 0;
//    static int N;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());
//
//        int[][] meeting = new int[N][2];
//
//        for (int i = 0; i < N; i++) {
//            String input = br.readLine();
//            StringTokenizer st = new StringTokenizer(input);
//
//            meeting[i][0] = Integer.parseInt(st.nextToken());
//            meeting[i][1] = Integer.parseInt(st.nextToken());
//        }
//
//        for (int i = 0; i < N; i++) {
//            int count =1;
//            int end = meeting[i][1];
//            for (int j = i+1; j < N; j++) {
//                if (meeting[j][0] >= end) {
//                    end = meeting[j][1];
//                    count++;
//                }
//            }
//            max = Math.max(max, count);
//        }
//        System.out.println(max);
//    }
}
