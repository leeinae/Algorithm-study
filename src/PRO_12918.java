public class PRO_12918 {
    class Solution {
        public boolean solution(String s) {
            boolean answer = true;

            answer = isLimit(s) && isNumeric(s) ? true : false;
            return answer;
        }

        public boolean isLimit(String s) {
            return s.length() == 4 || s.length() == 6 ? true : false;
        }

        public boolean isNumeric(String s) {
            char[] str = s.toCharArray();
            boolean flag = true;

            for (char c : str) {
                if (!Character.isDigit(c)) flag = false;
            }

            return flag;
        }
    }
}
