public class PRO_12926 {
    class Solution {
        public String solution(String s, int n) {
            String answer = "";
            char[] charArr = s.toCharArray();

            for (int i = 0; i < charArr.length; i++) {
                if (charArr[i] >= 65 && charArr[i] <= 90) {
                    charArr[i] += n;

                    if (charArr[i] > 90) {
                        charArr[i] -= 26;
                    }
                } else if (Character.isAlphabetic(charArr[i])) {
                    charArr[i] += n;

                    if (charArr[i] > 122) {
                        charArr[i] -= 26;
                    }
                }
            }
            answer = new String(charArr);

            return answer;
        }
    }
}
