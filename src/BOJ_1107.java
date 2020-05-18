import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1107 {
    static int channelNum;
    static HashSet<Integer> numbers = new HashSet<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        channelNum = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println(Math.min(isPossible(channelNum), Math.abs(channelNum - 100)));
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        solution(channelNum);
    }

    static void solution(int channel) {
        int answer = Math.abs(100 - channel);

        for (int i = 0; i <= 1000000; i++) { //가까운 채널로 이동
            int length = isPossible(i);

            if (length != 0) {
                int press = Math.abs(i - channel);
                answer = Math.min(answer, press + length);
            }
        }
        System.out.println(answer);
    }

    /*
    * 버튼을 누를 수 있는지 없는지 판단.
    * 누를 수 없으면 0 return
    * 누를 수 있으면 수의 길이 return
    * */
    static int isPossible(int channel) {
        int length = 0;

        if (channel == 0) {
            return numbers.contains(0) ? 0 : 1;
        }

        while(channel > 0) {
            int temp = channel % 10;
            if (numbers.contains(temp)) {
                return 0;
            }
            channel /= 10;
            length++;
        }
        return length;
    }
}
