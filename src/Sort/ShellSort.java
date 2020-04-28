package Sort;
import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 7, 9 ,3, 1};

        shellSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    static void shellSort(int[] arr) {
        int n = arr.length;
        for (int h = n / 2; h > 0; h /= 2) {
            for (int i = h; i < n; i++) {
                int j;
                int temp = arr[i];

                for (j = i - h; j >= 0 && arr[j] > temp; j -= h) {
                    arr[j+h] = arr[j];
                }
                arr[j+h] = temp;
            }
        }
    }
}
