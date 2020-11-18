import java.util.*;

public class BOJ_1931_re {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int meetingCount = sc.nextInt();
        ArrayList<Meeting> meeting = new ArrayList<>();

        for (int i = 0; i < meetingCount; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            meeting.add(new Meeting(start, end));
        }

        Collections.sort(meeting);

        int min = 0;
        int answer = 0;
        for (int i = 0; i < meetingCount; i++) {
            int start = meeting.get(i).start;

            if (start >= min) {
                min = meeting.get(i).end;
                answer++;
            }
        }

        System.out.println(answer);
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
            if (this.end > o.end) {
                return 1;
            } else if (this.end == o.end) {
                return this.start > o.start ? 1 : -1;
            } else {
                return -1;
            }
        }
    }
}
