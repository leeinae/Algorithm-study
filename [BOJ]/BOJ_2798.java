import java.io.IOException;
import java.util.Scanner;

public class BOJ_2798 {
    static int maxNum = -1;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        //사용할 수 있는 카드 수
        n = sc.nextInt();
        //최대 합이 넘지 않아야하는 수
        m = sc.nextInt();

        int[] card = new int[n];

        for(int i=0; i<n; i++) {
            card[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++ ) {
                for(int z= j+1; z<n; z++) {
                    int temp = card[i] + card[j] + card[z];

                    if(temp <= m) {
                        maxNum = Math.max(temp, maxNum);
                    }

                }
            }
        }

        System.out.println(maxNum);

    }
}
