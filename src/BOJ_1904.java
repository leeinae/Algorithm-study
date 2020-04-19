import java.util.Scanner;

public class BOJ_1904 {
    static int[] t_case;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        t_case = new int[N+1];
        int num = dp(N);
        System.out.println(num);
    }

    static int dp(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        if (t_case[n] != 0) {
            return t_case[n];
        } else {
            t_case[n] = (dp(n-1) + dp(n -2)) % 15746;
            return t_case[n];
        }
    }
}
