import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");

        int n = Integer.parseInt(input[0]); //집
        int c = Integer.parseInt(input[1]); //공유기

        int[] house = new int[n];

        for (int i = 0; i < n; i++) {
            house[i] = sc.nextInt();
        }

        Arrays.sort(house);

        int start = 1; // 최소 거리
        int end = house[n - 1] - house[0]; // 최대 거리
        int answer = 0;
        int count = 0;

        while (start <= end) {
            int mid = (start + end) / 2;

            count = check(house, mid);
            if (count >= c) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(answer);
    }

    static int check(int[] house, int x) {
        int count = 1;
        int num = 0;
        int start = house[0];

        for (int i = 1; i < house.length; i++) {
            num = house[i] - start;
            if (num >= x) {
                count++;
                start = house[i];
            }
        }

        return count;
    }
}
