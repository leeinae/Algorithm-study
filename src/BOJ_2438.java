import java.util.Scanner;

public class BOJ_2438 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            printStar(i);
            System.out.println();
        }
    }

    static void printStar(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
    }
}
