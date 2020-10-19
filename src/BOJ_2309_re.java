import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309_re {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dwarf = new int[9];
        int total = 0;

        for (int i = 0; i < 9; i++) {
            total += (dwarf[i] = sc.nextInt());
        }

        calc(dwarf, total - 100);
    }

    static void calc(int[] dwarf, int diff) {
        for (int i = 0; i < dwarf.length; i++) {
            for (int j = 1; j < dwarf.length; j++) {
                if (dwarf[i] + dwarf[j] == diff) {
                    dwarf[i] = -1;
                    dwarf[j] = -1;

                    print(dwarf);
                    return;
                }
            }
        }
    }

    static void print(int[] dwarf) {
        Arrays.sort(dwarf);
        for (int num : dwarf) {
            if (num > 0) {
                System.out.println(num);
            }
        }
    }
}
