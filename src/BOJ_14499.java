import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14499 {
    static int[][] map; //전체 지도
    static int[] dice = {0, 0, 0, 0, 0, 0, 0}; //주사위 도면
    static int[] dx = {0, 0, 0, -1, 1}; // X, 동, 서, 북, 남
    static int[] dy = {0, 1, -1, 0, 0};
    static int loc_x, loc_y, comm; //주사위 x, y 좌표, 명령 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        loc_x = Integer.parseInt(st.nextToken()); //주사위 x
        loc_y = Integer.parseInt(st.nextToken()); //주사위 y
        comm = Integer.parseInt(st.nextToken()); //명령 수

        /* 지도 생성 */
        for(int r=0; r<N; r++) {
            input = br.readLine();
            st = new StringTokenizer(input);
            for(int c=0; c<M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        String[] command = br.readLine().split(" "); //명령이 들어있는 배열

        rollDice(command);
    }

    public static void rollDice(String[] command) {
        for(int i=0; i<comm; i++) {
            int num = Integer.parseInt(command[i]);

            loc_x += dx[num];
            loc_y += dy[num];

            /* 지도를 벗어나는지 검사~ */
            if (loc_x < 0 || loc_x >= map.length || loc_y < 0 || loc_y >= map[0].length) {
                //범위를 벗어나면 다시 좌표를 되돌린다
                loc_x -= dx[num];
                loc_y -= dy[num];
                continue;
            }

            changeDice(num);
            checkMap(dice[6]);
        }
    }

    public static void changeDice(int num){
        int[] dice_clone = dice.clone();
        switch (num) {
            case 1: //동
                dice[1] = dice_clone[4]; //위
                dice[6] = dice_clone[3]; //아래
                dice[3] = dice_clone[1]; //동
                dice[4] = dice_clone[6]; //
                break;
            case 2: //서
                dice[1] = dice_clone[3];
                dice[4] = dice_clone[1];
                dice[3] = dice_clone[6];
                dice[6] = dice_clone[4];
                break;
            case 3: //북
                dice[1] = dice_clone[5];
                dice[6] = dice_clone[2];
                dice[2] = dice_clone[1];
                dice[5] = dice_clone[6];
                break;
            case 4: //남
                dice[6] = dice_clone[5];
                dice[1] = dice_clone[2];
                dice[5] = dice_clone[1];
                dice[2] = dice_clone[6];
                break;
        }
    }

    public static void checkMap(int diceNum) {
        //주사위 바닥이랑 Map을 비교해서 같으면 어쩌구 다르면 어쩌구
        if(map[loc_x][loc_y] == 0) {
            map[loc_x][loc_y] = diceNum;
        } else {
            dice[6] = map[loc_x][loc_y];
            map[loc_x][loc_y] = 0;
        }
        System.out.println(dice[1]);
    }

}
