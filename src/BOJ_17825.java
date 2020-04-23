import java.util.Scanner;

public class BOJ_17825 {
    static int[] dice = new int[10];
    static int[] moves = new int[10]; //해당 인덱스 번에 움직일 말 번호 저장
    static int max_score;
    static Horse[] horses = new Horse[4];
    static int[][] lines = {
            {0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40},
            {10, 13, 16, 19},
            {20, 22, 24, 25, 30, 35, 40},
            {30, 28, 27, 26}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        max_score = Integer.MIN_VALUE;

        // 이동할 주사위 값
        for (int i = 0; i < 10; i++) {
            dice[i] = sc.nextInt();
        }

        // 말 초기화
        for (int i = 0; i < 4; i++) {
            horses[i] = new Horse(i);
        }

        dfs(0);
        System.out.println(max_score);
    }

    static void dfs(int num) {
        if (num == 10) {
            for (int i = 0; i < 4; i++) {
                horses[i].line = 0;
                horses[i].pos = 0;
            }

            int score = 0;
            for (int i = 0; i < 10; i++) {
                boolean flag = horses[moves[i]].move(dice[i]);
                if (flag) {
                    int h_line = horses[moves[i]].line; //행
                    int h_pos = horses[moves[i]].pos; //열

                    if (h_line == 2 && h_pos == 7)
                        continue;
                    else
                        score += lines[h_line][h_pos];
                } else {
                    return;
                }
            }

            max_score = Math.max(max_score, score);
            return;
        }

        for (int i = 0; i < 4; i++) {
            moves[num] = i;
            dfs(num+1);
        }
    }

    static class Horse {
        int pos; //lines[] 배열에서의 인덱스
        int line;
        int index;

        public Horse(int index) {
            this.index = index;
            this.pos = 0;
            this.line = 0;
        }

        public boolean move(int m) {
            int next = pos + m; //현재 위치 + dice 값
            int nline = line;

            switch (line) {
                case 0: // 빨간 라인
                    if (next == 5) { //10
                        nline = 1;
                        next = 0;
                    } else if (next == 10) { //20
                        nline = 2;
                        next = 0;
                    } else if (next == 15) { //30
                        nline = 3;
                        next = 0;
                    } else if (next == 20) { //40
                        nline = 2;
                        next = 6;
                    } else if (next > 20) {
                        nline = 2;
                        next = 7;
                    }
                    break;
                case 1: // 10 라인
                case 3: // 30 라인
                    if (next > 3) {
                        nline = 2;
                        next--;
                        if (next > 6) {
                            next = 7;
                        }
                    }
                    break;
                case 2: // 20 라인
                    if (next > 6) {
                        next = 7;
                    }
                    break;
            }

            /*
            * 종료 조건 (line ==2 && next==7)
            * 무조건 20라인에서 종료하게됨.
            * 10번 라인에서 25가 되면 -> 20번 라인 보내주고
            * 30번 라인에서도 20라인 보내줌
            */
            if (nline == 2 && next == 7) {
                line = nline;
                pos = next;
                return true;
            }

            // 해당 위치에 이미 말이 있으면 false
            for (int i = 0; i < 4; i++) {
                if (index == i)
                    continue;
                if (horses[i].line == 2 && horses[i].pos == 7)
                    continue;
                if (horses[i].line == 0 && horses[i].pos == 0)
                    continue;

                if (horses[i].line == nline && horses[i].pos == next) {
                    return false;
                }
            }

            line = nline;
            pos = next;
            return true;
        }
    }
}
