import java.util.ArrayList;

public class PRO_42840 {
    static int[] s1 = {1, 2, 3, 4, 5};
    static int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5};
    static int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    class Solution {
        public int[] solution(int[] answers) {
            int[] answer = {};
            ArrayList<Integer> arr = new ArrayList<>();
            int[] scores = new int[3];

            for (int i = 0; i < answers.length; i++) {
                scores[0] += s1[i % s1.length] == answers[i] ? 1 : 0;
                scores[1] += s2[i % s2.length] == answers[i] ? 1 : 0;
                scores[2] += s3[i % s3.length] == answers[i] ? 1 : 0;
            }

            int max = Math.max(scores[0], Math.max(scores[1], scores[2]));

            for (int i = 1; i <= 3; i++) {
                if (max == scores[i - 1]) {
                    arr.add(i);
                }
            }

            answer = new int[arr.size()];

            for (int i = 0; i < arr.size(); i++) {
                answer[i] = arr.get(i);
            }

            return answer;
        }
    }
}
