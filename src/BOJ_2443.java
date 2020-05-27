import java.util.Scanner;

public class BOJ_2443 {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int temp = 2 * n - 1;
        for (int i = n; i > 0; i--) {
            int num = 2 * i - 1;
            printGap((temp - num)/2);
            printStar(num);
            System.out.println();
        }
    }

    static void printGap(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print(" ");
        }
    }

    static void printStar(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print("*");
        }
    }
}
