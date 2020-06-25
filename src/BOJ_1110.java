import java.util.Scanner;

public class BOJ_1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int origin = sc.nextInt();
        int count = 0;

        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int temp = origin;

        while (true) {
            count++;

            if (temp < 10) {
                num1 = 0;
            } else {
                num1 = temp / 10;
            }
            num2 = temp % 10;

            num3 = (num1 + num2) % 10;

            temp = (num2 * 10) + num3;

            if (temp == origin) {
                System.out.println(count);
                return;
            }
        }
    }
}
