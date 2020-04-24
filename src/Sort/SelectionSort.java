package Sort;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 3, 6, 1 ,9};
        selectionSort(arr);

        for (int n : arr) {
            System.out.println(n);
        }
    }

    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}
