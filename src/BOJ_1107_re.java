import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1107_re {
    static List<Integer> remote = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int channel = Integer.parseInt(br.readLine()); // 채널 번호
        int brokenButton = Integer.parseInt(br.readLine()); // 고장난 버튼 수
        int answer = Math.abs(100 - channel); // +- 버튼으로 이동하는 경우

        // 고장난 리모컨 버튼
        // BufferedReader.. 입력 없을 때 br.readLine() 해주면 런타임 에러가 난다,,
        if (brokenButton > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                remote.add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < 1000000; i++) {
            int len = getPossibleLength(i); // 누를 수 있는 버튼의 길이
            int adjacentChannel = Math.abs(channel - i);

            answer = len > 0 ? Math.min(answer, len + adjacentChannel) : answer;
        }

        System.out.println(answer);
    }

    static int getPossibleLength(int target) {
        int len = 0;
        if (target == 0) return remote.contains(0) ? 0 : 1;

        while (target > 0) {
            if (remote.contains(target % 10)) return 0;

            len++;
            target /= 10;
        }

        return len;
    }
}
