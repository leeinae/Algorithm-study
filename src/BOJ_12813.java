import java.io.IOException;
import java.util.Scanner;

public class BOJ_12813 {
    public static void main(String[] args) throws IOException {
        final int n = 100000;

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int[] a = new int[n];
        int[] b = new int[n];

        String input1 = sc.nextLine();
        String input2 = sc.nextLine();

        for (int i = 0; i < input1.length(); i++) {
            a[i] = input1.charAt(i)-'0';
            b[i] = input2.charAt(i)-'0';
        }

        for (int i = 0; i < input1.length(); i++) {
            sb.append(a[i] * b[i]);
        }
        sb.append("\n");

        for (int i = 0; i < input1.length(); i++) {
            sb.append(a[i] | b[i]);
        }
        sb.append("\n");

        for (int i = 0; i < input1.length(); i++) {
            sb.append(a[i] ^ b[i]);
        }
        sb.append("\n");

        for (int i = 0; i < input1.length(); i++) {
            sb.append(a[i] == 0 ? 1 : 0);
        }
        sb.append("\n");

        for (int i = 0; i < input1.length(); i++) {
            sb.append(b[i] == 0 ? 1 : 0);
        }
        sb.append("\n");

        System.out.println(sb);
    }
}
