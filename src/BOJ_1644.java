import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1644 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] num = new int[n + 1];
        ArrayList<Integer> primeNum = new ArrayList<>();

        /*
        * 소수를 구할 때 에라토스테네스의 체를 이용함.
        * i보다 큰 i의 배수에 1 표시
        * 요소가 0인 값은 소수이다.
        * */
        for (int i = 2; i <= n; i++) {
            for (int j = i + i; j <= n; j += i) {
                num[j] = 1;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (num[i] == 0) {
                primeNum.add(i);
            }
        }

        solution(primeNum, n);
    }

    static void solution(ArrayList<Integer> primeNum, int n) {
        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;

        while (true) {

            if (sum >= n) {
                sum -= primeNum.get(left++);
            } else if (right == primeNum.size()) {
                break;
            } else {
                sum += primeNum.get(right++);
            }

            if (sum == n) {
                count++;
            }
        }

        System.out.println(count);
    }
}
