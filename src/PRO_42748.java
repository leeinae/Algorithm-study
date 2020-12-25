import java.util.Arrays;

public class PRO_42748 {
    class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];

            int count = 0;
            for (int[] comm : commands) {
                int i = comm[0] -1;
                int j = comm[1];
                int k = comm[2] -1;

                int[] temp = Arrays.copyOfRange(array, i, j);
                Arrays.sort(temp);

                answer[count++] = temp[k];
            }

            return answer;
        }
    }
}
