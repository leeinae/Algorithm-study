import java.util.Scanner;

public class BOJ_2441 {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            printStar(i);
        }
    }

    static void printStar(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < n - num; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
