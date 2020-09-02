import java.util.Stack;

public class Pro_64061 {
    public Stack<Integer> bucket = new Stack<Integer>();

    public int Pro_64061(int[][] board, int[] moves) {
        int answer = 0;
        bucket.push(0);

        for (int num : moves) {
            int pickNum = pick(board, num);
            int peekNum = bucket.peek();

            if (pickNum > 0 && pickNum == peekNum) {
                bucket.pop();
                answer += 2;
            } else if (pickNum > 0 && pickNum != peekNum) {
                bucket.push(pickNum);
            }
        }

        return answer;
    }

    public int pick(int[][] board, int num) {
        for (int i = 0; i < board[0].length; i++) {
            if (board[i][num - 1] == 0) {
                continue;
            }

            int item = board[i][num - 1];
            board[i][num - 1] = 0;
            return item;
        }

        return -1;
    }
}




