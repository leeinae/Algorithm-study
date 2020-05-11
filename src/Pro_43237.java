import java.util.Arrays;

public class Pro_43237 {
    public static void main(String[] args) {
        int[] budgets = {120, 110, 170, 150};

        System.out.println(solution(budgets, 500));
    }

    public static int solution(int[] budgets, int M) {
        int answer = 0;
        long sum = 0;
        int max = budgets[budgets.length-1];
        int min = 0;
        int mid = 0;
        int temp = 0;

        Arrays.sort(budgets);

        for (int i = 0; i < budgets.length; i++) {
            sum += budgets[i];
        }

        // 예산 내로 배정할 수 있는 경우
        if (sum < M) {
            return max;
        }

        while (true) {
            sum = 0;
            mid = (min + max) / 2;

            if (mid == temp) {
                break;
            }

            for (int i = 0; i < budgets.length; i++) {
                if (mid <= budgets[i]) {
                    sum += mid * (budgets.length - i);
                    break;
                } else {
                    sum += budgets[i];
                }
            }

            if (sum <= M) {
                min = mid;
            } else {
                max = mid;
            }
            temp = mid;
        }
        answer = mid;

        return answer;
    }
}
