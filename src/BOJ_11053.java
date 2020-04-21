import java.util.Scanner;

public class BOJ_11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] num = new int[N+1];
        int[] index = new int[N+1];
        int max = 0;

        for (int i = 1; i <= N; i++) {
            num[i] = sc.nextInt();
            index[i] = 1; //num[i]의 값이 같을 경우에 사용 ..
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                if ( num[i] > num[j] && index[i] <= index[j]) {
                    index[i] = index[j] + 1;
                }
            }
        }

        for( int i: index) {
            max = Math.max(i, max);
        }

        System.out.println(max);
    }
}
