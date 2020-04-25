package Sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 3, 6, 1, 9};

        insertionSort(arr);

        System.out.println(Arrays.toString(arr));;
    }

    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j;
            int temp = arr[i];
            for (j = i; j > 0 && arr[j-1] > temp ; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
    }

}

/*
* 1. 1번 인덱스부터 시작한다.
* 2. 이전에 있는 요소의 자리에 들어갈 수 있으면 넣는다. (요소가 밀린다.)
* */