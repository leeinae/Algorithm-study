import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_17140 {
    static int r;
    static int c;
    static int k;
    static int total = 0;
    static int[][] map;
    static ArrayList<Number> list;

    static class Number implements Comparable<Number> {
        int n; //숫자
        int count; //숫자가 등장한 횟수

        public Number(int n, int count) {
            this.n = n;
            this.count = count;
        }

        @Override
        public int compareTo(Number o) {
            if (this.count > o.count) {
                return 1;
            } else if(this.count == o.count) {
                if (this.n > o.n) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }
    }

    static void rOperation() {
        //행 정렬 연산..
        int[][] temp = new int[101][101];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < map.length; i++) {
            int[] count = new int[101];
            list = new ArrayList<>();
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] != 0) {
                    count[map[i][j]]++;
                }
            }

            for (int j = 1; j < count.length; j++) {
                if (count[j] != 0) {
                    list.add(new Number(j, count[j]));
                }
            }

            Collections.sort(list); //Number 객체 정렬

            int z = 0;
            for (int j = 0; j < list.size(); j++) {
                temp[i][z] = list.get(j).n;
                temp[i][z+1] = list.get(j).count;
                z += 2;
                max = Math.max(z, max);
            }
        }

        // 행이나 열이 100이 넘는 경우
        if(max > 100) {
            max = 100;
        }

        map = new int[map.length][max];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = temp[i][j];
            }
        }
    }

    static void cOperation() {
        //열 정렬 연산..
        int[][] temp = new int[101][101];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < map[0].length; i++) {
            int[] count = new int[101];
            list = new ArrayList<>();
            for (int j = 0; j < map.length; j++) {
                if (map[j][i] != 0) {
                    count[map[j][i]]++;
                }
            }

            for (int j = 1; j < count.length; j++) {
                if (count[j] != 0) {
                    list.add(new Number(j, count[j]));
                }
            }

            Collections.sort(list); //Number 객체 정렬

            int z = 0;
            for (int j = 0; j < list.size(); j++) {
                temp[z][i] = list.get(j).n;
                temp[z+1][i] = list.get(j).count;
                z += 2;
                max = Math.max(z, max);
            }
        }

        // 행이나 열이 100이 넘는 경우
        if(max > 100) {
            max = 100;
        }

        map = new int[max][map[0].length];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = temp[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[3][3];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            if (total > 100) {
                total = -1;
                break;
            }

            if (r-1 < map.length && c-1 < map[0].length) {
                if (map[r - 1][c - 1] == k) {
                    break;
                }
            }

            if (map.length >= map[0].length) {
                rOperation();
            } else {
                cOperation();
            }
            total++;
        }

        System.out.println(total);
    }
}

/*
 * 1. 전체 행 열을 받고 while True일동안.. -> A[r][c]의 값이 k랑 같으면..
 * 2. R연산, C연산 함수 만든다
 * 3. 연산 후 최대 행, 열 길이로 0을 채움..
 * */