public class PRO_12903 {
    class Solution {
        public String solution(String s) {
            String answer = "";
            char[] chars = s.toCharArray();

            if (chars.length % 2 == 0) {
                answer += String.valueOf(chars[(chars.length / 2) - 1]);
            }

            answer += String.valueOf(chars[chars.length / 2]);

            return answer;
        }
    }
}
