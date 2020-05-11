import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_1914_Hanoi {
    static int k;
    static int n;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        n = sc.nextInt();

        BigInteger binary = new BigInteger("2");
        BigInteger k = binary.pow(n).subtract(BigInteger.ONE);
        sb.insert(0, k +"\n");

        if (n <= 20) {
            move(n, 1, 3);
        }

        System.out.println(sb);
    }

    //no번째 원판을 x번 기둥 -> y번 기둥
    public static void move(int no, int x, int y) {
        if (no == 1) {
            sb.append(x + " " + y + "\n");
            return;
        }

        move(no - 1, x, 6 - x - y);
        sb.append(x + " " + y + "\n");
        move(no - 1, 6 - x - y, y);
    }
}

