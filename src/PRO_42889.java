import java.util.ArrayList;
import java.util.Collections;

public class PRO_42889 {
    class Solution {
        public int[] solution(int N, int[] stages) {
            int[] answer = new int[N];
            ArrayList<Stage> percent = new ArrayList<>();

            int stage = 1;
            while (stage <= N) {
                int noClearPlayer = 0;
                int player = 0;

                for (int userScore : stages) {
                    if (userScore >= stage) player++;
                    if (userScore <= stage) noClearPlayer++;
                }

                noClearPlayer = (player == stages.length) ? noClearPlayer : noClearPlayer - (stages.length - player);

                double fail = player == 0 ? 0 : noClearPlayer / (double) player;
                percent.add(new Stage(stage, fail));

                stage++;
            }

            Collections.sort(percent);

            for (int i = 0; i < percent.size(); i++) {
                answer[i] = percent.get(i).stage;
            }

            return answer;
        }
    }

    class Stage implements Comparable<Stage> {
        int stage;
        double percent;

        Stage(int stage, double percent) {
            this.stage = stage;
            this.percent = percent;
        }

        @Override
        public int compareTo(Stage o) {
            if (o.percent == this.percent) {
                return o.stage > this.stage ? -1: 1;
            }

            return o.percent > this.percent ? 1: -1;
        }
    }
}
