import java.util.Scanner;

public class BOJ_2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int idx = 9;
        int max = 0;
        int answer = 0;

        while(idx-- > 0) {
            int num = sc.nextInt();
            if (max < num) {
                answer = (9 - idx);
                max = num;
            }
        }

        System.out.println(max);
        System.out.println(answer);
    }
}
