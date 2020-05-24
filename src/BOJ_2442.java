import java.util.Scanner;

public class BOJ_2442 {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            int star = 2 * i - 1;
            int gap = (2 * n) - 1 - star;

            printGap(gap / 2);
            printStar(star);
            System.out.println();
        }
    }

    static void printStar(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print("*");
        }
        System.out.print(" ");
    }

    static void printGap(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print(" ");
        }
    }
}
