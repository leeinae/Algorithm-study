import java.util.Scanner;
import java.util.Stack;

public class BOJ_12100 {
    public static final int UP = 1;
    public static final int DOWN = 2;
    public static final int RIGHT = 3;
    public static final int LEFT = 4;

    static int N;
    static int[][] map = new int[N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        map = new int[N][N];
        int maxInt = 0;

//        System.out.println(N + " * "+ N + "의 배열");

        /* 맵 생성 */
        for(int i=0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num = sc.nextInt();
                map[i][j] = num;
                maxInt = Math.max(maxInt, num);
            }
        }

        sc.close();

        System.out.println(maxInt);
    }

    public static void moveMap(int direction, int[][] map) {
        /*
        * direction 1 : UP
        * direction 2 : DOWN
        * direction 3 : RIGHT
        * direction 4 : LEFT
        */

        switch (direction) {
            case 1:
                for(int i=0; i<N; i++) {
                    for(int j=0; j<N; j++) {
                        if(i+1 < N) {

                        }
                    }
                }
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }
}

