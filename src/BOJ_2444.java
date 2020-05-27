import java.util.Scanner;

public class BOJ_2444 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int line = (2 * num) - 1;

        int i;
        for (i = 1; i <= num; i++) {
            int temp = (2 * i) - 1;
            printGap((line - temp) / 2);
            printStar(temp);
        }

        for (i = 1; i <= num - 1; i++) {
            int temp = line - (2 * i);
            printGap(i);
            printStar(temp);
        }
    }

    static void printStar(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    static void printGap(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" ");
        }
    }
}
