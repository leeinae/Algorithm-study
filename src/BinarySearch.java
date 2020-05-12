public class BinarySearch {
    public static int binarySearch(int[] a, int n, int key) {
        int pl = 0;
        int pr = n - 1;

        do {
            int pc = (pl + pr) / 2;
            if (a[pc] == key) {
                return pc;
            } else if (a[pc] > key) {
                pr = pc - 1;
            } else {
                pl = pc + 1;
            }
        } while (pl <= pr);
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 15, 28, 29, 31, 39, 58, 68};

        int idx = binarySearch(arr, arr.length, 28);

        if (idx == -1) {
            System.out.println("찾는 요소가 없습니다.");
        } else {
            System.out.println("arr[" + idx + "] 에 있습니다. ");
        }
    }
}
