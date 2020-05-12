import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        pointer(arr, m);
    }

    static void pointer(int[] arr, int m) {
        int left = 1;
        int right = 1;
        int count = 0;
        int sum = 0;

        while (true) {
            if (sum >= m) {
                sum -= arr[left++];
            } else if (right == arr.length) {
                break;
            } else {
                sum += arr[right++];
            }

            if (sum == m) {
                count++;
            }
        }
        System.out.println(count);
    }
}
