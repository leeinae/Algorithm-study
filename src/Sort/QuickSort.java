package Sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 7, 9 ,3, 1};

        quickSort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int left, int right) {
        int p = arr[(left+right)/2];
        int pl = left;
        int pr = right;

        do {
            while (arr[pl] < p) pl++;
            while (arr[pr] > p) pr--;
            if (pl <= pr) {
                swap(arr, pl++, pr--);
            }
        } while (pl <= pr);

        if( left < pr ) quickSort(arr, left, pr);
        if( pl < right ) quickSort(arr, pl, right);
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
