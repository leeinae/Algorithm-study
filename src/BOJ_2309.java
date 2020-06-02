import java.util.Scanner;
import java.util.Arrays;

public class BOJ_2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dwarf = new int[9];

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            dwarf[i] = sc.nextInt();
            sum += dwarf[i];
        }

        Arrays.sort(dwarf);

        sum = sum - 100;

        for (int i = 0; i < 9; i++) {
            for (int j = i; j < 9; j++) {
                int temp = dwarf[i] + dwarf[j];

                if (sum == temp) {
                    print(i, j, dwarf);
                    return;
                }
            }
        }
    }

    static void print(int x, int y, int[] dwarf) {
        for (int i = 0; i < 9; i++) {
            if (i == x || i == y) {
                continue;
            }

            System.out.println(dwarf[i]);
        }
    }
}
