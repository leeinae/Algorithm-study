import java.util.Scanner;

public class BOJ_4796 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = 0;
        while (sc.hasNextInt()) {
            count++;
            int l = sc.nextInt();
            int p = sc.nextInt();
            int v = sc.nextInt();

            if (l == 0 && p == 0 && v == 0) break;

            int active = (v / p) * l;
            active += Math.min(l, (v % p));
            System.out.println("Case " + count + ": " + active);
        }
    }
}
