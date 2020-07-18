import java.util.Scanner;

public class BOJ_2869 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a, b, v;
        a = sc.nextInt();
        b = sc.nextInt();
        v = sc.nextInt();

        int meter = a - b;
        v -= b;
        int value = v / meter;

        if (v - (meter * value) <= 0) {
            System.out.println(value);
        } else {
            System.out.println(value + 1);
        }
    }
}
