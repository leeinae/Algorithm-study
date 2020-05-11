import java.util.Scanner;

public class Hanoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        move(n, 1, 3);
    }

    //no번째 원판을 x번 기둥 -> y번 기둥
    public static  void move(int no, int x, int y) {
        if (no > 1) {
            move(no - 1, x, 6 - x - y);
        }

        System.out.println(no + "번째 원판을 " + x + " -> " + y);

        if (no > 1) {
            move(no - 1, 6 - x - y, y);
        }
    }
}
