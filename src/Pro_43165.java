import java.util.Queue;
import java.util.LinkedList;

class Pro_43165 {
    static boolean[] visited;
    static int answer;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0);
        return answer;
    }

    public void dfs(int[] numbers, int target, int index) {
        if(index == numbers.length) {
            int sum =0;

            for(int num : numbers) {
                sum += num;
            }

            if(sum == target) {
                answer++;
            }
        } else {
            int num = numbers[index];

            numbers[index] = num * -1;
            dfs(numbers, target, index+1);

            numbers[index] = num;
            dfs(numbers, target, index+1);
        }
    }
}