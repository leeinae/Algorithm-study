public class PRO_12943 {
    class Solution {
        public int solution(int num) {
            int answer = 0;
            long longNum = num;

            // answer = longNum == 1 ? 1 : 0;
            while (longNum != 1 && answer < 500) {
                longNum = longNum % 2 == 0 ? longNum / 2 : (longNum * 3) + 1;

                ++answer;
            }

            answer = answer >= 500 ? -1 : answer;
            return answer;
        }
    }
}
