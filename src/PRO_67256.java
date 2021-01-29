public class PRO_67256 {
    class Solution {
        static final String left = "L";
        static final String right = "R";

        public String solution(int[] numbers, String hand) {
            StringBuilder answer = new StringBuilder();
            int leftPos = 10;
            int rightPos = 12;

            for (int number : numbers) {
                number = number == 0 ? 11 : number;

                switch (number) {
                    case 1:
                    case 4:
                    case 7:
                        answer.append(left);
                        leftPos = number;
                        break;
                    case 3:
                    case 6:
                    case 9:
                        answer.append(right);
                        rightPos = number;
                        break;
                    default:
                        int xPos = (number - 1) / 3;
                        int yPos = (number - 1) % 3;

                        int leftDist = Math.abs(xPos - ((leftPos - 1) / 3)) + Math.abs(yPos - ((leftPos - 1) % 3));
                        int rightDist = Math.abs(xPos - ((rightPos - 1) / 3)) + Math.abs(yPos - ((rightPos - 1) % 3));

                        if (leftDist == rightDist) {
                            if (hand.equals("left")) {
                                answer.append(left);
                                leftPos = number;
                            } else {
                                answer.append(right);
                                rightPos = number;
                            }
                        } else if (leftDist > rightDist) {
                            answer.append(right);
                            rightPos = number;
                        } else {
                            answer.append(left);
                            leftPos = number;
                        }

                        break;
                }
            }
            return answer.toString();
        }
    }
}
