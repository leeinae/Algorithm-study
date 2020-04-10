import java.util.Scanner;

public class BOJ_2588 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        solve(A, B);
    }

    public static void solve(int n1, int n2) {
        int temp = n2;
        while (temp > 0) {
            System.out.println(n1 * (temp % 10));
            temp = temp / 10;
        }
        System.out.println(n1 * n2);
    }
}
