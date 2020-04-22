import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_17837 {
    static int N;
    static int K;
    static int[][] map;
    static LinkedList<Integer>[][] horseMap;
    static Horse[] horses;
    static int turn=1;
    static int[] dx = {0, 0, 0, -1, 1}; //우, 좌, 상, 하
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        horseMap = new LinkedList[N+1][N+1];
        horses = new Horse[K+1];

        /* 체스판 저장 */
        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            st = new StringTokenizer(input);

            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                horseMap[i][j] = new LinkedList<>();
            }
        }

        /*
        * 말 입력받고, horses 배열에 객체 저장
        * */
        for (int i = 1; i <= K; i++) {
            String input = br.readLine();
            st = new StringTokenizer(input);

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dir  = Integer.parseInt(st.nextToken());

            horses[i] = new Horse(x, y, dir);
            horseMap[x][y].add(i);
        }

        for(;turn < 1000; turn++) {
            for (int i = 1; i <= K; i++) {
                Horse h = horses[i]; //움직일 차례의 말

                int x = h.x;
                int y = h.y;

                int nx = h.x + dx[h.dir];
                int ny = h.y + dy[h.dir];

                if (!isRange(nx, ny)|| map[nx][ny] == 2) {
                    //범위를 벗어났거나, 다음 칸이 파란색인 경우
                    changeDir(h);
                    nx = h.x + dx[h.dir];
                    ny = h.y + dy[h.dir];
                }

                if (isRange(nx, ny) && map[nx][ny] != 2) {
                    //범위 내에 있고 파란색이 아닌 경우
                    if(map[nx][ny] == 0) {
                        //흰색
                        LinkedList<Integer> temp = new LinkedList<>();
                        int idx = horseMap[x][y].indexOf(i);
                        int len = horseMap[x][y].size();

                        for (int j = idx; j < len; j++) {
                            //새로운 좌표로 update
                            horses[horseMap[x][y].get(j)].x = nx;
                            horses[horseMap[x][y].get(j)].y = ny;
                        }

                        for (int j = idx; j < len; j++) {
                            temp.add(horseMap[x][y].pollLast());
                        }

                        while (!temp.isEmpty()) {
                            horseMap[nx][ny].add(temp.pollLast());
                            if (horseMap[nx][ny].size() >= 4) {
                                System.out.println(turn);
                                return;
                            }
                        }

                    } else {
                        //빨간색
                        LinkedList<Integer> temp = new LinkedList<>();
                        int idx = horseMap[x][y].indexOf(i);
                        int len = horseMap[x][y].size();

                        for (int j = idx; j < len; j++) {
                            //새로운 좌표로 update
                            horses[horseMap[x][y].get(j)].x = nx;
                            horses[horseMap[x][y].get(j)].y = ny;
                        }

                        for (int j = idx; j < len; j++) {
                            temp.add(horseMap[x][y].pollLast());
                        }

                        while (!temp.isEmpty()) {
                            horseMap[nx][ny].add(temp.pollFirst());
                            if (horseMap[nx][ny].size() >= 4) {
                                System.out.println(turn);
                                return;
                            }
                        }
                    }
                }
            }
        }
        turn = -1;
        System.out.println(turn);
    }

    static void changeDir(Horse h) {
        int dir = h.dir;
        switch (dir) {
            case 1 :
                h.dir = 2;
                break;
            case 2 :
                h.dir = 1;
                break;
            case 3 :
                h.dir = 4;
                break;
            case 4 :
                h.dir = 3;
                break;
        }
    }

    static boolean isRange(int x, int y) {
        //범위 안에 있으면 true
        return x >= 1 && x <= N && y >= 1 && y <= N;
    }

    static class Horse {
        int x; int y;
        int dir;

        public Horse(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}
