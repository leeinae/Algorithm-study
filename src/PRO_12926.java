public class PRO_12926 {
    class Solution {
        public String solution(String s, int n) {
            String answer = "";
            char[] charArr = s.toCharArray();

            for (int i = 0; i < charArr.length; i++) {
                if (Character.isUpperCase(charArr[i])) charArr[i] = (char) (((charArr[i] - 'A' + n) % 26) + 'A');
                else if (Character.isLowerCase(charArr[i])) charArr[i] = (char) (((charArr[i] - 'a' + n) % 26) + 'a');
            }
            answer = new String(charArr);

            return answer;
        }
    }
}
